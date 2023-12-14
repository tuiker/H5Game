package com.hou_tai.controller.mobile.dto;

import com.hou_tai.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @ClassName: AppGameDto
 * @Description: 游戏入参
 * @Author: Sam
 * @Date: 2023-11-04 13:22
 * @Version: 1.0
 **/
@Data
@Builder
@Schema(title = "移动端游戏查询入参")
public class MobileGameDto  extends PageDaoEntity{

    @Schema(title = "游戏id",description = "当前游戏id,进行排除")
    private Long gameId;

    @Schema(title = "游戏名称")
    private String gameName;

    @Schema(title = "游戏类型",description = "当前游戏类型,则为相似游戏")
    private Integer gameType;

    @Schema(title = "游戏包名",description = "当前游戏游戏包名,进行排除")
    private String gameApkName;

}
