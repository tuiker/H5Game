package com.hou_tai.controller.pc;

import com.hou_tai.common.response.ResponseData;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.common.vo.PageResult;
import com.hou_tai.controller.pc.dto.SysUserAddReqDTO;
import com.hou_tai.controller.pc.dto.SysUserPasswordUpdateReqDTO;
import com.hou_tai.controller.pc.dto.SysUserUpdateReqDTO;
import com.hou_tai.controller.pc.dto.UserPageReqDTO;
import com.hou_tai.controller.pc.vo.UserInfoVO;
import com.hou_tai.service.IUserInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/pc/sysUser")
@Tag(name = "admin端 - 后台用户控制层")
public class SysUserController {

    @Resource
    IUserInfoService userInfoService;

    @Operation(summary = "分页查询用户列表")
    @GetMapping("/pageList")
    public ResultVO<PageResult<UserInfoVO>> pageList(@ParameterObject UserPageReqDTO reqDTO){
        return ResponseData.success(userInfoService.pageList(reqDTO));
    }

    @Operation(summary = "添加系统用户")
    @PostMapping("/addSysUser")
    public ResultVO<Boolean> addSysUser(@RequestBody SysUserAddReqDTO reqDTO){
        return userInfoService.addSysUser(reqDTO);
    }

    @Operation(summary = "修改系统用户")
    @PostMapping("/updateSysUser")
    public ResultVO<Boolean> updateSysUser(@RequestBody SysUserUpdateReqDTO reqDTO){
        return userInfoService.updateSysUser(reqDTO);
    }

    @Operation(summary = "修改系统用户密码")
    @PostMapping("/updateSysUserPassword")
    public ResultVO<Boolean> updateSysUserPassword(@RequestBody SysUserPasswordUpdateReqDTO reqDTO){
        return userInfoService.updateSysUserPassword(reqDTO);
    }

    @Operation(summary = "根据ID删除用户")
    @Parameter(name = "id", description = "用户ID", required = true)
    @DeleteMapping("/deleteById")
    public ResultVO<Boolean> deleteById(@RequestParam("id") Long id){
        userInfoService.removeById(id);
        return ResponseData.success(true);
    }

}
