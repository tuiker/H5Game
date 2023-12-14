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
@Schema(title = "折线数据")
public class DataLineVo implements Serializable {


    @Schema(title = "总数")
    private Integer total;

    @Schema(title = "日期 yyyy-MM-dd")
    private String days;

}
