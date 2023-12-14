package com.hou_tai.controller.pc.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(title = "数据追踪保存请求 DTO")
public class ScriptDescSaveReqDTO implements Serializable {

    @Schema(title = "游戏ID")
    private Long gameId;

    @Schema(title = "数据追踪")
    private String scriptDesc;

}
