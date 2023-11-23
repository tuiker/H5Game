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
@TableName("game_apk")
@Schema(title = "游戏APK扩展表")
public class GameApk {

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 游戏ID
     */
    private Long gameId;

    /**
     * APK链接
     */
    private String apkLink;

    /**
     * 数据追踪
     */
    private String scriptDesc;

    /**
     * 客户名称
     */
    private String userName;

}
