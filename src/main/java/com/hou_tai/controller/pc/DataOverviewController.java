package com.hou_tai.controller.pc;


import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IDataOverviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2023-10-26
 * @Description: 数据概览
 */
@RestController
@RequestMapping("/pc/data/")
@Tag(name = "数据概览")
public class DataOverviewController {

    @Resource
    IDataOverviewService dataOverviewService;

    @Operation(summary = "数据看板")
    @PostMapping("/getDataBoardList")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<List<DataBoardVo>> getDataBoardList() {
        List<DataBoardVo> list = dataOverviewService.getDataList();
        return ResponseData.success(list);
    }

    @Operation(summary = "折线图数据统计",description = "2下载3打开")
    @PostMapping("/getLineStates")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO getLineStates(){
        //默认7天
        return ResponseData.success(dataOverviewService.getLinesList(null));
    }

    @Operation(summary = "数据概览",description = "")
    @GetMapping("/getListStates")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO getListStates(){


        return ResponseData.success();
    }


}
