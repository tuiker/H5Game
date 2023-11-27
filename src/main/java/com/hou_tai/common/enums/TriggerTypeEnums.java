package com.hou_tai.common.enums;

import lombok.Getter;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 15:03
 * @Description: 游戏类型枚举类
 */
@Getter
public enum TriggerTypeEnums {

    REQUESTS(1, "1","页面请求"),

    DOWNLAND(2, "2","应用下载"),

    OPEN(3,"3", "打开应用");

    private int code;
    private String codeStr;
    private String msg;

    TriggerTypeEnums(int code, String codeStr , String msg) {
        this.code = code;
        this.codeStr = codeStr;
        this.msg = msg;
    }
}
