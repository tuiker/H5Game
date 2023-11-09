package com.hou_tai.response_vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: GaoLu
 * @Date: 2023-11-08 17:28
 * @Description: 统一时间、数据对象
 */
@Data
@Schema(title = "时间、数据对象")
public class DataOfTimeVo {
    @Schema(title = "数据", description = "相关数值", name = "num")
    private int num;
    @Schema(title = "时间", description = "对应日期", name = "time")
    private LocalDateTime time;
}
