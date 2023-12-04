-- 创建权限（菜单及按钮）表
CREATE TABLE `sys_menu` (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                            `name` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限名称',
                            `type` tinyint NOT NULL COMMENT '权限类型：1:目录，2：菜单，3：按钮',
                            `parent_id` int NOT NULL DEFAULT '0' COMMENT '父级权限ID',
                            `path` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '路由地址',
                            `component` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组件路径',
                            `icon` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '菜单图标',
                            `sort` int DEFAULT NULL COMMENT '显示顺序',
                            `hidden` tinyint NOT NULL DEFAULT '0' COMMENT '是否隐藏：0：否，1：是',
                            PRIMARY KEY (`id`),
                            KEY `idx_type` (`type`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='权限表（包含菜单及按钮）';

-- 创建用户-权限关联表
CREATE TABLE `sys_user_menu` (
                                 `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键ID',
                                 `user_id` bigint NOT NULL COMMENT '用户ID',
                                 `menu_id` int NOT NULL COMMENT '菜单或按钮权限ID',
                                 PRIMARY KEY (`id`),
                                 KEY `idx_user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户菜单权限关联表';


-- 初始化权限表数据
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (2, '游戏管理', 1, 0, '/game_manage', NULL, 'el-icon-bangzhu', 2, 0);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (3, '游戏列表', 2, 2, '/game-lists', '/game_manage/game-list.vue', NULL, 1, 0);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (4, '新增游戏', 2, 2, '/add-game', '/game_manage/feature/add-game', NULL, 2, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (5, '编辑游戏', 2, 2, '/edit-game', '/game_manage/feature/edit_game', NULL, 3, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (6, '游戏详情', 2, 2, '/game-detail', '/game_manage/feature/game_detail', NULL, 4, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (7, '插入评论', 2, 2, '/add-review', '/game_manage/feature/add-review', NULL, 5, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (8, '评论管理', 1, 0, '/review_manage', NULL, 'advertisement', 3, 0);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (9, '评论列表', 2, 8, '/review_manage', '/review_manage/index', NULL, 1, 0);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (10, '回复评论', 2, 8, '/reply', '/review_manage/feature/add_reply', NULL, 2, 1);
