package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.GameReview;
import org.apache.ibatis.annotations.Param;

public interface GameReviewMapper extends MPJBaseMapper<GameReview> {
    int deleteByPrimaryKey(Integer id);

    int insert(GameReview record);

    int insertSelective(GameReview record);

    GameReview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameReview record);

    int updateByPrimaryKey(GameReview record);

    int addHelpNum(@Param("dto") PointDto dto);
}