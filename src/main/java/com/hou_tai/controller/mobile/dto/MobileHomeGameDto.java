package com.hou_tai.controller.mobile.dto;

import com.hou_tai.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @ClassName: AppGameDto
 * @Description: 游戏入参
 * @Author: Sam
 * @Date: 2023-11-04 13:22
 * @Version: 1.0
 **/
@Data
@Builder
@Schema(title = "移动端游戏首页查询入参")
public class MobileHomeGameDto  {


//    @Schema(title = "游戏名称")
//    private String gameName;

    @Schema(title = "首页类型 对应枚举 0全部1近期2广告推荐3个性化")
    private Integer HomeType;

    @Schema(title = "语言id")
    private Integer languageId;

    @Schema(title = "页", description = "第几页，默认1", name = "page", defaultValue = "1")
    private Integer page;
    @Schema(title = "条", description = "一页多少条", name = "pageSize", defaultValue = "10")
    private Integer pageSize;
}
