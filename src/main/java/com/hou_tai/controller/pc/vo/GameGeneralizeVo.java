package com.hou_tai.controller.pc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: GaoLu
 * @Date: 2023-11-08 17:31
 * @Description: 游戏概括返回对象
 */
@Data
@Schema(title = "游戏概括返回对象")
public class GameGeneralizeVo {
    @Schema(title = "游戏ID", description = "游戏ID", name = "id")
    private Long id;
    @Schema(title = "类型", description = "游戏类型", name = "gameType")
    private String gameType;
    @Schema(title = "游戏名称", description = "游戏名称", name = "gameName")
    private String gameName;
    @Schema(title = "客户名称", description = "客户名称", name = "userName")
    private String userName;
    @Schema(title = "游戏语言", description = "游戏语言", name = "gameLanguage")
    private String gameLanguage;
    @Schema(title = "页面请求", description = "页面请求（次）", name = "requestNum")
    private Integer requestNum;
    @Schema(title = "应用下载", description = "应用下载（次）", name = "downloadNum")
    private Integer downloadNum;
    @Schema(title = "应用打开", description = "应用打开（次）", name = "openNum")
    private Integer openNum;


}
