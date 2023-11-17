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

 Date: 03/11/2023 23:42:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel`  (
                            `id` int NOT NULL AUTO_INCREMENT COMMENT '渠道ID',
                            `channel_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '其他' COMMENT '渠道名称',
                            PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '渠道表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES (1, 'FacBook');
INSERT INTO `channel` VALUES (2, 'Google Play');
INSERT INTO `channel` VALUES (3, 'TikTok');
INSERT INTO `channel` VALUES (4, 'KuaiShou');
INSERT INTO `channel` VALUES (5, '其他');

-- ----------------------------
-- Table structure for game
-- ----------------------------
DROP TABLE IF EXISTS `game`;
CREATE TABLE `game`  (
                         `id` int NOT NULL COMMENT '游戏ID',
                         `game_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '游戏名称',
                         `game_type` int NOT NULL COMMENT '游戏类型',
                         `language_id` int NOT NULL DEFAULT 0 COMMENT '游戏语言ID',
                         `game_logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '游戏LOGO',
                         `game_main_logo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '游戏主图',
                         `game_background` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '游戏背景',
                         `game_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '游戏地址',
                         `game_desc` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '游戏描述',
                         `data_security` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '数据安全',
                         `game_grade` int NULL DEFAULT 0 COMMENT '游戏评分',
                         `game_download` int NULL DEFAULT 0 COMMENT '游戏下载次数',
                         `game_age` int NULL DEFAULT 0 COMMENT '游戏适合年龄',
                         `dev_email` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '开发者邮箱',
                         `dev_url` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '0' COMMENT '开发者地址',
                         `game_update_time` datetime DEFAULT NULL COMMENT '游戏更新日期',
                         `create_id` bigint NOT NULL COMMENT '创建用户ID',
                         `create_time` datetime NOT NULL,
                         `update_id` bigint NOT NULL COMMENT '更新用户ID',
                         `update_time` datetime NULL DEFAULT NULL,
                         `deleted` tinyint NOT NULL DEFAULT '0' COMMENT '逻辑删除标识，1：已删除，0：未删除',
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游戏表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of game
-- ----------------------------

-- ----------------------------
-- Table structure for game_review
-- ----------------------------
DROP TABLE IF EXISTS `game_review`;
CREATE TABLE `game_review`  (
                                `id` int NOT NULL AUTO_INCREMENT COMMENT '游戏评论ID',
                                `user_id` bigint NOT NULL COMMENT '用户ID',
                                `game_id` int NOT NULL COMMENT '游戏ID',
                                `review_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '评论内容',
                                `review_time` datetime NULL DEFAULT NULL COMMENT '评论时间',
                                `help_num` int NULL DEFAULT NULL COMMENT '评价有帮助数',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游戏评论表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of game_review
-- ----------------------------

-- ----------------------------
-- Table structure for game_type
-- ----------------------------
DROP TABLE IF EXISTS `game_type`;
CREATE TABLE `game_type`  (
                              `id` int NOT NULL AUTO_INCREMENT COMMENT '游戏类型ID',
                              `type_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '其他' COMMENT '游戏类型名称',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游戏类型表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of game_type
-- ----------------------------
INSERT INTO `game_type` VALUES (1, '三消');
INSERT INTO `game_type` VALUES (2, '解压');
INSERT INTO `game_type` VALUES (3, '酷跑');
INSERT INTO `game_type` VALUES (4, '其他');

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language`  (
                             `id` int NOT NULL AUTO_INCREMENT COMMENT '语言ID',
                             `language_name` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '其他' COMMENT '语言',
                             PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '语言表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES (1, '英语');
INSERT INTO `language` VALUES (2, '葡萄牙语');
INSERT INTO `language` VALUES (3, '印度语');
INSERT INTO `language` VALUES (4, '其他');
INSERT INTO `language` VALUES (5, '日语');
INSERT INTO `language` VALUES (6, '韩语');
INSERT INTO `language` VALUES (7, '印尼语');

-- ----------------------------
-- Table structure for review_reply
-- ----------------------------
DROP TABLE IF EXISTS `review_reply`;
CREATE TABLE `review_reply`  (
                                 `id` int NOT NULL AUTO_INCREMENT COMMENT '回复ID',
                                 `user_id` bigint NOT NULL COMMENT '用户ID',
                                 `review_id` int NOT NULL COMMENT '评论ID',
                                 `reply_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '回复内容',
                                 `reply_time` datetime NOT NULL COMMENT '回复时间',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '评论回复表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of review_reply
-- ----------------------------

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
                              `id` bigint NOT NULL COMMENT '用户ID',
                              `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
                              `user_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
                              `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户密码',
                              `recent_login_time` datetime NULL DEFAULT NULL COMMENT '最近登录时间',
                              `create_id` int NULL DEFAULT NULL,
                              `create_time` datetime NULL DEFAULT NULL,
                              `update_id` int NULL DEFAULT NULL,
                              `update_time` datetime NULL DEFAULT NULL,
                              `role_id` int NULL DEFAULT NULL COMMENT '角色ID',
                              `channel_id` int NULL DEFAULT NULL COMMENT '渠道ID',
                              PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
