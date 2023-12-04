package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hou_tai.model.pojo.SysMenu;
import com.hou_tai.response_vo.SysMenuRespVO;

import java.util.List;

/**
 * 菜单或按钮权限 Service接口
 * @Author yxf
 **/
public interface ISysMenuService extends IService<SysMenu> {

    /**
     * 根据用户获取它的权限列表
     */
    List<SysMenuRespVO> getSysMenuList();

}
