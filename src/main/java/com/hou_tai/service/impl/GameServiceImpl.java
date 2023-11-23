package com.hou_tai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dto.*;
import com.hou_tai.model.pojo.*;
import com.hou_tai.response_vo.GameVo;
import com.hou_tai.response_vo.MobileGameHomeVo;
import com.hou_tai.response_vo.MobileGameReviewVo;
import com.hou_tai.response_vo.MobileGameVo;
import com.hou_tai.service.*;
import com.hou_tai.util.SystemNumUtil;
import jakarta.annotation.Resource;
import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: GameServiceImpl
 * @Description: 游戏实现
 * @Author: Sam
 * @Date: 2023-11-04 11:39
 * @Version: 1.0
 **/
@Service
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements IGameService {
    @Resource
    IGameReviewService gameReviewService;

    @Resource
    IGameTriggerService gameTriggerService;

    @Resource
    IReviewReplyService reviewReplyService;

    @Resource
    private IGameExtendService gameExtendService;

    @Value("${lanBo.fall.path:}")
    private String fallPath;

    public Game queryById(Long id) {
        return this.getById(id);
    }

    public MobileGameVo getVoById(MobileGameDto dto) {
        Boolean result = this.baseMapper.exists(new LambdaQueryWrapper<Game>().eq(Game::getApkName, dto.getGameApkName()));
        if (result) {
            MobileGameVo mobileGameVo = null;
            List<MobileGameVo> mobileGameVoList = this.baseMapper.selectJoinList(MobileGameVo.class, new MPJLambdaWrapper<Game>()
                    .selectAll(Game.class)
                    .select("ga.user_name, ga.apk_link, ga.script_desc, gt.type_name, l.language_name")
                    .leftJoin(GameExtend.class, "ga", GameExtend::getGameId, Game::getId)
                    .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                    .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                    //.eq(Game::getId, dto.getGameId())
                    .eq(Game::getApkName, dto.getGameApkName()));
            if (CollectionUtil.isNotEmpty(mobileGameVoList)) {
                mobileGameVo = mobileGameVoList.get(0);
                //加载评论
                MobileGameReviewDto grDto = new MobileGameReviewDto();
                grDto.setGameId(dto.getGameId());
                grDto.setPage(dto.getPage());
                grDto.setPageSize(dto.getPageSize());
                Page<MobileGameReviewVo> reviewPage = gameReviewService.pageQuery(grDto);
                if (reviewPage.getTotal() > 0) {
                    List<MobileGameReviewVo> grList = reviewPage.getRecords();
                    //回复数据
                    mobileGameVo.setGameReviewList(grList);
                }
            }
            //更新请求数据
            GameTrigger gameTrigger = new GameTrigger();
            gameTrigger.setCreateTime(LocalDateTime.now());
            gameTrigger.setType(CommonNum.ONE);
            gameTrigger.setGameId(mobileGameVo.getId());
            gameTriggerService.insert(gameTrigger);
            return mobileGameVo;
        }
        return null;
    }

    public GameVo getVoById(Long id) {
        GameVo gameVo = this.baseMapper.selectJoinOne(GameVo.class, new MPJLambdaWrapper<Game>()
                .selectAll(Game.class)
                .select("ga.user_name, ga.apk_link, ga.script_desc, gt.type_name, l.language_name")
                .leftJoin(GameExtend.class, "ga", GameExtend::getGameId, Game::getId)
                .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                .eq(Game::getId, id));
        return gameVo;
    }

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return
     */
    public Page<GameVo> paginQuery(GameDto dto) {
        Page<GameVo> pagin = this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(), dto.getPageSize()),
                GameVo.class, new MPJLambdaWrapper<Game>()
                        .selectAll(Game.class)
                        .select("ga.user_name, ga.apk_link, ga.script_desc, l.language_name, gt.type_name")
                        .select("(select IFNULL(count(1),0) from game_review gr where gr.game_id=t.id) real_review_num")
                        .leftJoin(GameExtend.class, "ga", GameExtend::getGameId, Game::getId)
                        .leftJoin(UserInfo.class, "u", UserInfo::getId, Game::getCreateId)
                        .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                        .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                        .orderByDesc(Game::getUpdateTime));
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param gameAddReqDTO 实例对象
     * @return 实例对象
     */
    @Transactional
    public Game insert(GameAddReqDTO gameAddReqDTO) {
        //转换对象
        Game game = BeanUtil.copyProperties(gameAddReqDTO, Game.class);
        long gameId = getGameId();
        game.setId(gameId);
        String apkName = getApkName(game.getGameUrl());
        game.setApkName(apkName);
        //生成落地页，注意环境不同，地址不一样
        game.setGameFallUrl(fallPath + apkName);
        game.setCreateTime(LocalDateTime.now());
        game.setUpdateTime(LocalDateTime.now());

        //游戏评分取4.6-4.9之间的随机数，四舍五入保留一位小数
        game.setGameGrade(RandomUtil.randomDouble(4.6, 4.9, 1, RoundingMode.HALF_UP));

        this.save(game);

        //创建并保存游戏APK扩展对象
        GameExtend gameExtend = BeanUtil.copyProperties(gameAddReqDTO, GameExtend.class);
        gameExtend.setGameId(gameId);
        gameExtendService.save(gameExtend);
        return game;
    }

    /**
     * 更新数据
     *
     * @param reqDTO 实例对象
     * @return 实例对象
     */
    @Transactional
    public Boolean update(GameUpdateReqDTO reqDTO) {
        String url = reqDTO.getGameUrl();
        String apkName = getApkName(url);
        LambdaUpdateWrapper<Game> wrapper = new LambdaUpdateWrapper<Game>();
        wrapper.set(StrUtil.isNotBlank(reqDTO.getGameName()), Game::getGameName, reqDTO.getGameName())
                .set(StrUtil.isNotBlank(reqDTO.getGameLogo()), Game::getGameLogo, reqDTO.getGameLogo())
                .set(StrUtil.isNotBlank(reqDTO.getGameMainLogo()), Game::getGameMainLogo, reqDTO.getGameMainLogo())
                .set(StrUtil.isNotBlank(reqDTO.getGameBackground()), Game::getGameBackground, reqDTO.getGameBackground())
                .set(Game::getGameUrl, url)
                .set(Game::getApkName, apkName)
                .set(Game::getGameFallUrl, fallPath + apkName)
                .set(StrUtil.isNotBlank(reqDTO.getGameDesc()), Game::getGameDesc, reqDTO.getGameDesc())
                .set(StrUtil.isNotBlank(reqDTO.getDataSecurity()), Game::getDataSecurity, reqDTO.getDataSecurity())
                .set(StrUtil.isNotBlank(reqDTO.getDevEmail()), Game::getDevEmail, reqDTO.getDevEmail())
                .set(StrUtil.isNotBlank(reqDTO.getDevUrl()), Game::getDevUrl, reqDTO.getDevUrl())
                .set(StrUtil.isNotBlank(reqDTO.getGameLabel()), Game::getGameLabel, reqDTO.getGameLabel())
                //.set(game.getUpdateId() > 0, Game::getUpdateId, game.getUpdateId())
                .set(Game::getUpdateTime, LocalDateTime.now())
                .set(reqDTO.getGameAge() != null, Game::getGameAge, reqDTO.getGameAge())
                .set(reqDTO.getReviewNum() != null, Game::getReviewNum, reqDTO.getReviewNum())
                .set(reqDTO.getGameGrade() != null, Game::getGameGrade, reqDTO.getGameGrade())
                .set(reqDTO.getGameDownload() != null, Game::getGameDownload, reqDTO.getGameDownload())
                .set(reqDTO.getGameUpdateTime() != null, Game::getGameUpdateTime, reqDTO.getGameUpdateTime());

        //2. 设置主键，并更新
        wrapper.eq(Game::getId, reqDTO.getId());
        this.update(wrapper);

        GameExtend gameExtend = BeanUtil.copyProperties(reqDTO, GameExtend.class);
        gameExtend.setId(null);
        gameExtend.setGameId(reqDTO.getId());
        gameExtendService.updateByGameId(gameExtend);

        //3. 更新成功了，查询最最对象返回
        return true;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Transactional
    public boolean deleteById(Long id) {
        this.removeById(id);
        //游戏是逻辑删除，那么此处的游戏APK扩展信息就不删了
        //删除游戏APK扩展信息
        //gameApkService.deleteByGameId(id);
        return true;
    }

    public List<GameVo> listByGame() {
        List<GameVo> volist = Arrays.asList();
        List<Game> list = this.list(new LambdaQueryWrapper<Game>().select(Game::getId, Game::getGameName));
        if (CollectionUtil.isNotEmpty(list)) {
            volist = BeanUtil.copyToList(list, GameVo.class);
        }
        return volist;
    }

    /**
     * @Description 生成游戏ID
     * @Author GaoLu
     * @Date 2023/11/7
     * @Return
     **/
    private long getGameId() {
        String num = SystemNumUtil.getRandomNumberByNum(CommonNum.FOUR);
        long allNum = this.count();
        String gameId = num + allNum;
        return Long.valueOf(gameId);
    }

    public Page<MobileGameHomeVo> pageForMobile(MobileGameDto dto) {
        Page<MobileGameHomeVo> pagin = this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(), dto.getPageSize()),
                MobileGameHomeVo.class,
                new MPJLambdaWrapper<Game>()
                        .select(Game::getGameName, Game::getGameLogo, Game::getGameMainLogo, Game::getGameGrade, Game::getGameLabel, Game::getGameType, Game::getApkName)
                        .select("l.language_name,gt.type_name")
                        .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                        .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                        .orderByDesc(Game::getCreateTime)
                        .eq(dto.getGameType() != null && dto.getGameType() > 0, Game::getGameType, dto.getGameType())
                        .notIn(dto.getGameId() != null, Game::getId, dto.getGameId()
                        )
        );
        //3. 返回结果
        return pagin;
    }

    public Page<MobileGameHomeVo> pageForMobileHome(MobileHomeGameDto dto) {
        Page<MobileGameHomeVo> pagin = this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(), dto.getPageSize()), MobileGameHomeVo.class,
                new MPJLambdaWrapper<Game>()
                        .select(Game::getGameName, Game::getGameLogo, Game::getGameMainLogo, Game::getGameGrade, Game::getGameLabel, Game::getGameType, Game::getApkName)
                        .select("l.language_name,gt.type_name")
                        .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                        .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                        .orderByDesc(Game::getCreateTime)
                        .eq(dto.getLanguageId() != null && dto.getLanguageId() > 0, Game::getLanguageId, dto.getLanguageId())
        );
        //3. 返回结果
        return pagin;
    }

    public Page<MobileGameHomeVo> pageForHomeType(MobileHomeGameDto dto) {
        //具体类型的实现在此处
        return pageForMobileHome(dto);
    }

    @Value("${spring.profiles.active:}")
    private String active;

    @Value("${lanBo.mobile.path:}")
    private String mobilePath;

    @Value("${lanBo.file.path:}")
    private String filePath;

    /**
     * @Description
     * @Author GaoLu
     * @Date 2023/11/10
     * @Return APK 包名
     * @Param apkUrl APK路径
     **/
    private String getApkName(String apkUrl) {
        //获取APK包名
        ApkFile apkFile;
        ApkMeta apkMeta;
        try {
            if (active != null && !active.equals("dev")) {//非开发则替换路径
                apkUrl = apkUrl.replace("\\", "/").replaceAll(mobilePath, filePath);
            }
            apkFile = new ApkFile(new File(apkUrl));
            apkMeta = apkFile.getApkMeta();
            System.out.println(apkMeta.getPackageName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return apkMeta.getPackageName();
    }

}
