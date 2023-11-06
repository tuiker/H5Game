package com.hou_tai.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

/**
 * @ClassName: GameDto
 * @Description: 游戏入参
 * @Author: Sam
 * @Date: 2023-11-04 13:22
 * @Version: 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(title = "埋点数据入参")
public class PointDto {

    @Schema(title = "游戏id")
    private Integer gameId;

    @Schema(title = "评论id")
    private Integer reviewId;

    @Schema(title = "触发类型 1下载2打开")
    private Integer triggerType;
}
