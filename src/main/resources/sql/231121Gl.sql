ALTER TABLE `h5_game`.`game`
    ADD COLUMN `script_desc` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '脚本描述' AFTER `deleted`;

ALTER TABLE `h5_game`.`game`
    MODIFY COLUMN `script_desc` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '脚本描述' AFTER `deleted`;