package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hou_tai.enums.ResultCode;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dao.GameTriggerMapper;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameTrigger;
import com.hou_tai.response.ResponseData;
import com.hou_tai.response.ResultVO;
import com.hou_tai.service.IGameTriggerService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Resource
    private GameMapper gameMapper;

    @Override
    public ResultVO<String> insertByPoint(PointDto dto) {
        List<Game> list = null;
        String apkLink = "";
        if(StrUtil.isNotBlank(dto.getApkName())){
            Map<String, Object> map = new HashMap<>();
            map.put("apk_name", dto.getApkName());
            list = gameMapper.selectByMap(map);

            if(CollectionUtil.isNotEmpty(list)){
                apkLink = list.get(0).getApkLink();
            }
        }

        //3.应用打开类型   根据APK包名找到对应 gameId
        if (CommonNum.THREE == dto.getTriggerType()) {
            if (CollectionUtil.isNotEmpty(list)) {
                dto.setGameId(list.get(0).getId());
            } else
                return ResponseData.error("请先上传APK包", ResultCode.ERROR);
        }
        insert(GameTrigger.builder().gameId(dto.getGameId()).type(dto.getTriggerType()).createTime(LocalDateTime.now()).build());
        return ResponseData.success(apkLink);
    }

    /**
     * 新增数据
     *
     * @param gameTrigger 实例对象
     * @return 实例对象
     */
    public GameTrigger insert(GameTrigger gameTrigger) {
        this.save(gameTrigger);
        return gameTrigger;
    }

}
