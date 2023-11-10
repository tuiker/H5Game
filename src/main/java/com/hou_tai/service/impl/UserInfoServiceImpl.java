package com.hou_tai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.enums.ResultCode;
import com.hou_tai.model.dao.UserInfoMapper;
import com.hou_tai.model.dto.UserDto;
import com.hou_tai.model.pojo.UserInfo;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.response_vo.UserInfoLoginVo;
import com.hou_tai.service.IUserInfoService;
import com.hou_tai.util.MD5Utils;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 14:08
 * @Description: 用户信息表 服务类
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;


    @Override
    public ResultVO loginUser(UserDto dto) {
        QueryWrapper<UserInfo> qw = new QueryWrapper<>();
        qw.eq("user_name", dto.getAccount());
        qw.eq("password", MD5Utils.MD5(dto.getPassword()));
        List<UserInfo> userInfoList = this.list(qw);
        if (ObjectUtil.isNotNull(userInfoList) && userInfoList.size() > 0) {
            UserInfo userInfo = userInfoList.get(0);
            //修改最近登录时间
            UserInfo updateUser=new UserInfo();
            updateUser.setId(userInfo.getId());
            updateUser.setRecentLoginTime(LocalDateTime.now());
            userInfoMapper.updateByPrimaryKeySelective(updateUser);
            UserInfoLoginVo loginVo = new UserInfoLoginVo();
            BeanUtils.copyProperties(userInfo, loginVo);
            return ResponseData.success(loginVo);
        } else
            return ResponseData.error(ResultCode.ERROR_USER_OR_PASSWORD);
    }


    public Long getRandomUserId(){
        return userInfoMapper.getRandomUserId();
    }

}
