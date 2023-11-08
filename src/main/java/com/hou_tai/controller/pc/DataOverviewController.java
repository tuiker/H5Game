package com.hou_tai.controller.pc;


import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IDataOverviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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

    /**
     * @Author GaoLu
     * @Date 2023/11/8
     **/
    @Operation(summary = "数据概括", description = "数据概括")
    @PostMapping("/getAllStates")
    public ResultVO getAllStates() {
        return ResponseData.success(dataOverviewService.getAllStates());
    }


}
