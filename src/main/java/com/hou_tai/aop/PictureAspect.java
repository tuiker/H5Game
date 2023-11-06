package com.hou_tai.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hou_tai.response.ResultVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PictureAspect
 * @Description: 切面处理图片
 * @Author: Sam
 * @Date: 2023-11-06 11:34
 * @Version: 1.0
 **/
@Component
@Aspect
public class PictureAspect {

    @Around("execution(* com.hou_tai.controller.*..*(..)) ")
    public Object run1(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        Object result = joinPoint.proceed(args);
        String jsonStr = null;
        Class<?> clazz = null;
        if(result instanceof ResultVO ){
            ResultVO restResult = (ResultVO) result;
            jsonStr = JSONObject.toJSONString(restResult);
            clazz = ResultVO.class;
        }
        if(jsonStr != null) {
            if(jsonStr.contains("/home/file_storage/image")){
                jsonStr=jsonStr.replaceAll("/home/file_storage","https://h5.cajbook.com");
                System.out.println(jsonStr);
            }
            return JSON.parseObject(jsonStr, clazz);
        }

        return result;
    }


}
