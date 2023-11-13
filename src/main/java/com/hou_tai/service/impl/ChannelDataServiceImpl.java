package com.hou_tai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.model.dao.ChannelDataMapper;
import com.hou_tai.model.pojo.ChannelData;
import com.hou_tai.service.IChannelDataService;
import org.springframework.stereotype.Service;

/**
 * @Author: GaoLu
 * @Date: 2023-11-13 10:44
 * @Description: 渠道数据同步Service
 */
@Service
public class ChannelDataServiceImpl extends ServiceImpl<ChannelDataMapper, ChannelData> implements IChannelDataService {
}
