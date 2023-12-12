-- 新增游戏列表按钮权限
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (11, '添加游戏', 3, 3, NULL, 'addGame', NULL, 1, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (12, '删除游戏', 3, 3, NULL, 'deleteGame', NULL, 1, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (13, '编辑游戏', 3, 3, NULL, 'editGame', NULL, 1, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (14, '插入评论', 3, 3, NULL, 'addReview', NULL, 1, 1);
INSERT INTO `h5_game`.`sys_menu` (`id`, `name`, `type`, `parent_id`, `path`, `component`, `icon`, `sort`, `hidden`) VALUES (15, '数据追踪', 3, 3, NULL, 'addScript', NULL, 1, 1);
