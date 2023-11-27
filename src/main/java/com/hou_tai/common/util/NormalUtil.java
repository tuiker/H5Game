package com.hou_tai.common.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName: NormalUtil
 * @Description: map数据处理
 * @Author: Sam
 * @Date: 2023-10-27 10:14
 * @Version: 1.0
 **/
public class NormalUtil {

    public static Map<String,Integer> mapToList(List<Map<String,Object>> listMap){
        return listMap.stream().collect(Collectors.toMap(
                m ->  m.get("id").toString(),
                m -> Integer.valueOf(m.get("num").toString())));
    }

    public static Map<String,Integer> mapToListByKv(List<Map<String,Object>> listMap, String key, String value){
        return listMap.stream().collect(Collectors.toMap(
                m ->  m.get(key).toString(),
                m -> Integer.valueOf(m.get(value).toString())));
    }

    public static Integer getMapValue(Map<String, Integer> map,String key){
        return map.get(key)!=null?map.get(key):0;
    }

    public static void main(String[] args) {
//        List<String> months = getLast12Months();
//        System.out.println(months);
    }
}
