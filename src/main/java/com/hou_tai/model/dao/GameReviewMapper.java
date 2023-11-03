package com.hou_tai.model.dao;

import com.hou_tai.model.pojo.GameReview;

public interface GameReviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameReview record);

    int insertSelective(GameReview record);

    GameReview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameReview record);

    int updateByPrimaryKey(GameReview record);
}