package com.hou_tai.common.enums;

import lombok.Getter;

/**
 * @Author: GaoLu
 * @Date: 2023-10-23 16:28
 * @Description: 语言枚举
 */
@Getter
public enum LanguageTypeEnum {
    ENGLISH(1, "英语"),
    PORTUGUESE(2, "葡萄牙语"),
    HINDI(3, "印度语"),
    OTHER(4, "其他"),
    JAPANESE(5, "日语"),
    KOREAN(6, "韩语"),
    INDONESIAN(7, "印尼语");

    private int code;
    private String msg;

    LanguageTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getValue(int code) {
        for (LanguageTypeEnum ele : values()) {
            if (ele.getCode() == code) return ele.getMsg();
        }
        return null;
    }
}
