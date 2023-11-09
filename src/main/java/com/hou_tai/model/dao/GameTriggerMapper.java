package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hou_tai.model.pojo.GameTrigger;
import com.hou_tai.response_vo.DataOfTimeVo;

import java.util.List;

public interface GameTriggerMapper extends BaseMapper<GameTrigger> {
    /**
     * @Description
     * @Author GaoLu
     * @Date 2023/11/8
     * @Return 条数
     * @Param type 数据类型 2下载3打开
     **/
    Integer getCountByToday(int type,long gameId);

    /**
     * @Description 获取近七日数据
     * @Author GaoLu
     * @Date 2023/11/8
     * @Return
     * @Param type
     **/
    List<DataOfTimeVo> getNumForSevenDay(int type);
}