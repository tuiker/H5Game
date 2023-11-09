package com.hou_tai.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hou_tai.response.ResultVO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: UploadAspect
 * @Description: 切面处理上传数据
 * @Author: Sam
 * @Date: 2023-11-06 11:34
 * @Version: 1.0
 **/
@Component
@Aspect
public class UploadAspect {

    @Value("spring.profiles.active")
    private String active;

    @Value("mobile.path")
    private String mobilePath;

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
            if(jsonStr.contains("/home/file_storage")&&active.equals("test")){
                jsonStr=jsonStr.replaceAll("/home/file_storage",mobilePath);
                System.out.println(jsonStr);
            }
            return JSON.parseObject(jsonStr, clazz);
        }

        return result;
    }


}
