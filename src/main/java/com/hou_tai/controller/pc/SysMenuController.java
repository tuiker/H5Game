package com.hou_tai.controller.pc;

import cn.hutool.core.collection.CollectionUtil;
import com.hou_tai.common.constant.CommConstant;
import com.hou_tai.common.response.ResponseData;
import com.hou_tai.common.response.ResultVO;
import com.hou_tai.common.util.SecurityUtils;
import com.hou_tai.response_vo.SysMenuRespVO;
import com.hou_tai.service.ISysMenuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 系统菜单按钮权限控制层
 * @Author yxf
 */
@Slf4j
@RestController
@RequestMapping("/pc/sysMenu")
@Tag(name = "admin端 - 系统菜单按钮权限控制层")
public class SysMenuController {

    @Resource
    private ISysMenuService sysMenuService;

    @Operation(summary = "根据用户获取它的权限列表")
    @GetMapping("/getList")
    public ResultVO<List<SysMenuRespVO>> getSysMenuList(){
        return ResponseData.success(generateTree(sysMenuService.getSysMenuList()));
    }

    /**
     * 将菜单/按钮数组转为树结构，方便前端展示及路由的生成
     * @param list 菜单/按钮数组
     * @return 树结构的菜单/按钮
     */
    private List<SysMenuRespVO> generateTree(List<SysMenuRespVO> list){
        if(CollectionUtil.isEmpty(list)){
            return list;
        }
        //利用权限数组创建一个map，key：权限ID，value：权限对象
        Map<Integer, SysMenuRespVO> permissionMap = list.stream().collect(Collectors.toMap(SysMenuRespVO::getId, obj -> obj));
        //遍历权限数组
        for (SysMenuRespVO item : list){
            if(!CommConstant.ROOT_MENU_ID.equals(item.getParentId())){//如果当前权限不是顶层菜单
                //通过parentId在map中拿到父级
                SysMenuRespVO parent = permissionMap.get(item.getParentId());
                //将当前权限加入子节点
                parent.getChildrenList().add(item);
            }
        }
        //返回过滤子节点后的权限数组，这样就是一个树结构的菜单树
        return list.stream().filter(item -> CommConstant.ROOT_MENU_ID.equals(item.getParentId())).toList();
    }

}
