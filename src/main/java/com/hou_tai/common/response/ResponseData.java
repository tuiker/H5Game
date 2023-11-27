package com.hou_tai.common.response;

import com.hou_tai.common.enums.ResultCode;

/**
 * @Author:GaoLu
 * @Date:2023-11-01 10:58
 * @Description:
 */
public class ResponseData {

    private final static String FORBIDDEN = "forbidden";


    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<T>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg()).setData(data);
    }

    public static <T> ResultVO<T> success(ResultCode resultCode, T data) {
        return new ResultVO<T>().setCodeAndMsg(resultCode).setData(data);
    }

    public static <T> ResultVO<T> success(ResultCode resultCode, String msg, T data) {
        return new ResultVO<T>().setCode(resultCode.getCode()).setMsg(msg).setData(data);
    }

    public static ResultVO success() {
        return new ResultVO().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg());
    }

    public static ResultVO forbidden() {
        return new ResultVO().setCode(ResultCode.FORBIDDEN.getCode()).setMsg(FORBIDDEN);
    }

    public static ResultVO authError() {
        return error(ResultCode.AUTH_ERROR);
    }

   /* public static <T> ResultVO<T> error(ResultCode ResultCode) {
        return new ResultVO<T>().setCode(ResultCode.getCode()).setMsg(ResultCode.getMsg());
    }*/


    public static <T> ResultVO<T> error() {
        return new ResultVO<T>().setCodeAndMsg(ResultCode.FAILED);
    }

    public static <T> ResultVO<T> error(String mesage, ResultCode ResultCode) {
        return new ResultVO<T>().setMsg(mesage).setCode(ResultCode.getCode());
    }

    public static <T> ResultVO<T> error(ResultCode ResultCode) {
        return new ResultVO<T>().setCodeAndMsg(ResultCode);
    }

}
