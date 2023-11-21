package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.model.dto.MobileGameReviewDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.response_vo.GameReviewPageVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface GameReviewMapper extends MPJBaseMapper<GameReview> {
    String pageListSql = "SELECT ga.id gameId,ga.game_name gameName,gr.review_content reviewContent,gr.reply_content replyContent," +
            "gr.review_grade reviewGrade,gr.review_time reviewTime,gr.have_reply haveReply,gr.id id  "
            + "FROM game_review gr LEFT JOIN game ga ON gr.game_id = ga.id where ga.deleted!=1 order by gr.review_time desc";

    /**
     * @Description 连表分页查询 游戏评论列表
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     * @Param page
     **/
    @Select(pageListSql)
    Page<GameReviewPageVo> getReviewPage(Page page);

    /**
     * @Description 根据 游戏评论ID找 游戏评论详情
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     * @Param id
     **/
    GameReviewPageVo getGameReviewById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(GameReview record);

    int insertSelective(GameReview record);

    GameReview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameReview record);

    int updateByPrimaryKey(GameReview record);

    int addHelpNum(@Param("dto") MobileGameReviewDto dto);
}