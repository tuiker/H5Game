package com.hou_tai.controller.pc.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(title = "登录用户")
public class UserDto {

    @Schema(title = "密码", description = "密码", name = "password")
    @NotNull(message = "密码不能为空")
    private String password;
    @Schema(title = "账号", description = "账户信息", name = "account")
    private String account;

}
