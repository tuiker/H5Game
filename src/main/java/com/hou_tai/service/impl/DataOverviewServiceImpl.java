package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.common.enums.GameTypeEnums;
import com.hou_tai.common.enums.LanguageTypeEnum;
import com.hou_tai.common.constant.CommonNum;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dao.GameTriggerMapper;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameExtend;
import com.hou_tai.controller.pc.vo.DataBoardVo;
import com.hou_tai.controller.pc.vo.GameGeneralizeVo;
import com.hou_tai.controller.pc.vo.GameVo;
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

        return dataBoardVo;
    }

    /**
     * 获取数据概况表格数据
     */
    @Override
    public List<GameGeneralizeVo> getDataProfilingTableData() {
        //封装游戏概括
        List<GameGeneralizeVo> list = new ArrayList<>();
        MPJLambdaWrapper<Game> mpjLambdaWrapper = new MPJLambdaWrapper<Game>().selectAll(Game.class)
                .select("ge.user_name")
                .leftJoin(GameExtend.class, "ge", GameExtend::getGameId, Game::getId);
        List<GameVo> gameVoList = gameMapper.selectJoinList(GameVo.class, mpjLambdaWrapper);
        if (CollectionUtil.isNotEmpty(gameVoList)) {
            gameVoList.forEach(game -> {
                long id = game.getId();
                GameGeneralizeVo gameGeneralizeVo = new GameGeneralizeVo();
                gameGeneralizeVo.setId(id);
                gameGeneralizeVo.setGameName(game.getGameName());
                gameGeneralizeVo.setGameType(GameTypeEnums.getValue(game.getGameType()));
                gameGeneralizeVo.setGameLanguage(LanguageTypeEnum.getValue(game.getLanguageId()));
                gameGeneralizeVo.setUserName(game.getUserName());
                gameGeneralizeVo.setRequestNum(gameTriggerMapper.getCountAll(CommonNum.ONE, id));
                gameGeneralizeVo.setDownloadNum(gameTriggerMapper.getCountAll(CommonNum.TWO, id));
                gameGeneralizeVo.setOpenNum(gameTriggerMapper.getCountAll(CommonNum.THREE, id));
                list.add(gameGeneralizeVo);
            });
        }

        return list;
    }


}
