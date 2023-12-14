package com.hou_tai.model.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.model.pojo.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper extends MPJBaseMapper<SysRoleMenu> {

    List<Integer> getRoleMenuIds(Integer roleId);

}