
--图字段增长
ALTER TABLE `h5_game`.`game`
    MODIFY COLUMN `game_main_logo` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '游戏主图' AFTER `game_logo`;

--修改评分字段
ALTER TABLE `h5_game`.`game`
    MODIFY COLUMN `game_grade` decimal(2, 0) DEFAULT 0 COMMENT '游戏评分' AFTER `data_security`;