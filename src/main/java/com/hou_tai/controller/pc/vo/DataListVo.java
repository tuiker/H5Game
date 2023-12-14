package com.hou_tai.controller.pc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

/**
 * @Author: Sam
 * @Date: 2023-10-21
 * @Description: 游戏广告返回类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(title = "概览数据")
public class DataListVo implements Serializable {


    @Schema(title = "排序")
    private Integer rank;

    @Schema(title = "游戏名")
    private String gameName;

    @Schema(title = "语言")
    private String languageName;

    @Schema(title = "游戏类型")
    private String typeName;

    @Schema(title = "访问次数")//request_num
    private Integer requestNum;

    @Schema(title = "下载次数")
    private Integer downloadNum;//download_num

    @Schema(title = "打开次数")
    private Integer openNum;//open_num



}
