ALTER TABLE `h5_game`.`game_review`
    MODIFY COLUMN `review_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '评论内容' AFTER `game_id`,
    MODIFY COLUMN `review_time` datetime NOT NULL COMMENT '评论时间' AFTER `review_content`,
    ADD COLUMN `review_grade` int NULL COMMENT '评论打分' AFTER `help_num`,
    ADD COLUMN `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '回复内容' AFTER `review_grade`,
    ADD COLUMN `reply_time` datetime(0) NULL COMMENT '回复时间' AFTER `reply_content`,
    ADD COLUMN `have_reply` int NOT NULL DEFAULT 0 COMMENT '是否回复：0否；1是' AFTER `reply_time`;


ALTER TABLE `h5_game`.`game`
    MODIFY COLUMN `create_id` bigint NULL COMMENT '创建用户ID' AFTER `dev_url`,
    MODIFY COLUMN `create_time` datetime NULL AFTER `create_id`,
    MODIFY COLUMN `update_id` bigint NULL COMMENT '更新用户ID' AFTER `create_time`;