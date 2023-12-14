package com.hou_tai.controller.pc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @ClassName: GameDto
 * @Description: 游戏入参
 * @Author: Sam
 * @Date: 2023-11-04 13:22
 * @Version: 1.0
 **/
@Data
@Schema(title = "埋点数据入参")
public class PointDto {

    @Schema(title = "游戏id")
    private Long gameId;

    @Schema(title = "触发类型 2下载3打开")
    private Integer triggerType;

    @Schema(title = "APK包名", description = "triggerType为3时，添加对应apkName", name = "apkName")
    private String apkName;
}
