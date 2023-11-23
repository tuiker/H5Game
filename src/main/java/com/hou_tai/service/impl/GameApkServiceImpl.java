package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.GameApkMapper;
import com.hou_tai.model.pojo.GameApk;
import com.hou_tai.service.IGameApkService;
import org.springframework.stereotype.Service;

/**
 * 游戏APK扩展 Service接口实现
 * @Author yxf
 */
@Service
public class GameApkServiceImpl extends ServiceImpl<GameApkMapper, GameApk> implements IGameApkService {


    /**
     * 根据游戏ID获取游戏APK扩展信息
     * @param gameId 游戏ID
     * @return 游戏APK扩展信息
     */
    @Override
    public GameApk getGameApkByGameId(Long gameId) {
        return this.lambdaQuery().eq(GameApk::getGameId, gameId).one();
    }

    /**
     * 根据游戏ID修改游戏APK扩展信息
     *
     * @param gameApk 游戏APK扩展信息
     */
    @Override
    public void updateByGameId(GameApk gameApk) {
        //先根据游戏ID查询
        GameApk gameApkByGameId = this.getGameApkByGameId(gameApk.getGameId());
        if(null == gameApkByGameId){ //为空则新增
            this.save(gameApk);
        }else { //不为空则修改
            this.update(gameApk, new LambdaUpdateWrapper<GameApk>().eq(GameApk::getGameId, gameApk.getGameId()));
        }
    }

    /**
     * 根据游戏ID删除
     * @param gameId 游戏ID
     */
    @Override
    public void deleteByGameId(Long gameId) {
        this.lambdaUpdate().eq(GameApk::getGameId, gameId).remove();
    }
}
