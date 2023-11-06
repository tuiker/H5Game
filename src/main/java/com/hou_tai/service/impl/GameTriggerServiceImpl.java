package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dao.GameTriggerMapper;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.*;
import com.hou_tai.model.vo.GameReviewVo;
import com.hou_tai.model.vo.GameVo;
import com.hou_tai.model.vo.ReviewReplyVo;
import com.hou_tai.service.IGameReviewService;
import com.hou_tai.service.IGameService;
import com.hou_tai.service.IGameTriggerService;
import com.hou_tai.service.IReviewReplyService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
