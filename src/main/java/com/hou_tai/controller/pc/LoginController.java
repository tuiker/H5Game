package com.hou_tai.controller.pc;

import cn.hutool.core.util.StrUtil;
import com.hou_tai.auth.entity.LoginUser;
import com.hou_tai.common.util.SecurityUtils;
import com.hou_tai.common.enums.ResultCode;
import com.hou_tai.model.dto.UserLoginReqDTO;
import com.hou_tai.model.redis.LoginUserRedisDAO;
import com.hou_tai.common.response.ResponseData;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.response_vo.UserInfoVo;
import com.hou_tai.response_vo.UserLoginRespVO;
import com.hou_tai.service.IUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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

    @Resource
    private LoginUserRedisDAO loginUserRedisDAO;

//    @Operation(summary = "用户登录")
//    @PostMapping("/login")
//    public ResultVO loginUser(@RequestBody UserDto dto) {
//        return userInfoService.loginUser(dto);
//    }

    @Operation(summary = "用户登录")
    @PostMapping("/userLogin")
    public ResultVO<UserLoginRespVO> userLogin(@RequestBody UserLoginReqDTO reqDTO) {
        if(StrUtil.isBlank(reqDTO.getUsername()) || StrUtil.isBlank(reqDTO.getPassword())){
            return ResponseData.error(ResultCode.VALIDATE_FAILED);
        }

        return userInfoService.loginUser(reqDTO);
    }

    @Operation(summary = "用户登出")
    @PostMapping("/loginOut")
    public ResultVO<Boolean> loginOut(){
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if(null != loginUser){
            loginUserRedisDAO.remove(loginUser.getToken());
        }
        return ResponseData.success(true);
    }

    @Operation(summary = "获取我的个人信息")
    @GetMapping("/getMyUserInfo")
    public ResultVO<UserInfoVo> getMyUserInfo() {
        Long loginUserId = SecurityUtils.getLoginUserId();
        return new ResultVO<>(userInfoService.getUserInfoById(loginUserId));
    }

}
