package com.hou_tai.controller.pc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2023-10-21
 * @Description: 游戏广告返回类
 */
@Data
@Schema(title = "数据概览看板出参")
public class DataBoardVo implements Serializable {
    @Schema(title = "今日请求", description = "今日请求次数", name = "todayRequestNum")
    private Integer todayRequestNum;
    @Schema(title = "今日下载", description = "今日下载次数", name = "todayDownloadNum")
    private Integer todayDownloadNum;
    @Schema(title = "今日打开", description = "今日打开次数", name = "todayOpenNum")
    private Integer todayOpenNum;
    @Schema(title = "页面请求", description = "页面请求数据集合", name = "requestDataOfTime")
    private List<DataOfTimeVo> requestDataOfTime;
    @Schema(title = "应用下载", description = "应用下载数据集合", name = "downloadDataOfTime")
    private List<DataOfTimeVo> downloadDataOfTime;
    @Schema(title = "应用打开", description = "应用打开数据集合", name = "openDataOfTime")
    private List<DataOfTimeVo> openDataOfTime;
    @Schema(title = "游戏概括", description = "游戏概括集合", name = "gameGeneralize")
    private List<GameGeneralizeVo> gameGeneralize;

}
