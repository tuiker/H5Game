package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hou_tai.common.vo.PageResult;
import com.hou_tai.controller.pc.dto.*;
import com.hou_tai.model.pojo.UserInfo;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.controller.pc.vo.UserInfoVO;
import com.hou_tai.controller.pc.vo.UserLoginRespVO;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 14:07
 * @Description: 用户信息表 服务接口
 */
public interface IUserInfoService extends IService<UserInfo> {


    /**
     * @Description 用户登录
     * @Author GaoLu
     * @Date 2023/10/25
     * @Return
     * @Param addUserInfoDao
     **/
    ResultVO loginUser(UserDto dto);

    /**
     * 用户登录
     * @param reqDTO
     * @return
     */
    ResultVO<UserLoginRespVO> loginUser(UserLoginReqDTO reqDTO);

    /**
     * @Description 用户详情
     * @Author GaoLu
     * @Date 2023/10/19
     * @Return
     * @Param id
     **/
    UserInfoVO getUserInfoById(long id);

    Long getRandomUserId();

    /**
     * 分页查询用户列表
     * @param reqDTO
     * @return
     */
    PageResult<UserInfoVO> pageList(UserPageReqDTO reqDTO);

    /**
     * 添加系统用户
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> addSysUser(SysUserAddReqDTO reqDTO);

    /**
     * 修改系统用户
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateSysUser(SysUserUpdateReqDTO reqDTO);

    /**
     * 修改系统用户密码
     * @param reqDTO
     * @return
     */
    ResultVO<Boolean> updateSysUserPassword(SysUserPasswordUpdateReqDTO reqDTO);
}
