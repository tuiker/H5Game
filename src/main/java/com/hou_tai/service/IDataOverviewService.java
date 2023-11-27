package com.hou_tai.service;


import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.GameGeneralizeVo;

import java.util.List;

/**
 * @Author: Sam
 * @Date: 2023-10-23
 */
public interface IDataOverviewService {


    /**
     * @Description 返回数据概括对象
     * @Author GaoLu
     * @Date 2023/11/8
     * @Return 数据概括对象
     **/
    DataBoardVo getAllStates(Long gameId);

    /**
     * 获取数据概况表格数据
     */
    List<GameGeneralizeVo> getDataProfilingTableData();

}
