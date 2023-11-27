package com.hou_tai.controller.pc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.base.PageDaoEntity;
import com.hou_tai.model.dto.GameReviewAddReqDTO;
import com.hou_tai.model.dto.ReplyGameReviewReqDTO;
import com.hou_tai.model.dto.ReviewPageReqDTO;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.common.response.ResponseData;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.response_vo.GameReviewPageVo;
import com.hou_tai.service.IGameReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: GameController
 * @Description: 评论管理 Controller
 * @Author: Sam
 * @Date: 2023-11-06 10:10
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/pc/game/review")
@Tag(name = "后台端游戏评论控制层")
@Slf4j
public class GameReviewController {

    @Resource
    private IGameReviewService gameReviewService;

    /**
     * @Description 游戏评论列表
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     **/
    @Operation(summary = "游戏评论列表", description = "分页查询游戏评论")
    @GetMapping("/getReviewPage")
    public ResultVO<Page<GameReviewPageVo>> getReviewPage(@ParameterObject ReviewPageReqDTO reqDTO) {
        return ResponseData.success(gameReviewService.getReviewPage(reqDTO));
    }

    /**
     * @Description 游戏评论详情
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     **/
    @Operation(summary = "游戏评论详情", description = "根据评论ID获取游戏评论详情")
    @Parameter(name = "id", description = "评论ID", required = true)
    @GetMapping("/getGameReviewById")
    public ResultVO<GameReviewPageVo> getGameReviewById(@RequestParam("id") Integer id) {
        return ResponseData.success(gameReviewService.getGameReviewById(id));
    }

    /**
     * @Description 回复
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     **/
    @Operation(summary = "回复评论", description = "根据评论ID回复评论")
    @PostMapping("/saveReply")
    public ResultVO<Boolean> saveReply(@RequestBody ReplyGameReviewReqDTO reqDTO) {
        return ResponseData.success(gameReviewService.saveReply(reqDTO));
    }


    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return 查询结果
     */
//    @Operation(summary = "分页查询", description = "gameId,page,pageSize")
//    @PostMapping("/page")
//    public ResultVO page(@RequestBody MobileGameReviewDto dto) {
//        Page<GameReviewVo> reviewPage = gameReviewService.pageQuery(dto);
//        return ResponseData.success(reviewPage);
//    }

    /**
     * 新增数据
     *
     * @param reqDTO 实例对象
     * @return 实例对象
     */
    @Operation(summary = "新增评论数据", description = "userId,gameId,reviewContent,helpNum,reviewGrade")
    @PostMapping("/add")
    public ResultVO<GameReview> add(@RequestBody GameReviewAddReqDTO reqDTO) {
        return ResponseData.success(gameReviewService.insert(reqDTO));
    }

    /**
     * 更新数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
//    @Operation(summary = "更新评论数据")
//    @PostMapping("/update")
//    public ResultVO<GameReview> update(@RequestBody GameReview gameReview) {
//        return ResponseData.success(gameReviewService.update(gameReview));
//    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
//    @Operation(summary = "通过主键删除数据")
//    @DeleteMapping
//    public ResultVO<Boolean> deleteById(Integer id) {
//        return ResponseData.success(gameReviewService.deleteById(id));
//    }


}
