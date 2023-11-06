package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameType;
import com.hou_tai.model.vo.GameVo;

import java.util.List;

/**
 * @InterfaceName: GameService
 * @Description: 游戏类型方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IGameTypeService {

    List<GameType> list();

}
