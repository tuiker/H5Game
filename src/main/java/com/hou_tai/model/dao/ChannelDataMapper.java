package com.hou_tai.model.dao;

import com.hou_tai.model.pojo.ChannelData;

public interface ChannelDataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelData record);

    int insertSelective(ChannelData record);

    ChannelData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelData record);

    int updateByPrimaryKey(ChannelData record);
}