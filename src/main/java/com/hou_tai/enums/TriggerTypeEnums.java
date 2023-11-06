package com.hou_tai.enums;

import lombok.Getter;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 15:03
 * @Description: 游戏类型枚举类
 */
@Getter
public enum TriggerTypeEnums {

    DOWNLOAD(1, "下载"),

    OPEN(2, "打开");

    private int code;
    private String msg;

    TriggerTypeEnums(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getValue(int code) {
        for (TriggerTypeEnums ele : values()) {
            if (ele.getCode() == code) return ele.getMsg();
        }
        return null;
    }
}
