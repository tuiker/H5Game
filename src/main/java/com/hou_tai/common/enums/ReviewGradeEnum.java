package com.hou_tai.common.enums;

import lombok.Getter;

/**
 * @Author: GaoLu
 * @Date: 2023-11-06 17:03
 * @Description: 评论打分 枚举
 */
@Getter
public enum ReviewGradeEnum {
    ONE_STAR(1, "一星"),
    TWO_STAR(2, "二星"),
    THREE_STAR(3, "三星"),
    FOUR_STAR(4, "四星"),
    FIVE_STAR(5, "五星");

    private int code;
    private String msg;

    ReviewGradeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getValue(int code) {
        for (ReviewGradeEnum ele : values()) {
            if (ele.getCode() == code) return ele.getMsg();
        }
        return null;
    }

}
