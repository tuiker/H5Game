package com.hou_tai.controller.pc.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
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
    @JSONField(format = "yyyy-MM-dd") //ResponseBody做了拦截，封装了一层导致原来JsonFormat无效，前端返回日期，要用JSONField来处理
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(title = "时间", description = "对应日期", name = "time")
    private LocalDate time;
}
