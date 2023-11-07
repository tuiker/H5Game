package com.hou_tai.enums;

import lombok.Getter;

/**
 * @Author: Sam
 * @Date: 2023-11-07
 * @Description: 数据概览看板枚举类
 */
@Getter
public enum DataBoardTypeEnums {

    REQUESTS(1, "1","页面请求数"),

    DOWNLAND(2, "2","应用下载数"),

    OPEN(3,"3", "打开应用数");

    private int code;
    private String codeStr;
    private String msg;

    DataBoardTypeEnums(int code, String codeStr , String msg) {
        this.code = code;
        this.codeStr = codeStr;
        this.msg = msg;
    }

}
