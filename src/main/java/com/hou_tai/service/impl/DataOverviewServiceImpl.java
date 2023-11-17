package com.hou_tai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.hou_tai.enums.GameTypeEnums;
import com.hou_tai.enums.LanguageTypeEnum;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dao.GameTriggerMapper;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.GameGeneralizeVo;
import com.hou_tai.service.IDataOverviewService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Sam
 * @Date:2023-10-18 13:41
 */
@Service
@Slf4j
public class DataOverviewServiceImpl implements IDataOverviewService {
    @Resource
    private GameTriggerMapper gameTriggerMapper;
    @Resource
    private GameMapper gameMapper;

    @Override
    public DataBoardVo getAllStates() {
        DataBoardVo dataBoardVo = new DataBoardVo();
        int num1=gameTriggerMapper.getCountByToday(CommonNum.ONE);
        int num2=gameTriggerMapper.getCountByToday(CommonNum.TWO);
        int num3=gameTriggerMapper.getCountByToday(CommonNum.THREE);
        log.info("今日请求数据：》》》》》》"+num1);
        log.info("今日下载数据：》》》》》》"+num2);
        log.info("今日打开数据：》》》》》》"+num3);
        dataBoardVo.setTodayRequestNum(num1);
        dataBoardVo.setTodayDownloadNum(num2);
        dataBoardVo.setTodayOpenNum(num3);
        dataBoardVo.setRequestDataOfTime(gameTriggerMapper.getNumForSevenDay(CommonNum.ONE));
        dataBoardVo.setDownloadDataOfTime(gameTriggerMapper.getNumForSevenDay(CommonNum.TWO));
        dataBoardVo.setOpenDataOfTime(gameTriggerMapper.getNumForSevenDay(CommonNum.THREE));
        //封装游戏概括
        List<GameGeneralizeVo> list = new ArrayList<>();
        List<Game> gameList = gameMapper.selectList(null);
        if (ObjectUtil.isNotNull(gameList) && gameList.size() > 0) {
            gameList.forEach(game -> {
                GameGeneralizeVo gameGeneralizeVo = new GameGeneralizeVo();
                gameGeneralizeVo.setGameName(game.getGameName());
                gameGeneralizeVo.setGameType(GameTypeEnums.getValue(game.getGameType()));
                gameGeneralizeVo.setGameLanguage(LanguageTypeEnum.getValue(game.getLanguageId()));
                long gameId = game.getId();
                gameGeneralizeVo.setRequestNum(gameTriggerMapper.getCountAll(CommonNum.ONE, gameId));
                gameGeneralizeVo.setDownloadNum(gameTriggerMapper.getCountAll(CommonNum.TWO, gameId));
                gameGeneralizeVo.setOpenNum(gameTriggerMapper.getCountAll(CommonNum.THREE, gameId));
                list.add(gameGeneralizeVo);
            });
        }
        dataBoardVo.setGameGeneralize(list);
        return dataBoardVo;
    }


}
