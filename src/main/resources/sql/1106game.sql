
--新增字段
ALTER TABLE `h5_game`.`game`
    ADD COLUMN `review_num` int(255) DEFAULT 0 COMMENT '游戏评论数' AFTER `game_desc`;

ALTER TABLE `h5_game`.`game_trigger`
    MODIFY COLUMN `type` int(0) NOT NULL COMMENT '类型 对应枚举2下载3打开' AFTER `game_id`;