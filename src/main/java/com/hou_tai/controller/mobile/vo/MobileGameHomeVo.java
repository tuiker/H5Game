package com.hou_tai.controller.mobile.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hou_tai.model.base.PageDaoEntity;
import com.hou_tai.model.pojo.Game;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2023-10-21
 * @Description: 游戏首页出参
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(title = "游戏首页出参")
public class MobileGameHomeVo  implements Serializable {

    @Schema(title = "游戏ID")
    @TableField(value = "id")
    private Long id;
    /**
     * 游戏名称
     */
    @Schema(title = "游戏名称")
    @TableField(value = "game_name")
    private String gameName;
    /**
     * 游戏类型
     */
//    @Schema(title = "游戏类型")
//    @TableField(value = "game_type")
//    private Integer gameType;
    /**
     * 游戏语言ID
     */
//    @Schema(title = "游戏语言ID")
//    @TableField(value = "language_id")
//    private Integer languageId;
    /**
     * 游戏LOGO
     */
    @Schema(title = "游戏LOGO")
    @TableField(value = "game_logo")
    private String gameLogo;

    @Schema(title = "游戏类型名称")
    private String typeName ;
    /** 游戏语言ID */
    @Schema(title = "游戏语言")
    private String languageName ;

    /**
     * 游戏主图
     */
    @Schema(title = "游戏主图")
    @TableField(value = "game_main_logo")
    private String gameMainLogo;

    /**
     * 游戏评分
     */
    @Schema(title = "游戏评分")
    @TableField(value = "game_grade")
    private Double gameGrade;

    @Schema(title = "游戏标签 用;分隔")
    @TableField(value = "game_label")
    private String gameLabel;

    @Schema(title = "游戏")
    @TableField(value = "apk_name")
    private String apkName;


}
