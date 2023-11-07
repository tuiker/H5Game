package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("game_review")
@Schema(title = "游戏评论实体")
public class GameReview {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /** 用户ID */
    @Schema(title = "用户ID")
    @TableField(value = "user_id")
    private Long userId ;
    /** 游戏ID */
    @Schema(title = "游戏ID")
    @TableField(value = "game_id")
    private Integer gameId ;
    /** 评论内容 */
    @Schema(title = "评论内容")
    @TableField(value = "review_content")
    private String reviewContent ;
    /** 评论时间 */
    @Schema(title = "评论时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "review_time",fill = FieldFill.INSERT)
    private LocalDateTime reviewTime ;
    /** 评价有帮助数 */
    @Schema(title = "评价有帮助数")
    @TableField(value = "help_num")
    private Integer helpNum ;

    @Schema(title = "评论打分")
    @TableField(value = "review_grade")
    private Integer reviewGrade;

    @Schema(title = "回复内容")
    @TableField(value = "reply_content")
    private String replyContent;

    @Schema(title = "回复时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "reply_time")
    private LocalDateTime replyTime;

    @Schema(title = "是否回复：0否1是")
    @TableField(value = "have_reply")
    private Integer haveReply;

    @Schema(title = "回复用户ID")
    @TableField(value = "reply_user_id")
    private Long replyUserId;


}