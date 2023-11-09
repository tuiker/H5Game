package com.hou_tai.controller.mobile;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.enums.HomeEnums;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.dto.*;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.model.pojo.GameType;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.response_vo.MobileGameHomeVo;
import com.hou_tai.response_vo.MobileGameReviewVo;
import com.hou_tai.response_vo.MobileGameVo;
import com.hou_tai.service.IGameReviewService;
import com.hou_tai.service.IGameService;
import com.hou_tai.service.IGameTriggerService;
import com.hou_tai.util.IPAdress;
import com.hou_tai.util.IPCountryUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Resource
    IGameReviewService gameReviewService;

    @Operation(summary = "应用详情",description = "包含评论回复数据")
    @PostMapping("/getVoById")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<MobileGameVo> getVoById(@RequestBody MobileGameDto dto){
        return ResponseData.success(gameService.getVoById(dto));
    }

    @Operation(summary = "游戏评论列表")
    @PostMapping("/getReviewByGameId")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<Page<MobileGameReviewVo>> getReviewByGameId(@RequestBody MobileGameReviewDto dto){
        return ResponseData.success(gameReviewService.pageQuery(dto));
    }

    @Operation(summary = "新增埋点数据",description = "触发类型 2下载3打开")
    @PostMapping("/addPointNum")
    @ResponseBody
    public ResultVO addPointNum(@RequestBody PointDto dto) {
        return gameTriggerService.insertByPoint(dto);
    }

    @Operation(summary = "类似游戏列表",description = "类似游戏,传gameId则排除此游戏")
    @PostMapping("/getPage")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<Page<MobileGameVo>> getPage(@RequestBody MobileGameDto dto){
        return ResponseData.success(gameService.pageForMobile(dto));
    }


    @Operation(summary = "新增评论有用数",description = "返回当前评论")
    @PostMapping("/addHelpNum")
    @ResponseBody
    public ResultVO<GameReview> addHelpNum(@RequestBody MobileGameReviewDto dto) {
        return ResponseData.success(gameReviewService.addHelpNum(dto));
    }

//    @Operation(summary = "游戏首页",description = "0全部1近期2广告推荐3个性化")
//    @PostMapping("/getHomeGame")
//    @ApiResponse(responseCode = "200", description = "查找成功")
//    public ResultVO<List<MobileGameHomeVo>> getHomeGame(HttpServletRequest request, @RequestBody MobileHomeGameDto dto){
//        //根据用户ip获取语言id
//        Integer languageId= IPCountryUtil.ipToCountry(IPAdress.getIp(request));
//        //由于目前为展示数据 遂固定了参数
//        if(dto==null){//无类型自动填充
//            dto=MobileHomeGameDto.builder().HomeType(CommonNum.ZERO).languageId(languageId).page(CommonNum.ONE).pageSize(10).build();
//        }
//        dto.setLanguageId(languageId);
//        return ResponseData.success(gameService.getHomeTypeList(dto));
//    }


    @Operation(summary = "游戏首页-近期",description = "")
    @PostMapping("/getHomeGameByRecent")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<Page<MobileGameVo>> getHomeGameByRecent(HttpServletRequest request, @RequestBody MobileHomeGameDto dto){
        Integer languageId= IPCountryUtil.ipToCountry(IPAdress.getIp(request));
        dto.setLanguageId(languageId);dto.setHomeType(HomeEnums.RECENT.getCode());
        return  ResponseData.success(gameService.pageForHomeType(dto));
    }

    @Operation(summary = "游戏首页-广告推荐",description = "")
    @PostMapping("/getHomeGameByRecommend")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<Page<MobileGameVo>> getHomeGameByRecommend(HttpServletRequest request, @RequestBody MobileHomeGameDto dto){
        Integer languageId= IPCountryUtil.ipToCountry(IPAdress.getIp(request));
        dto.setLanguageId(languageId);dto.setHomeType(HomeEnums.RECOMMEND.getCode());
        return  ResponseData.success(gameService.pageForHomeType(dto));
    }

    @Operation(summary = "游戏首页-个性化",description = "")
    @PostMapping("/getHomeGameByPersonal")
    @ApiResponse(responseCode = "200", description = "查找成功")
    public ResultVO<Page<MobileGameVo>> getHomeGameByPersonal(HttpServletRequest request, @RequestBody MobileHomeGameDto dto){
        Integer languageId= IPCountryUtil.ipToCountry(IPAdress.getIp(request));
        dto.setLanguageId(languageId);dto.setHomeType(HomeEnums.PERSONAL.getCode());
        return  ResponseData.success(gameService.pageForHomeType(dto));
    }


}
