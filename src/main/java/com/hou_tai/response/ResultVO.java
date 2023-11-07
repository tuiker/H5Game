package com.hou_tai.response;

import com.hou_tai.enums.ResultCode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 16:06
 * @Description: 统一响应体类
 */
@Getter
@Setter
@NoArgsConstructor
@Schema(title = "返回", description = "返回对象")
public class ResultVO<T> {

    @Schema(title = "状态码", description = "状态码", name = "code")
    private int code;

    @Schema(title = "响应信息", description = "响应信息，用来说明响应情况", name = "msg")
    private String msg;

    @Schema(title = "数据", description = "响应的具体数据", name = "data")
    private T data;

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
        this.data = data;
    }

    public ResultVO<T> setCodeAndMsg(ResultCode resultsCode) {
        this.code = resultsCode.getCode();
        this.msg = resultsCode.getMsg();
        return this;
    }

    public ResultVO<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultVO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public ResultVO<T> setData(T data) {
        this.data = data;
        return this;
    }


    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';

    }


}
