package com.hou_tai.controller.mobile;

import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IGameService;
import com.hou_tai.service.IGameTriggerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: GameController
 * @Description: 移动端游戏
 * @Author: Sam
 * @Date: 2023-11-04 11:18
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/mobile/game")
@Tag(name = "移动端游戏控制层")
public class MobileGameController {

    @Resource
    IGameService gameService;

    @Resource
    IGameTriggerService gameTriggerService;

    @Operation(summary = "应用详情",description = "包含评论回复数据")
    @PostMapping("/getVoById")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO getVoById(@RequestBody GameDto dto){
        return ResponseData.success(gameService.getVoById(dto));
    }

    @Operation(summary = "游戏评论回复列表")
    @PostMapping("/getReviewByGameId")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO getReviewByGameId(@RequestBody GameDto dto){
        return ResponseData.success();
    }

    @Operation(summary = "新增埋点数据",description = "触发类型 1下载2打开")
    @PostMapping("/addPointNum")
    @ResponseBody
    public ResultVO<String> addPointNum(@RequestBody PointDto dto) {
        boolean result=gameTriggerService.insertByPoint(dto);
        return result ? ResponseData.success():ResponseData.error();
    }



}
