package com.hou_tai.controller.pc;


import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IDataOverviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @Author: Sam
 * @Date: 2023-10-26
 * @Description: 数据概览
 */
@RestController
@RequestMapping("/pc/data/")
@Tag(name = "数据概览")
@Slf4j
public class DataOverviewController {

    @Resource
    IDataOverviewService dataOverviewService;

    /**
     * @Author GaoLu
     * @Date 2023/11/8
     **/
    @Operation(summary = "数据概括", description = "数据概括")
    @Parameter(name = "gameId", description = "游戏ID")
    @GetMapping("/getAllStates")
    public ResultVO getAllStates(@RequestParam(value = "gameId", required = false) Long gameId) {
        return ResponseData.success(dataOverviewService.getAllStates(gameId));
    }


}
