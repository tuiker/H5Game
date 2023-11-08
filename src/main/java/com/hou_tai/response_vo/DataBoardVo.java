package com.hou_tai.response_vo;

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
@Schema(title = "数据概览看板出参")
public class DataBoardVo implements Serializable {

    @Schema(title = "1今日访问2今日应用下载3今日打开应用")
    private Integer type;

    @Schema(title = "总数")
    private Integer total;



}
