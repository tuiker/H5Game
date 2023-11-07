package com.hou_tai.model.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

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
    private Integer id;
    /**
     * 用户ID
     */
    @Schema(title = "用户ID")
    private Long userId;
    /**
     * 评论ID
     */
    @Schema(title = "评论ID")
    private Integer reviewId;
    /**
     * 回复内容
     */
    @Schema(title = "回复内容")
    private String replyContent;
    /**
     * 回复时间
     */
    @Schema(title = "回复时间")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss") //ResponseBody做了拦截，封装了一层导致原来JsonFormat无效，前端返回日期，要用JSONField来处理
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replyTime;

}