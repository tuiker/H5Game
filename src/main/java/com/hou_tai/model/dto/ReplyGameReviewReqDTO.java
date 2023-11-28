package com.hou_tai.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "回复游戏评论请求DTO")
@Data
public class ReplyGameReviewReqDTO {
    @Schema(description = "评论ID")
    private Integer id;

    @Schema(description = "回复内容")
    private String replyContent;

}
