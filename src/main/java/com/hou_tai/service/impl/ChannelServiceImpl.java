package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.ChannelMapper;
import com.hou_tai.model.pojo.Channel;
import com.hou_tai.service.IChannelService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: GaoLu
 * @Date: 2023-10-26 9:44
 * @Description: 渠道实现类
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements IChannelService {



    @Override
    public List<Channel> listByChannel() {
        return this.list();
    }



}
