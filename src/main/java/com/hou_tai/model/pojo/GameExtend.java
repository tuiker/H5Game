package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("game_extend")
@Schema(title = "游戏扩展表")
public class GameExtend {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 游戏ID
     */
    @TableField(value = "game_id")
    private Long gameId;

    /**
     * APK链接
     */
    @TableField(value = "apk_link")
    private String apkLink;

    /**
     * 数据追踪
     */
    @TableField(value = "script_desc")
    private String scriptDesc;

    /**
     * 客户名称
     */
    @TableField(value = "user_name")
    private String userName;

}
