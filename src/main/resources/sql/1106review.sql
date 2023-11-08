--新增回复人id
ALTER TABLE `h5_game`.`game_review`
    ADD COLUMN `reply_user_id` int(0) DEFAULT NULL COMMENT '回复人Id' AFTER `review_grade`;

--新增字段
ALTER TABLE `h5_game`.`game`
    ADD COLUMN `game_label` varchar(255) COMMENT '游戏标签 ;分割' AFTER `game_desc`;