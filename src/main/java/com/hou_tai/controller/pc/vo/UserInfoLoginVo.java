package com.hou_tai.controller.pc.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 17:53
 * @Description: 用户登录后信息
 */
@Data
@Schema(title = "用户登录信息", description = "用户信息对象")
public class UserInfoLoginVo {
    @Schema(title = "Id", description = "用户Id", name = "id")
    private long id;
    @Schema(title = "昵称", description = "用户昵称", name = "userName")
    private String userName;
    @Schema(title = "头像", description = "用户头像", name = "userImg")
    private String userImg;


}
