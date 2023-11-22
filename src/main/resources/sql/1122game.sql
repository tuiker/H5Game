-- 新增字段
ALTER TABLE `h5_game`.`game`
    ADD COLUMN `apk_link` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'APK链接' AFTER `apk_name`;