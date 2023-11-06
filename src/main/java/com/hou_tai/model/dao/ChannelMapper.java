package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hou_tai.model.pojo.Channel;

public interface ChannelMapper extends BaseMapper<Channel> {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}