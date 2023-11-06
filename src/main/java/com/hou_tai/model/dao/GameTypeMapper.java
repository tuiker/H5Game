package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hou_tai.model.pojo.GameType;

public interface GameTypeMapper extends BaseMapper<GameType> {
    int deleteByPrimaryKey(Integer id);

    int insert(GameType record);

    int insertSelective(GameType record);

    GameType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameType record);

    int updateByPrimaryKey(GameType record);
}