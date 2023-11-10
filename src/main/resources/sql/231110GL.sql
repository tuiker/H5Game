ALTER TABLE `h5_game`.`game`
    ADD COLUMN `game_fall_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '落地页地址' AFTER `game_label`;