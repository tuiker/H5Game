package com.hou_tai.controller.pc;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.model.vo.GameReviewVo;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IGameReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: GameController
 * @Description: 后台游戏
 * @Author: Sam
 * @Date: 2023-11-06 10:10
 * @Version: 1.0
 **/
@RestController
@RequestMapping("/pc/game/review")
@Tag(name = "后台端游戏评论控制层")
public class GameReviewController {

    @Resource
    private IGameReviewService gameReviewService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Operation(summary ="通过ID查询单条数据")
    @GetMapping("{id}")
    public ResultVO queryById(Integer id){
        return ResponseData.success(gameReviewService.queryById(id));
    }

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return 查询结果
     */
    @Operation(summary ="分页查询",description ="gameId,page,pageSize")
    @PostMapping("/page")
    public ResultVO page(@RequestBody GameDto dto){
        Page<GameReviewVo> reviewPage=gameReviewService.pageQuery(dto);
        return ResponseData.success(reviewPage);
    }

    /**
     * 新增数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    @Operation(summary ="新增评论数据",description = "userId,gameId,reviewContent,helpNum,reviewGrade")
    @PostMapping("/add")
    public ResultVO<GameReview> add(@RequestBody GameReview gameReview){
        return ResponseData.success(gameReviewService.insert(gameReview));
    }

    /**
     * 更新数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    @Operation(summary ="更新评论数据")
    @PostMapping("/update")
    public ResultVO<GameReview> update(@RequestBody GameReview gameReview){
        return ResponseData.success(gameReviewService.update(gameReview));
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Operation(summary ="通过主键删除数据")
    @DeleteMapping
    public ResultVO<Boolean> deleteById(Integer id){
        return ResponseData.success(gameReviewService.deleteById(id));
    }


    /**
     * 新增数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    @Operation(summary ="回复数据保存",description ="id,replyContent,replyUserId")
    @PostMapping("/saveReply")
    public ResultVO saveReply(@RequestBody GameReview gameReview){
        return ResponseData.success(gameReviewService.saveReply(gameReview));
    }


}
