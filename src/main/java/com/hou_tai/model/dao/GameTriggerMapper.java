package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hou_tai.model.pojo.GameTrigger;
import com.hou_tai.controller.pc.vo.DataOfTimeVo;

import java.util.List;

public interface GameTriggerMapper extends BaseMapper<GameTrigger> {
    /**
     * @Description
     * @Author GaoLu
     * @Date 2023/11/8
     * @Return 今日下载、打开数据
     * @Param type 数据类型 2下载3打开
     **/
    Integer getCountByToday(int type);

    /**
     * @Description 获取近七日数据
     * @Author GaoLu
     * @Date 2023/11/8
     * @Return
     * @Param type
     **/
    List<DataOfTimeVo> getNumForSevenDay(Long gameId, int type);

    /**
     * @Description 根据游戏ID找到对应数据
     * @Author GaoLu
     * @Date 2023/11/14
     * @Return
     * @Param type 2下载，3打开
     * @Param gameId 游戏ID
     **/
    Integer getCountAll(int type, long gameId);
}