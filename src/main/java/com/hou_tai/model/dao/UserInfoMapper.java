package com.hou_tai.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.controller.pc.dto.UserPageReqDTO;
import com.hou_tai.controller.pc.vo.UserInfoVO;
import com.hou_tai.model.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

public interface UserInfoMapper extends BaseMapper<UserInfo> {
    Long getRandomUserId();

    Page<UserInfoVO> pageList(Page<UserInfo> page, @Param("reqDTO") UserPageReqDTO reqDTO);
}