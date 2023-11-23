/*
 Navicat Premium Data Transfer

 Source Server         : dev
 Source Server Type    : MySQL
 Source Server Version : 80100
 Source Host           : localhost:3306
 Source Schema         : h5_game

 Target Server Type    : MySQL
 Target Server Version : 80100
 File Encoding         : 65001

 Date: 23/11/2023 09:51:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for game_apk
-- ----------------------------
DROP TABLE IF EXISTS `game_extend`;
CREATE TABLE `game_extend` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
    `apk_link` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT 'APK链接',
    `script_desc` varchar(3000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '数据追踪',
    `user_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '客户名',
    `game_id` bigint NOT NULL COMMENT '游戏ID',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `uk_game_id` (`game_id`) USING BTREE COMMENT '游戏ID唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='游戏扩展表';

SET FOREIGN_KEY_CHECKS = 1;
