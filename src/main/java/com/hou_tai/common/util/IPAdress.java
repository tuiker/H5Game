package com.hou_tai.common.util;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @Author: GaoLu
 * @Date: 2023-10-31 16:27
 * @Description: 获取访问人IP
 */
public class IPAdress {
    public static String getIp(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");

        String ipAdress = null;
        if (realIp == null) {
            if (forwarded == null) {
                ipAdress = remoteAddr;
            } else {
                ipAdress = remoteAddr + "/" + forwarded.split(",")[0];
            }
        } else {
            if (realIp.equals(forwarded)) {
                ipAdress = realIp;
            } else {
                if (forwarded != null) {
                    forwarded = forwarded.split(",")[0];
                }
                ipAdress = realIp + "/" + forwarded;
            }
        }
        if(ipAdress.contains("/")){//192.168.0.118/127.0.0.1
            ipAdress=ipAdress.substring(0,ipAdress.indexOf("/"));
        }
        return ipAdress;
    }

}

