package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.GameTriggerMapper;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.*;
import com.hou_tai.service.IGameTriggerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @ClassName: GameServiceImpl
 * @Description: 游戏实现
 * @Author: Sam
 * @Date: 2023-11-04 11:39
 * @Version: 1.0
 **/
@Service
@AllArgsConstructor
public class GameTriggerServiceImpl extends ServiceImpl<GameTriggerMapper, GameTrigger> implements IGameTriggerService {


    @Override
    public boolean insertByPoint(PointDto dto) {
        boolean result=false;
        try {
            insert(GameTrigger.builder().gameId(dto.getGameId()).type(dto.getTriggerType()).createTime(LocalDateTime.now()).build());
            result=true;
        }catch (Exception e){
            e.printStackTrace();
            result=false;
        }
        return result;
    }

    /**
     * 新增数据
     *
     * @param gameTrigger 实例对象
     * @return 实例对象
     */
    public GameTrigger insert(GameTrigger gameTrigger){
        this.save(gameTrigger);
        return gameTrigger;
    }

}
