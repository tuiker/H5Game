package com.hou_tai.response_vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hou_tai.model.pojo.Game;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class GameVo extends Game{

//    @Schema(title = "游戏id")
//    @TableField(value = "id")
//    private Integer id ;
//
//    @Schema(title = "游戏名称")
//    @TableField(value = "game_name")
//    private String gameName ;
//    /** 游戏类型 */
//    @Schema(title = "游戏类型")
//    @TableField(value = "game_type")
//    private Integer gameType ;
//    /** 游戏语言ID */
//    @Schema(title = "游戏语言ID")
//    @TableField(value = "language_id")
//    private Integer languageId ;
//    /** 游戏LOGO */
//    @Schema(title = "游戏LOGO")
//    @TableField(value = "game_logo")
//    private String gameLogo ;

    @Schema(title = "游戏类型名称")
    @TableField(value = "type_name")
    private String typeName ;
    /** 游戏语言ID */
    @Schema(title = "游戏语言")
    @TableField(value = "language_name")
    private String languageName ;

    @Schema(title = "评论数")
    @TableField(value = "review_num")
    private Integer reviewNum ;

}
