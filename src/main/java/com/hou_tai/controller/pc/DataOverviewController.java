package com.hou_tai.controller.pc;


import cn.hutool.core.util.ObjectUtil;
import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IDataOverviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


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
    @Operation(summary = "数据概览",description = "1看板数据2折线数据3概览数据")
    @PostMapping("/getAllStates")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO getAllStates(@RequestBody DataDto dto){
        if(ObjectUtil.isEmpty(dto)||dto.getStartDate()==null){//默认7天
            dto=DataDto.builder().startDate(LocalDate.now().minusDays(6l)).endDate(LocalDate.now()).build();
        }
        return ResponseData.success(dataOverviewService.getAllStates(dto));
    }


}
