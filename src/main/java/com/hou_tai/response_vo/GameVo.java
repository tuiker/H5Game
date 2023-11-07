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


    @Schema(title = "游戏类型名称")
    @TableField(value = "type_name")
    private String typeName ;
    /** 游戏语言ID */
    @Schema(title = "游戏语言")
    @TableField(value = "language_name")
    private String languageName ;


}
