package com.hou_tai.model.dto;

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
@Schema(title = "游戏查询入参")
public class MobileGameReviewDto extends PageDaoEntity {

    @Schema(title = "游戏id")
    private Long gameId;


    @Schema(title = "评价分数",description = "1-5")
    private Integer reviewGrade;

}
