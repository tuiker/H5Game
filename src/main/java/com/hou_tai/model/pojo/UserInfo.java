package com.hou_tai.model.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.nio.LongBuffer;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("user_info")
@Schema(title = "用户实体")
public class UserInfo {
    @Schema(title = "用户ID" )
    @TableId
    private Long id ;
    /** 用户名称 */
     @Schema(title = "用户名称" )
    private String userName ;
    /** 用户头像 */
     @Schema(title = "用户头像" )
    private String userImg ;
    /** 用户密码 */
     @Schema(title = "用户密码" )
    private String password ;
    /** 最近登录时间 */
     @Schema(title = "最近登录时间" )
    private LocalDateTime recentLoginTime ;
    /**  */
     @Schema(title = "" )
    private Integer createId ;
    /**  */
     @Schema(title = "" )
    private LocalDateTime createTime ;
    /**  */
     @Schema(title = "" )
    private Integer updateId ;
    /**  */
     @Schema(title = "" )
    private LocalDateTime updateTime ;
    /** 角色ID */
     @Schema(title = "角色ID" )
    private Integer roleId ;
    /** 渠道ID */
     @Schema(title = "渠道ID" )
    private Integer channelId ;

}