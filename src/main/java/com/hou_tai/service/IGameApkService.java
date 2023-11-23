package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hou_tai.model.pojo.GameApk;

/**
 * 游戏APK扩展 Service接口
 * @Author yxf
 **/
public interface IGameApkService extends IService<GameApk> {

    /**
     * 根据游戏ID获取游戏APK扩展信息
     * @param gameId 游戏ID
     * @return 游戏APK扩展信息
     */
    GameApk getGameApkByGameId(Long gameId);

    /**
     * 根据游戏ID修改游戏APK扩展信息
     *
     * @param gameApk 游戏APK扩展信息
     */
    void updateByGameId(GameApk gameApk);

    /**
     * 根据游戏ID删除
     * @param gameId 游戏ID
     */
    void deleteByGameId(Long gameId);

}
