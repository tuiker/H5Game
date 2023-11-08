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

 Date: 08/11/2023 08:58:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for channel_data
-- ----------------------------
DROP TABLE IF EXISTS `channel_data`;
CREATE TABLE `channel_data`  (
  `id` int NOT NULL,
  `channel_id` int NOT NULL DEFAULT 1 COMMENT '渠道ID',
  `request_data` int NULL DEFAULT NULL COMMENT '请求次数',
  `record_time` datetime NULL DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '渠道数据表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
