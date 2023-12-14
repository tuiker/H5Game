package com.hou_tai.controller.mobile.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hou_tai.model.pojo.GameReview;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @ClassName: MobileGameReviewVo
 * @Description: 移动端游戏评论输出
 * @Author: Sam
 * @Date: 2023-11-04 11:52
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Schema(title = "移动端游戏评论输出")
public class MobileGameReviewVo extends GameReview {

    @Schema(title = "游戏名称")
    private String gameName ;

//    @Schema(title = "回复集合")
//    private List<ReviewReplyVo> reviewReplyList;

    @Schema(title = "评论用户名称")
    private String userName ;

    @Schema(title = "评论用户头像")
    private String userImg ;

    @Schema(title = "回复用户名称")
    private String replyUserName ;

    @Schema(title = "评论时间")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime reviewTime ;

    @Schema(title = "回复时间")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "reply_time")
    private LocalDateTime replyTime;
}
