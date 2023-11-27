package com.hou_tai.common.enums;

import lombok.Getter;

/**
 * @Author: GaoLu
 * @Date: 2023-10-27 14:24
 * @Description: 广告位置枚举
 */
@Getter
public enum AdvPositionEnum {
    RESET(1, "重置"),
    REMOVE(2, "移除"),
    RANDOM(3, "随机"),
    DEATH(3, "死亡"),
    OTHER(5, "其他"),
    GET_GOLD(6, "获取金币"),
    GET_SKIN(6, "获取皮肤"),
    GET_BACKDROP(6, "获取背景");

    private int code;
    private String msg;

    AdvPositionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String getValue(int code) {
        for (AdvPositionEnum ele : values()) {
            if (ele.getCode() == code)
                return ele.getMsg();
        }
        return null;
    }


}
