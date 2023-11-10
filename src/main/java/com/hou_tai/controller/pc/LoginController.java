package com.hou_tai.controller.pc;

import com.hou_tai.model.dto.UserDto;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: LoginController
 * @Description: 登录
 * @Author: Sam
 * @Date: 2023-11-10 13:14
 * @Version: 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/pc/user")
@Tag(name = "后台用户控制控制层")
public class LoginController {

    @Resource
    IUserInfoService userInfoService;

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public ResultVO loginUser(@RequestBody UserDto dto) {
        return userInfoService.loginUser(dto);
    }

}
