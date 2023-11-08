package com.hou_tai.model.dao;

import com.hou_tai.model.pojo.ChannelData;
import com.hou_tai.response_vo.DataOfTimeVo;

import java.util.List;

public interface ChannelDataMapper {
    /**
     * @Description 获取今天请求次数
     * @Author GaoLu
     * @Date 2023/11/8
     * @Return 总数
     **/
    Integer getCountByToday(long gameId);

    /**
     * @Description 7日内时间数据
     * @Author GaoLu
     * @Date  2023/11/8
     * @Return
    **/
    List<DataOfTimeVo> getNumForSevenDay();

    int deleteByPrimaryKey(Integer id);

    int insert(ChannelData record);

    int insertSelective(ChannelData record);

    ChannelData selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ChannelData record);

    int updateByPrimaryKey(ChannelData record);
}