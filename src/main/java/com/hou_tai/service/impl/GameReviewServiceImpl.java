package com.hou_tai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.enums.GameTypeEnums;
import com.hou_tai.enums.LanguageTypeEnum;
import com.hou_tai.enums.ReviewGradeEnum;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.base.PageDaoEntity;
import com.hou_tai.model.dao.GameReviewMapper;
import com.hou_tai.model.dto.MobileGameReviewDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.model.pojo.UserInfo;
import com.hou_tai.response_vo.GameReviewVo;
import com.hou_tai.response_vo.GameReviewPageVo;
import com.hou_tai.response_vo.MobileGameReviewVo;
import com.hou_tai.service.IGameReviewService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: GameServiceImpl
 * @Description: 游戏实现
 * @Author: Sam
 * @Date: 2023-11-04 11:39
 * @Version: 1.0
 **/
@Service
@AllArgsConstructor
public class GameReviewServiceImpl extends ServiceImpl<GameReviewMapper, GameReview> implements IGameReviewService {
    @Resource
    private GameReviewMapper gameReviewMapper;

    @Override
    public Page<GameReviewPageVo> getReviewPage(PageDaoEntity pageDao) {
        Page<GameReviewPageVo> gameReviewPageVoPage = gameReviewMapper.getReviewPage(new Page<>(pageDao.getPage(), pageDao.getPageSize()));
        //处理 reviewGrade
        List<GameReviewPageVo> list = gameReviewPageVoPage.getRecords();
        if (ObjectUtils.isNotNull(list) && list.size() > CommonNum.ZERO) {
            list.forEach(one -> {
                one.setReviewGrade(ReviewGradeEnum.getValue(Integer.valueOf(one.getReviewGrade())));
            });
        }
        return gameReviewPageVoPage;
    }

    @Override
    public GameReviewPageVo getGameReviewById(Integer id) {
        GameReviewPageVo gameReviewPageVo = gameReviewMapper.getGameReviewById(id);
        //处理游戏语言、游戏类型
        if (ObjectUtils.isNotNull(gameReviewPageVo)) {
            gameReviewPageVo.setGameType(GameTypeEnums.getValue(Integer.valueOf(gameReviewPageVo.getGameType())));
            gameReviewPageVo.setGameLanguage(LanguageTypeEnum.getValue(Integer.valueOf(gameReviewPageVo.getGameLanguage())));
        }
        return gameReviewPageVo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    public GameReview queryById(Integer id) {
        return this.baseMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return
     */
    public Page<MobileGameReviewVo> pageQuery(MobileGameReviewDto dto) {
        Page<MobileGameReviewVo> pagin=this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(),dto.getPageSize()) ,
                MobileGameReviewVo.class, new MPJLambdaWrapper<GameReview>()
                .selectAll(GameReview.class)
                .select("u.user_name,u.user_img,g.game_name,ru.user_name")
                .leftJoin(UserInfo.class,"u", UserInfo::getId,GameReview::getUserId)
                .leftJoin(Game.class,"g", Game::getId,GameReview::getGameId)
                .leftJoin(UserInfo.class,"ru", UserInfo::getId,GameReview::getReplyUserId)
                .eq(dto.getGameId()!=null&&dto.getGameId()>0,GameReview::getGameId,dto.getGameId())
                .eq(dto.getReviewGrade()!=null&&dto.getReviewGrade()>0,GameReview::getReviewGrade,dto.getReviewGrade())
        );
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    public GameReview insert(GameReview gameReview) {
        gameReview.setReviewTime(LocalDateTime.now());
        this.save(gameReview);
        return gameReview;
    }

    /**
     * 更新数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    public GameReview update(GameReview gameReview) {
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<GameReview> chainWrapper = new LambdaUpdateChainWrapper<GameReview>(this.baseMapper);
        if (StrUtil.isNotBlank(gameReview.getReviewContent())) {
            chainWrapper.eq(GameReview::getReviewContent, gameReview.getReviewContent());
        }
        //2. 设置主键，并更新
        chainWrapper.set(GameReview::getId, gameReview.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if (ret) {
            return queryById(gameReview.getId());
        } else {
            return gameReview;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id) {
        int total = baseMapper.deleteById(id);
        return total > 0;
    }

    @Override
    public boolean addHelpNum(MobileGameReviewDto dto) {
        return this.baseMapper.addHelpNum(dto) > CommonNum.ZERO ? true : false;
    }

    @Override
    public boolean saveReply(GameReview gameReview) {
        LambdaUpdateWrapper<GameReview> wrapper = new LambdaUpdateWrapper<GameReview>();
        wrapper.set(GameReview::getReplyContent, gameReview.getReplyContent())
                .set(GameReview::getHaveReply, CommonNum.ONE)
                .set(GameReview::getReplyUserId, gameReview.getReplyUserId())
                //.set(GameReview::getReviewGrade,gameReview.getReviewGrade())
                .set(GameReview::getReplyTime, LocalDateTime.now())
                .eq(GameReview::getId, gameReview.getId());
        return this.update(wrapper);
    }


}
