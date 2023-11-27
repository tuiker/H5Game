package com.hou_tai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.auth.entity.LoginUser;
import com.hou_tai.common.enums.ResultCode;
import com.hou_tai.model.dao.UserInfoMapper;
import com.hou_tai.model.dto.UserDto;
import com.hou_tai.model.dto.UserLoginReqDTO;
import com.hou_tai.model.pojo.UserInfo;
import com.hou_tai.model.redis.LoginUserRedisDAO;
import com.hou_tai.common.response.ResponseData;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.response_vo.UserInfoLoginVo;
import com.hou_tai.response_vo.UserInfoVo;
import com.hou_tai.response_vo.UserLoginRespVO;
import com.hou_tai.service.IUserInfoService;
import com.hou_tai.common.util.MD5Utils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private LoginUserRedisDAO loginUserRedisDAO;


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
            UserInfoLoginVo loginVo = BeanUtil.copyProperties(userInfo, UserInfoLoginVo.class);
            return ResponseData.success(loginVo);
        } else
            return ResponseData.error(ResultCode.ERROR_USER_OR_PASSWORD);
    }

    /**
     * 用户登录
     * @param reqDTO
     * @return
     */
    @Transactional
    @Override
    public ResultVO<UserLoginRespVO> loginUser(UserLoginReqDTO reqDTO) {
        UserInfo user = this.lambdaQuery().eq(UserInfo::getUserName, reqDTO.getUsername())
                .eq(UserInfo::getPassword, MD5Utils.MD5(reqDTO.getPassword())).one();
        if (null != user) {
            //登录成功，创建token，存入缓存
            String token = IdUtil.fastSimpleUUID();
            LoginUser loginUser = BeanUtil.copyProperties(user, LoginUser.class);
            loginUser.setToken(token);
            loginUserRedisDAO.set(token, loginUser);

            //修改最近登录时间
            UserInfo updateUser = new UserInfo();
            updateUser.setId(user.getId());
            updateUser.setRecentLoginTime(LocalDateTime.now());
            userInfoMapper.updateByPrimaryKeySelective(updateUser);

            //将用户的基本信息及token返回给前端
            UserLoginRespVO respVO = BeanUtil.copyProperties(user, UserLoginRespVO.class);
            respVO.setToken(token);
            return ResponseData.success(respVO);
        } else
            return ResponseData.error(ResultCode.ERROR_USER_OR_PASSWORD);
    }


    public UserInfoVo getUserInfoById(long id) {
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        return BeanUtil.copyProperties(userInfo, UserInfoVo.class);
    }

    public Long getRandomUserId(){
        return userInfoMapper.getRandomUserId();
    }

}
