package com.hou_tai.response_vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.hou_tai.model.base.PageDaoEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Sam
 * @Date: 2023-10-21
 * @Description: 游戏首页出参
 */
@Data
@Builder
@Schema(title = "游戏首页出参")
public class MobileGameHomeVo extends PageDaoEntity implements Serializable {

    @Schema(title = "首页展示类型 1近期2为您推荐3个性化")
    private Integer homeType;

    @Schema(title = "游戏集合")
    List<MobileGameVo> gameVoList;

}
