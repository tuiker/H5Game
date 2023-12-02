package com.hou_tai.controller.mobile;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.common.enums.CountryLanguageEnum;
import com.hou_tai.common.enums.HomeEnums;
import com.hou_tai.common.enums.ResultCode;
import com.hou_tai.common.response.ResponseData;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.common.util.IPAdress;
import com.hou_tai.common.util.IPCountryUtil;
import com.hou_tai.model.dto.MobileGameDto;
import com.hou_tai.model.dto.MobileGameReviewDto;
import com.hou_tai.model.dto.MobileHomeGameDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.response_vo.MobileGameHomeVo;
import com.hou_tai.response_vo.MobileGameReviewVo;
import com.hou_tai.response_vo.MobileGameVo;
import com.hou_tai.service.IGameReviewService;
import com.hou_tai.service.IGameService;
import com.hou_tai.service.IGameTriggerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;

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
@Slf4j
public class MobileGameController {

    @Resource
    IGameService gameService;

    @Resource
    IGameTriggerService gameTriggerService;

    @Resource
    IGameReviewService gameReviewService;

    @Operation(summary = "获取游戏语言", description = "获取游戏语言")
    @GetMapping("/getLanguageType")
    public ResultVO getLanguageType(HttpServletRequest request) {
        //根据用户ip获取语言id
        log.info("当前地址客户端IP》》》》》》》》》》》》》》" + request.getRemoteAddr());
        Locale locale = request.getLocale();
        String conutry = locale.getCountry();

        Enumeration<String> s = request.getHeaderNames();
        Iterator<String> ss = s.asIterator();
        if (ss.hasNext()) {
            String name = ss.next();
            System.out.println("请求头里的参数》》》》》》》》》》" + name + "对应值》》》》" + request.getHeader(name));
        }
        log.info("客户端浏览器国家、、、、、、》》》》" + conutry);
        Integer type = CountryLanguageEnum.getValue(conutry);
        if (null == type) {
            type = 1;
        }
        log.info("获取的语言》》》》》》》》》" + type);
        return ResponseData.success(type);
    }

    @Operation(summary = "新增埋点数据", description = "触发类型 2下载3打开")
    @PostMapping("/addPointNum")
    public ResultVO addPointNum(@RequestBody PointDto dto) {
        return gameTriggerService.insertByPoint(dto);
    }


    @Operation(summary = "添加评论有用数", description = "返回当前评论")
    @PostMapping("/addHelpNum")
    public ResultVO<GameReview> addHelpNum(@RequestBody MobileGameReviewDto dto) {
        return ResponseData.success(gameReviewService.addHelpNum(dto));
    }

    @Operation(summary = "应用详情", description = "包含评论回复数据")
    @PostMapping("/getVoById")
    public ResultVO<MobileGameVo> getVoById(@RequestBody MobileGameDto dto) {
        MobileGameVo vo = gameService.getVoById(dto);
        return vo != null ? ResponseData.success(vo) : ResponseData.error("参数错误,请检查数据", ResultCode.FAILED);
    }

    @Operation(summary = "游戏评论列表")
    @PostMapping("/getReviewByGameId")
    public ResultVO<Page<MobileGameReviewVo>> getReviewByGameId(@RequestBody MobileGameReviewDto dto) {
        return ResponseData.success(gameReviewService.pageQuery(dto));
    }

    @Operation(summary = "类似游戏列表", description = "类似游戏,传gameId则排除此游戏")
    @PostMapping("/getPage")
    public ResultVO<Page<MobileGameHomeVo>> getPage(@RequestBody MobileGameDto dto) {
        return ResponseData.success(gameService.pageForMobile(dto));
    }

    @Operation(summary = "游戏首页-近期")
    @PostMapping("/getHomeGameByRecent")
    public ResultVO<Page<MobileGameHomeVo>> getHomeGameByRecent(HttpServletRequest request, @RequestBody MobileHomeGameDto dto) {
        Integer languageId = IPCountryUtil.ipToCountry(IPAdress.getIp(request));
        dto.setLanguageId(languageId);
        dto.setHomeType(HomeEnums.RECENT.getCode());
        return ResponseData.success(gameService.pageForHomeType(dto));
    }

    @Operation(summary = "游戏首页-广告推荐")
    @PostMapping("/getHomeGameByRecommend")
    public ResultVO<Page<MobileGameHomeVo>> getHomeGameByRecommend(HttpServletRequest request, @RequestBody MobileHomeGameDto dto) {
        Integer languageId = IPCountryUtil.ipToCountry(IPAdress.getIp(request));
        dto.setLanguageId(languageId);
        dto.setHomeType(HomeEnums.RECOMMEND.getCode());
        return ResponseData.success(gameService.pageForHomeType(dto));
    }

    @Operation(summary = "游戏首页-个性化")
    @PostMapping("/getHomeGameByPersonal")
    public ResultVO<Page<MobileGameHomeVo>> getHomeGameByPersonal(HttpServletRequest request, @RequestBody MobileHomeGameDto dto) {
        Integer languageId = IPCountryUtil.ipToCountry(IPAdress.getIp(request));
        dto.setLanguageId(languageId);
        dto.setHomeType(HomeEnums.PERSONAL.getCode());
        return ResponseData.success(gameService.pageForHomeType(dto));
    }


}
