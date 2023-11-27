package com.hou_tai.common.util;

import java.util.Random;

/**
 * @Author: GaoLu
 * @Date: 2023-10-26 15:06
 * @Description: 验证码工具类
 */

public class VerifyCodeUtil {

    /**
     * 随机生成指定长度字符串验证码
     *
     * @param length 验证码长度
     */
    public static String generateVerifyCode(int length) {
        String strRange = "1234567890";
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < length; ++i) {
            char ch = strRange.charAt((new Random()).nextInt(strRange.length()));
            strBuilder.append(ch);
        }
        return strBuilder.toString();
    }

}
