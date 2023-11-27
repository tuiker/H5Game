package com.hou_tai.common.util;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.UseFeature;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: GaoLu
 * @Date: 2023-11-09 17:01
 * @Description: 获取APK包相关信息
 */
public class APKUtil {

    /**
     * @Description 解析APK包
     * @Author GaoLu
     * @Date 2023/11/9
     * @Return Apk相关信息
     * @Param apkUrl
     **/
    public static Map<String, Object> readApk(String apkUrl) {
        Map<String, Object> resMap = new HashMap<>();
        try (ApkFile apkFile = new ApkFile(new File(apkUrl))) {
            ApkMeta apkMeta = apkFile.getApkMeta();
            resMap.put("versionCode", apkMeta.getVersionCode());
            resMap.put("versionName", apkMeta.getVersionName());
            for (UseFeature feature : apkMeta.getUsesFeatures()) {
                System.out.println(feature.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resMap;
    }

    public static void main(String[] arg) {
        String filePath = "D:\\_A_GL\\program\\gong_si_about\\app-release(1).apk";

        try (ApkFile apkFile = new ApkFile(new File(filePath))) {
            ApkMeta apkMeta = apkFile.getApkMeta();
            System.out.println(apkMeta.getName());
            System.out.println(apkMeta.getPackageName());
            System.out.println(apkMeta.getVersionCode());
            System.out.println(apkMeta.getVersionName());
            for (UseFeature feature : apkMeta.getUsesFeatures()) {
                System.out.println(feature.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
