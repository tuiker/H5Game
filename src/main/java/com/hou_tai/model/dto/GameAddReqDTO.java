package com.hou_tai.model.dto;

import com.alibaba.fastjson.annotation.JSONField;
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
@Schema(title = "游戏新增请求 DTO")
public class GameAddReqDTO implements Serializable {

    @Schema(title = "游戏名称")
    private String gameName;

    @Schema(title = "游戏类型")
    private Integer gameType;

    @Schema(title = "游戏语言ID")
    private Integer languageId;

    @Schema(title = "游戏LOGO")
    private String gameLogo;

    @Schema(title = "落地页地址")
    private String gameFallUrl;

    @Schema(title = "游戏主图")
    private String gameMainLogo;

    @Schema(title = "游戏背景")
    private String gameBackground;

    @Schema(title = "游戏地址")
    private String gameUrl;

    @Schema(title = "APK包名")
    private String apkName;

    @Schema(title = "APK链接")
    private String apkLink;

    @Schema(title = "游戏描述")
    private String gameDesc;

    @Schema(title = "数据安全")
    private String dataSecurity;

    @Schema(title = "游戏评分")
    private Double gameGrade;

    @Schema(title = "游戏下载次数")
    private Integer gameDownload;

    @Schema(title = "游戏适合年龄")
    private Integer gameAge;

    @Schema(title = "开发者邮箱")
    private String devEmail;

    @Schema(title = "开发者地址")
    private String devUrl;

    @Schema(title = "创建用户ID")
    private Long createId;

    @Schema(title = "更新用户ID")
    private Long updateId;

    @Schema(title = "游戏更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //前后端接收日期都可以改变格式
    @JSONField(format = "yyyy-MM-dd HH:mm:ss") //ResponseBody做了拦截，封装了一层导致原来JsonFormat无效，前端返回日期，要用JSONField来处理
    private LocalDateTime gameUpdateTime;

    @Schema(title = "游戏标签 用;分隔")
    private String gameLabel;

    @Schema(title = "游戏评论数")
    private Integer reviewNum;

}
