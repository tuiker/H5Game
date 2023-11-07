
--新增字段
ALTER TABLE `h5_game`.`game`
    ADD COLUMN `review_num` int(255) DEFAULT 0 COMMENT '游戏评论数' AFTER `game_desc`;