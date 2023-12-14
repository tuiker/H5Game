package com.hou_tai.controller.pc.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.hou_tai.model.base.PageDaoEntity;
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
@Schema(description = "游戏查询入参")
public class GameDto extends PageDaoEntity {

    @Schema(description = "游戏id", type = "Long")
    private Long gameId;

    @Schema(description = "游戏名称", type = "String")
    private String gameName;
}
