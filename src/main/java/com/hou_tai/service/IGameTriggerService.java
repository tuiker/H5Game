package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameTrigger;
import com.hou_tai.model.vo.GameVo;

/**
 * @InterfaceName: GameService
 * @Description: 游戏方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IGameTriggerService {

    boolean insertByPoint(PointDto dto);
    GameTrigger insert(GameTrigger gameTrigger);
}
