package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.GameTypeMapper;
import com.hou_tai.model.pojo.GameType;
import com.hou_tai.service.IGameTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Sam
 * @Date:2023-10-23
 * @Description:
 */
@Service
public class GameTypeServiceImpl extends ServiceImpl<GameTypeMapper, GameType> implements IGameTypeService {

    @Override
    public List<GameType> listByGameType() {
        return this.list();
    }
}
