package com.hou_tai.common.enums;

import lombok.Getter;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 15:03
 * @Description: 游戏类型枚举类
 */
@Getter
public enum GameTypeEnums {
    THREE_REMOVE(1, "三消"),

    DECOMPRESSION(2, "解压"),

    PARKOUR(3, "酷跑"),

    OTHER(4, "其他");

    private int code;
    private String msg;

    GameTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getValue(int code) {
        for (GameTypeEnums ele : values()) {
            if (ele.getCode() == code) return ele.getMsg();
        }
        return null;
    }
}
