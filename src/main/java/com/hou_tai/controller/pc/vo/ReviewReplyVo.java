package com.hou_tai.controller.pc.vo;

import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.model.pojo.ReviewReply;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @ClassName: GameReviewVo
 * @Description: 游戏评论输出
 * @Author: Sam
 * @Date: 2023-11-04 11:52
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Schema(title = "游戏评论输出")
public class ReviewReplyVo extends ReviewReply {

    @Schema(title = "游戏名称")
    private String gameName ;

    @Schema(title = "回复集合")
    private List<ReviewReply> reviewReplyList;
}
