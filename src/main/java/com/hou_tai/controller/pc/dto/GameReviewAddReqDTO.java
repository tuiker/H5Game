package com.hou_tai.controller.pc.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Schema(description = "游戏评论实体")
public class GameReviewAddReqDTO {
    
    @Schema(description = "用户ID")
    private Long userId ;
    
    @Schema(description = "游戏ID")
    private Long gameId ;
    
    @Schema(description = "评论内容")
    private String reviewContent ;

    @Schema(description = "评论打分")
    private Integer reviewGrade;

}