package com.hou_tai.controller.pc;


import com.hou_tai.model.pojo.Channel;
import com.hou_tai.model.pojo.GameType;
import com.hou_tai.model.pojo.Language;
import com.hou_tai.response.ResultVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: Sam
 * @Date: 2023-10-18 13:41
 * @Description: 游戏各项数值管理
 */
@RestController
@RequestMapping("/pc/game/numerical")
@Tag(name = "游戏各项数值")
public class GameNumericalController {

//    @Resource
//    private IGameTypeService gameTypeService;
//
//    @Resource
//    private ILanguageService languageService;
//
//    @Resource
//    private IChannelService channelService;
//
//
//    /**
//     * 全查询
//     *
//     * @return 查询结果
//     */
//    @Operation(summary = "所有游戏类型")
//    @GetMapping("/listByGameType")
//    @ApiResponse(responseCode = "200", description = "查找成功")
//    public ResultVO<List<GameType>> listByGameType() {
//        List<GameType> list = gameTypeService.listByGameType();
//        return new ResultVO<>(list);
//    }
//
//
//    /**
//     * 全查询
//     *
//     * @return 查询结果
//     */
//    @Operation(summary = "所有语言")
//    @GetMapping("/listByLanguage")
//    @ApiResponse(responseCode = "200", description = "查找成功")
//    public ResultVO<List<Language>> listByLanguage() {
//        List<Language> list = languageService.listByLanguage();
//        return new ResultVO<>(list);
//    }
//
//
//    /**
//     * @Description 所有渠道
//     * @Author GaoLu
//     * @Date 2023/10/26
//     **/
//    @Operation(summary = "所有渠道")
//    @GetMapping("/getChannelList")
//    public ResultVO<List<Channel>> getChannelList() {
//        List<Channel> list = channelService.getChannelList();
//        return new ResultVO<>(list);
//    }




}
