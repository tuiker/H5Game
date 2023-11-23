package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hou_tai.model.dto.ScriptDescSaveReqDTO;
import com.hou_tai.model.pojo.GameExtend;

/**
 * 游戏扩展 Service接口
 * @Author yxf
 **/
public interface IGameExtendService extends IService<GameExtend> {

    /**
     * 根据游戏ID获取游戏APK扩展信息
     * @param gameId 游戏ID
     * @return 游戏APK扩展信息
     */
    GameExtend getGameExtendByGameId(Long gameId);

    /**
     * 根据游戏ID修改游戏APK扩展信息
     *
     * @param gameExtend 游戏APK扩展信息
     */
    void updateByGameId(GameExtend gameExtend);

    /**
     * 根据游戏ID删除
     * @param gameId 游戏ID
     */
    void deleteByGameId(Long gameId);

}
