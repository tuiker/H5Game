package com.hou_tai.response_vo;

import com.hou_tai.model.pojo.Game;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

/**
 * @ClassName: GameVo
 * @Description: 游戏输出
 * @Author: Sam
 * @Date: 2023-11-04 11:52
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper=false)
@Schema(title = "游戏输出")
public class MobileGameVo extends Game {

    @Schema(title = "游戏类型名称")
    private String typeName ;
    /** 游戏语言ID */
    @Schema(title = "游戏语言")
    private String languageName ;

    @Schema(title = "游戏评论集合")
    List<GameReviewVo> gameReviewList;
}
