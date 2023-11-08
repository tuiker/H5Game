package com.hou_tai.model.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hou_tai.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("game_trigger")
@Schema(title = "游戏触发记录实体")
public class GameTrigger implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id ;
    /** 游戏ID */
    @Schema(name = "游戏ID")
    private Long gameId ;
    /** 类型 对应枚举1下载2打开 */
    @Schema(name = "类型 对应枚举1下载2打开")
    private Integer type ;

    /**  */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
}