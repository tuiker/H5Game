-- 新增字段
ALTER TABLE `h5_game`.`game`
    ADD COLUMN `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除标识，1：已删除，0：未删除' AFTER `game_fall_url`;