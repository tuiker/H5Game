package com.hou_tai.model.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("game")
@Schema(title = "游戏实体")
public class Game implements Serializable {

    @Schema(title = "游戏ID")
    //@TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 游戏名称
     */
    @Schema(title = "游戏名称")
    @TableField(value = "game_name")
    private String gameName;
    /**
     * 游戏类型
     */
    @Schema(title = "游戏类型")
    @TableField(value = "game_type")
    private Integer gameType;
    /**
     * 游戏语言ID
     */
    @Schema(title = "游戏语言ID")
    @TableField(value = "language_id")
    private Integer languageId;
    /**
     * 游戏LOGO
     */
    @Schema(title = "游戏LOGO")
    @TableField(value = "game_logo")
    private String gameLogo;


    @Schema(title = "落地页地址")
    @TableField(value = "game_fall_url")
    private String gameFallUrl;
    ;
    /**
     * 游戏主图
     */
    @Schema(title = "游戏主图")
    @TableField(value = "game_main_logo")
    private String gameMainLogo;
    /**
     * 游戏背景
     */
    @Schema(title = "游戏背景")
    @TableField(value = "game_background")
    private String gameBackground;
    /**
     * 游戏地址
     */
    @Schema(title = "游戏地址")
    @TableField(value = "game_url")
    private String gameUrl;
    /**
     * APK包名
     */
    @Schema(title = "APK包名")
    @TableField(value = "apk_name")
    private String apkName;
    /**
     * 游戏描述
     */
    @Schema(title = "游戏描述")
    @TableField(value = "game_desc")
    private String gameDesc;
    /**
     * 数据安全
     */
    @Schema(title = "数据安全")
    @TableField(value = "data_security")
    private String dataSecurity;
    /**
     * 游戏评分
     */
    @Schema(title = "游戏评分")
    @TableField(value = "game_grade")
    private Double gameGrade;
    /**
     * 游戏下载次数
     */
    @Schema(title = "游戏下载次数")
    @TableField(value = "game_download")
    private Integer gameDownload;
    /**
     * 游戏适合年龄
     */
    @Schema(title = "游戏适合年龄")
    @TableField(value = "game_age")
    private Integer gameAge;
    /**
     * 开发者邮箱
     */
    @Schema(title = "开发者邮箱")
    @TableField(value = "dev_email")
    private String devEmail;
    /**
     * 开发者地址
     */
    @Schema(title = "开发者地址")
    @TableField(value = "dev_url")
    private String devUrl;
    /**
     * 创建用户ID
     */
    @Schema(title = "创建用户ID")
    @TableField(value = "create_id")
    private Long createId;
    /**
     *
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT) // 插入自动填充
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 更新用户ID
     */
    @Schema(title = "更新用户ID")
    @TableField(value = "update_id")
    private Long updateId;
    /**
     *
     */
    @Schema(title = "游戏更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //前后端接收日期都可以改变格式
    @JSONField(format = "yyyy-MM-dd HH:mm:ss") //ResponseBody做了拦截，封装了一层导致原来JsonFormat无效，前端返回日期，要用JSONField来处理
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @Schema(title = "游戏标签 用;分隔")
    @TableField(value = "game_label")
    private String gameLabel;

    @Schema(title = "游戏评论数")
    @TableField(value = "review_num")
    private Integer reviewNum;

    @Schema(title = "逻辑删除标识，1：已删除，0：未删除")
    @TableField(value = "deleted")
    private Integer deleted;

}