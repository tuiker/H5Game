package com.hou_tai.model.dto;

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
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(title = "移动端游戏查询入参")
public class MobileGameDto extends PageDaoEntity {

    @Schema(title = "游戏id")
    private Long gameId;

    @Schema(title = "游戏名称")
    private String gameName;

    @Schema(title = "游戏类型")
    private Integer gameType;
}
