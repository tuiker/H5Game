package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hou_tai.model.dto.UserDto;
import com.hou_tai.model.dto.UserLoginReqDTO;
import com.hou_tai.model.pojo.UserInfo;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.response_vo.UserInfoVo;
import com.hou_tai.response_vo.UserLoginRespVO;

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
    UserInfoVo getUserInfoById(long id);

    Long getRandomUserId();
}
