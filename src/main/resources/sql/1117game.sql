-- 新增字段
ALTER TABLE `h5_game`.`game`
    ADD COLUMN `game_update_time` datetime DEFAULT NULL COMMENT '游戏更新日期' AFTER `dev_url`;