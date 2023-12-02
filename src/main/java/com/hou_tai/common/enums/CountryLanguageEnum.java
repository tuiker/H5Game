package com.hou_tai.common.enums;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: GaoLu
 * @Date: 2023-10-23 16:28
 * @Description: 语言枚举
 */
@Getter
@Slf4j
public enum CountryLanguageEnum {
    ENGLISH("英语",1),
    PORTUGUESE("BR",2 ), //巴西——葡萄牙语
    HINDI("印度语",3),
    OTHER("其他",4),
    JAPANESE("JP",5), //日本
    KOREAN("KR",6 ),
    INDONESIAN("印尼语",7 );


    private String msg;
    private int code;

    CountryLanguageEnum(String msg,int code) {
        this.code = code;
        this.msg = msg;
    }

    public static Integer getValue(String msg) {
        log.info("得到的参数》》》》》》"+msg);
        log.info("得到的参数values》》》》》》"+CountryLanguageEnum.values().length);
        for (CountryLanguageEnum ele : CountryLanguageEnum.values()) {
            if (ele.getMsg() == msg) return ele.getCode();
        }
        return null;
    }
}
