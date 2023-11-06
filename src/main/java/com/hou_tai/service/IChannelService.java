package com.hou_tai.service;

import com.hou_tai.model.pojo.Channel;
import com.hou_tai.model.pojo.GameType;

import java.util.List;

/**
 * @InterfaceName: GameService
 * @Description: 游戏类型方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IChannelService {

    List<Channel> listByChannel();

}
