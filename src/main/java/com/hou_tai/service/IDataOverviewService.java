package com.hou_tai.service;


import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.DataLineVo;
import com.hou_tai.response_vo.DataListVo;

import java.util.List;
import java.util.Map;

/**
 * @Author: Sam
 * @Date: 2023-10-23
 */
public interface IDataOverviewService {

    /**
     * 获取所有看板信息
     * @return
     */
    List<DataBoardVo> getBoardList();

    /**
     * @Author 获取折线图数据
     * @Description
     * @Date 15:00 2023/11/7
     * @Param  * @param
     * @return Map<String,List<LinesStatesVo>>
     **/
    Map<String,List<DataLineVo>> getLinesList(DataDto dto);
    
    /**
     * @Author Sam
     * @Description 获取概览数据
     * @Date 10:40 2023/11/8
     * @Param  * @param 
     * @return List<ListStatesVo>
     **/
    List<DataListVo> getListStats();


    Map<String,Object> getAllStates(DataDto dto);

}
