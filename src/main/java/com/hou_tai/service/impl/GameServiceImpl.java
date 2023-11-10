package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.enums.HomeEnums;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.final_common.CommonString;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.dto.MobileGameDto;
import com.hou_tai.model.dto.MobileGameReviewDto;
import com.hou_tai.model.dto.MobileHomeGameDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameType;
import com.hou_tai.model.pojo.Language;
import com.hou_tai.model.pojo.UserInfo;
import com.hou_tai.response_vo.GameVo;
import com.hou_tai.response_vo.MobileGameHomeVo;
import com.hou_tai.response_vo.MobileGameReviewVo;
import com.hou_tai.response_vo.MobileGameVo;
import com.hou_tai.service.IGameReviewService;
import com.hou_tai.service.IGameService;
import com.hou_tai.service.IReviewReplyService;
import com.hou_tai.util.BeanUtil;
import com.hou_tai.util.SystemNumUtil;
import jakarta.annotation.Resource;
import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
    IReviewReplyService reviewReplyService;

    public Game queryById(Long id) {
        return this.getById(id);
    }

    public MobileGameVo getVoById(MobileGameDto dto) {
        MobileGameVo mobileGameVo = this.baseMapper.selectJoinOne(MobileGameVo.class, new MPJLambdaWrapper<Game>()
                .selectAll(Game.class)
                .select("gt.type_name,l.language_name")
                .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                .eq(Game::getId, dto.getGameId()));
        if (mobileGameVo != null) {
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
        return mobileGameVo;
    }

    public GameVo getVoById(Long id) {
        GameVo gameVo = this.baseMapper.selectJoinOne(GameVo.class, new MPJLambdaWrapper<Game>()
                .selectAll(Game.class)
                .select("gt.type_name,l.language_name")
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
                        .select("u.user_name,l.language_name,gt.type_name")
                        .select("(select IFNULL(count(1),0) from game_review gr where gr.game_id=t.id) real_review_num")
                        .leftJoin(UserInfo.class, "u", UserInfo::getId, Game::getCreateId)
                        .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                        .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType));
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    public Game insert(Game game) {
        long gameId = getGameId();
        //game.setUpdateId(game.getCreateId());
        game.setId(gameId);
        game.setApkName(getApkName(game.getGameUrl()));
        //生成落地页，注意环境不同，地址不一样
        game.setGameFallUrl(CommonString.TEST_FALL_URL + gameId);
        this.save(game);
        return game;
    }

    /**
     * 更新数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    public Game update(Game game) {
        LambdaUpdateWrapper<Game> wrapper = new LambdaUpdateWrapper<Game>();
        wrapper.set(StrUtil.isNotBlank(game.getGameName()), Game::getGameName, game.getGameName())
                .set(StrUtil.isNotBlank(game.getGameLogo()), Game::getGameLogo, game.getGameLogo())
                .set(StrUtil.isNotBlank(game.getGameMainLogo()), Game::getGameMainLogo, game.getGameMainLogo())
                .set(StrUtil.isNotBlank(game.getGameBackground()), Game::getGameBackground, game.getGameBackground())
                .set(StrUtil.isNotBlank(game.getGameUrl()), Game::getGameUrl, game.getGameUrl())
                .set(StrUtil.isNotBlank(game.getGameDesc()), Game::getGameDesc, game.getGameDesc())
                .set(StrUtil.isNotBlank(game.getDataSecurity()), Game::getDataSecurity, game.getDataSecurity())
                .set(StrUtil.isNotBlank(game.getDevEmail()), Game::getDevEmail, game.getDevEmail())
                .set(StrUtil.isNotBlank(game.getDevUrl()), Game::getDevUrl, game.getDevUrl())
                .set(StrUtil.isNotBlank(game.getGameLabel()), Game::getGameLabel, game.getGameLabel())
                //.set(game.getUpdateId() > 0, Game::getUpdateId, game.getUpdateId())
                .set(Game::getUpdateTime, LocalDateTime.now())
                .set(game.getGameAge() != null, Game::getGameAge, game.getGameAge())
                .set(game.getReviewNum() != null, Game::getReviewNum, game.getReviewNum())
                .set(game.getGameGrade() != null, Game::getGameGrade, game.getGameGrade())
                .set(game.getGameDownload() != null, Game::getGameDownload, game.getGameDownload())
                .set(game.getUpdateTime() != null, Game::getUpdateTime, game.getUpdateTime());
        //2. 设置主键，并更新
        wrapper.eq(Game::getId, game.getId());
        this.update(wrapper);
        //3. 更新成功了，查询最最对象返回
        return game;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Long id) {
        return this.removeById(id);
    }

    public List<GameVo> listByGame() {
        List<GameVo> volist = Arrays.asList();
        List<Game> list = this.list(new LambdaQueryWrapper<Game>().select(Game::getId, Game::getGameName));
        if (CollectionUtil.isNotEmpty(list)) {
            volist = BeanUtil.copyListProperties(list, GameVo.class);
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


    public Page<MobileGameVo> pageForMobile(MobileGameDto dto) {
        Page<MobileGameVo> pagin = this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(), dto.getPageSize()),
                MobileGameVo.class, new MPJLambdaWrapper<Game>()
                        .select(Game::getId, Game::getGameName, Game::getGameLogo, Game::getGameGrade, Game::getGameLabel, Game::getGameType)
                        .select("l.language_name,gt.type_name")
                        .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                        .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                        .eq(dto.getGameType() != null && dto.getGameType() > 0, Game::getGameType, dto.getGameType())
                        .notIn(dto.getGameId() != null, Game::getId, dto.getGameId())
        );
        //3. 返回结果
        return pagin;
    }

    public Page<MobileGameVo> pageForMobileHome(MobileHomeGameDto dto) {
        Page<MobileGameVo> pagin = this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(), dto.getPageSize()),
                MobileGameVo.class, new MPJLambdaWrapper<Game>()
                        .select(Game::getId, Game::getGameName, Game::getGameLogo, Game::getGameMainLogo, Game::getGameGrade, Game::getGameLabel, Game::getGameType)
                        .select("l.language_name,gt.type_name")
                        .leftJoin(Language.class, "l", Language::getId, Game::getLanguageId)
                        .leftJoin(GameType.class, "gt", GameType::getId, Game::getGameType)
                        .eq(dto.getLanguageId() != null && dto.getLanguageId() > 0, Game::getLanguageId, dto.getLanguageId())
        );
        //3. 返回结果
        return pagin;
    }

    public List<MobileGameHomeVo> getHomeTypeList(MobileHomeGameDto dto) {
        if (dto.getHomeType() == null) {
            dto.setHomeType(CommonNum.ZERO);
        }
        //此处暂时用全数据
        Page<MobileGameVo> page = pageForMobileHome(dto);
        List<MobileGameHomeVo> list = new ArrayList<>();
        MobileHomeGameDto gameDto = dto;
        //如果搜索带参了 则只传对应的 其他的不传
        Stream.of(HomeEnums.values()).forEach(e -> {
            list.add(MobileGameHomeVo.builder().gameVoList((gameDto.getHomeType() == CommonNum.ZERO || e.getCode() == gameDto.getHomeType())
                    ? page.getRecords() : null).homeType(e.getCode()).build());
        });
        return list;
    }

    public Page<MobileGameVo> pageForHomeType(MobileHomeGameDto dto) {
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
            if(active!=null&&!active.equals("dev")){//非开发则替换路径
                apkUrl = apkUrl.replace("\\", "/").replaceAll(mobilePath,filePath);
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
