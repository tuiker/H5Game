package com.hou_tai.model.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.model.pojo.Game;

public interface GameMapper  extends MPJBaseMapper<Game> {
    int deleteByPrimaryKey(Integer id);

    int insert(Game record);

    int insertSelective(Game record);

    Game selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Game record);

    int updateByPrimaryKey(Game record);
}