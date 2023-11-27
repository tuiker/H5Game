package com.hou_tai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.hou_tai.common.enums.GameTypeEnums;
import com.hou_tai.common.enums.LanguageTypeEnum;
import com.hou_tai.common.constant.CommonNum;
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
    public DataBoardVo getAllStates(Long gameId) {
        DataBoardVo dataBoardVo = new DataBoardVo();
        int num1=gameTriggerMapper.getCountByToday(CommonNum.ONE);
        int num2=gameTriggerMapper.getCountByToday(CommonNum.TWO);
        int num3=gameTriggerMapper.getCountByToday(CommonNum.THREE);
        log.info("今日请求数据：》》》》》》"+num1);
        log.info("今日下载数据：》》》》》》"+num2);
        log.info("今日打开数据：》》》》》》"+num3);
        dataBoardVo.setTodayRequestNum(gameTriggerMapper.getCountByToday(CommonNum.ONE));
        dataBoardVo.setTodayDownloadNum(gameTriggerMapper.getCountByToday(CommonNum.TWO));
        dataBoardVo.setTodayOpenNum(gameTriggerMapper.getCountByToday(CommonNum.THREE));
        dataBoardVo.setRequestDataOfTime(gameTriggerMapper.getNumForSevenDay(gameId, CommonNum.ONE));
        dataBoardVo.setDownloadDataOfTime(gameTriggerMapper.getNumForSevenDay(gameId, CommonNum.TWO));
        dataBoardVo.setOpenDataOfTime(gameTriggerMapper.getNumForSevenDay(gameId, CommonNum.THREE));
        //封装游戏概括
        List<GameGeneralizeVo> list = new ArrayList<>();
        List<Game> gameList = gameMapper.selectList(null);
        if (ObjectUtil.isNotNull(gameList) && gameList.size() > 0) {
            gameList.forEach(game -> {
                GameGeneralizeVo gameGeneralizeVo = new GameGeneralizeVo();
                gameGeneralizeVo.setGameName(game.getGameName());
                gameGeneralizeVo.setGameType(GameTypeEnums.getValue(game.getGameType()));
                gameGeneralizeVo.setGameLanguage(LanguageTypeEnum.getValue(game.getLanguageId()));
                long id = game.getId();
                gameGeneralizeVo.setRequestNum(gameTriggerMapper.getCountAll(CommonNum.ONE, id));
                gameGeneralizeVo.setDownloadNum(gameTriggerMapper.getCountAll(CommonNum.TWO, id));
                gameGeneralizeVo.setOpenNum(gameTriggerMapper.getCountAll(CommonNum.THREE, id));
                list.add(gameGeneralizeVo);
            });
        }
        dataBoardVo.setGameGeneralize(list);
        return dataBoardVo;
    }


}
