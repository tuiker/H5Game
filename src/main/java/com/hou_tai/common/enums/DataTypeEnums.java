package com.hou_tai.common.enums;

import lombok.Getter;

/**
 * @Author: Sam
 * @Date: 2023-11-07
 * @Description: 数据概览枚举类
 */
@Getter
public enum DataTypeEnums {

    BOARD(1, "1","看板数据"),

    LINE(2, "2","折线数据"),

    LIST(3,"3", "概览数据");

    private int code;
    private String codeStr;
    private String msg;

    DataTypeEnums(int code, String codeStr , String msg) {
        this.code = code;
        this.codeStr = codeStr;
        this.msg = msg;
    }

}
