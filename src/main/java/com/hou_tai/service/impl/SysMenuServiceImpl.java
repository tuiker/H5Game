package com.hou_tai.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.common.constant.CommConstant;
import com.hou_tai.common.util.SecurityUtils;
import com.hou_tai.model.dao.SysMenuMapper;
import com.hou_tai.model.pojo.SysMenu;
import com.hou_tai.response_vo.SysMenuRespVO;
import com.hou_tai.service.ISysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单或按钮权限 Service接口实现
 * @Author yxf
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    /**
     * 根据用户获取它的权限列表
     */
    @Override
    public List<SysMenuRespVO> getSysMenuList() {
        Long loginUserId = SecurityUtils.getLoginUserId();
        List<SysMenuRespVO> list;
        if(loginUserId == CommConstant.ADMIN_ID){
            list = BeanUtil.copyToList(this.list(), SysMenuRespVO.class);
        }else {
            list = baseMapper.getSysMenuListByUserId(loginUserId);
        }
        return list;
    }
}
