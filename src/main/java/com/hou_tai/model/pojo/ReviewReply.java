package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("review_reply")
@Schema(title = "评论回复实体")
public class ReviewReply {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id ;
    /** 用户ID */
    @Schema(title = "用户ID")
    private Long userId ;
    /** 评论ID */
    @Schema(title = "评论ID")
    private Integer reviewId ;
    /** 回复内容 */
    @Schema(title = "回复内容")
    private String replyContent ;
    /** 回复时间 */
    @Schema(title = "回复时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replyTime ;

}