package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hou_tai.model.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("game")
@Schema(title = "游戏实体")
public class Game implements Serializable {

    @Schema(title = "游戏ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id ;
    /** 游戏名称 */
    @Schema(title = "游戏名称")
    private String gameName ;
    /** 游戏类型 */
    @Schema(title = "游戏类型")
    private Integer gameType ;
    /** 游戏语言ID */
    @Schema(title = "游戏语言ID")
    private Integer languageId ;
    /** 游戏LOGO */
    @Schema(title = "游戏LOGO")
    private String gameLogo ;
    /** 游戏主图 */
    @Schema(title = "游戏主图")
    private String gameMainLogo ;
    /** 游戏背景 */
    @Schema(title = "游戏背景")
    private String gameBackground ;
    /** 游戏地址 */
    @Schema(title = "游戏地址")
    private String gameUrl ;
    /** 游戏描述 */
    @Schema(title = "游戏描述")
    private String gameDesc ;
    /** 数据安全 */
    @Schema(title = "数据安全")
    private String dataSecurity ;
    /** 游戏评分 */
    @Schema(title = "游戏评分")
    private Integer gameGrade ;
    /** 游戏下载次数 */
    @Schema(title = "游戏下载次数")
    private Integer gameDownload ;
    /** 游戏适合年龄 */
    @Schema(title = "游戏适合年龄")
    private Integer gameAge ;
    /** 开发者邮箱 */
    @Schema(title = "开发者邮箱")
    private String devEmail ;
    /** 开发者地址 */
    @Schema(title = "开发者地址")
    private String devUrl ;
    /** 创建用户ID */
    @Schema(title = "创建用户ID")
    private Long createId ;
    /**  */
    @TableField(fill = FieldFill.INSERT) // 插入自动填充
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /** 更新用户ID */
    @Schema(title = "更新用户ID")
    private Long updateId ;
    /**  */
    @Schema(title = "游戏更新日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;

    @Schema(title = "游戏标签 用;分隔")
    private String gameLabel;

}