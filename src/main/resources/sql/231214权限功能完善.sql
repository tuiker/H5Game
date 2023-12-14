-- 创建角色表
CREATE TABLE `sys_role` (
                                                  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                                  `role_name` varchar(30) NOT NULL COMMENT '角色名称',
                                                  `role_code` varchar(30) NOT NULL COMMENT '角色编码',
                                                  `role_describe` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
                                                  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色信息表';


-- 创建角色-权限关联表
CREATE TABLE `sys_role_menu` (
                                                       `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                                       `role_id` int NOT NULL COMMENT '角色ID',
                                                       `menu_id` int NOT NULL COMMENT '权限（菜单或按钮）ID',
                                                       PRIMARY KEY (`id`),
                                                       KEY `idx_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色-权限关联表';

-- 将父级为根目录的权限的parentId改为-1
UPDATE `sys_menu` SET parent_id = -1 WHERE parent_id = 0

-- 新增系统管理权限数据
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (18, '系统管理', 1, -1, '/system', NULL, 'el-icon-setting', 99, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (19, '菜单管理', 2, 18, '/sysMenuManage', '/system/SysMenuManage', 'el-icon-menu', 1, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (22, '用户管理', 2, 18, '/sysUser', '/system/SysUserManage', 'el-icon-user', 2, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (23, '角色管理', 2, 18, '/roleManage', '/system/SysRoleManage', 'el-icon-s-custom', 3, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (24, '添加用户', 3, 22, '', 'addUser', '', 1, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (25, '修改用户', 3, 22, '', 'editUser', '', 2, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (26, '修改密码', 3, 22, '', 'updatePassword', '', 3, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (27, '删除用户', 3, 22, '', 'deleteUser', '', 4, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (28, '添加角色', 3, 23, '', 'addRole', '', 1, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (29, '修改角色', 3, 23, '', 'editRole', '', 2, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (30, '删除角色', 3, 23, '', 'deleteRole', '', 3, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (31, '查看', 3, 3, '', 'seeDetails', '', 6, 0);
INSERT INTO `sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (32, '回复', 3, 9, '', 'reply', '', 1, 0);


-- 删除用户-权限关联表
DROP TABLE IF EXISTS `sys_user_menu`;