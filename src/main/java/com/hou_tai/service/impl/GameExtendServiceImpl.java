package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.GameExtendMapper;
import com.hou_tai.model.dto.ScriptDescSaveReqDTO;
import com.hou_tai.model.pojo.GameExtend;
import com.hou_tai.service.IGameExtendService;
import org.springframework.stereotype.Service;

/**
 * 游戏扩展 Service接口实现
 * @Author yxf
 */
@Service
public class GameExtendServiceImpl extends ServiceImpl<GameExtendMapper, GameExtend> implements IGameExtendService {


    /**
     * 根据游戏ID获取游戏APK扩展信息
     * @param gameId 游戏ID
     * @return 游戏APK扩展信息
     */
    @Override
    public GameExtend getGameExtendByGameId(Long gameId) {
        return this.lambdaQuery().eq(GameExtend::getGameId, gameId).one();
    }

    /**
     * 根据游戏ID修改游戏APK扩展信息
     *
     * @param gameExtend 游戏APK扩展信息
     */
    @Override
    public void updateByGameId(GameExtend gameExtend) {
        //先根据游戏ID查询
        GameExtend gameExtendByGameId = this.getGameExtendByGameId(gameExtend.getGameId());
        if(null == gameExtendByGameId){ //为空则新增
            this.save(gameExtend);
        }else { //不为空则修改
            this.update(gameExtend, new LambdaUpdateWrapper<GameExtend>().eq(GameExtend::getGameId, gameExtend.getGameId()));
        }
    }

    /**
     * 根据游戏ID删除
     * @param gameId 游戏ID
     */
    @Override
    public void deleteByGameId(Long gameId) {
        this.lambdaUpdate().eq(GameExtend::getGameId, gameId).remove();
    }
}
