--设置自增
ALTER TABLE `h5_game`.`game`
    MODIFY COLUMN `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '游戏ID' FIRST;


--新建触发表
CREATE TABLE `game_trigger`  (
                         `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
                         `game_id` int(0) NOT NULL COMMENT '游戏ID',
                         `type` int(0) NOT NULL COMMENT '类型 对应枚举1下载2打开',
                         `create_time` datetime(0) DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 385 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '游戏触发记录表' ROW_FORMAT = Dynamic;