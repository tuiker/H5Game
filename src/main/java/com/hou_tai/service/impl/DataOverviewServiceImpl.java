package com.hou_tai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.hou_tai.enums.GameTypeEnums;
import com.hou_tai.enums.LanguageTypeEnum;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.dao.ChannelDataMapper;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dao.GameTriggerMapper;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.GameGeneralizeVo;
import com.hou_tai.service.IDataOverviewService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: Sam
 * @Date:2023-10-18 13:41
 */
@Service
public class DataOverviewServiceImpl implements IDataOverviewService {

    @Resource
    private ChannelDataMapper channelDataMapper;
    @Resource
    private GameTriggerMapper gameTriggerMapper;
    @Resource
    private GameMapper gameMapper;

    @Override
    public DataBoardVo getAllStates() {
        DataBoardVo dataBoardVo = new DataBoardVo();
        Integer requestNum=channelDataMapper.getCountByToday(CommonNum.ZERO);
        dataBoardVo.setTodayRequestNum(requestNum==null?0:requestNum);
        dataBoardVo.setTodayDownloadNum(gameTriggerMapper.getCountByToday(CommonNum.TWO, CommonNum.ZERO));
        dataBoardVo.setTodayOpenNum(gameTriggerMapper.getCountByToday(CommonNum.THREE, CommonNum.ZERO));
        dataBoardVo.setRequestDataOfTime(channelDataMapper.getNumForSevenDay());
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
                Integer requestNum2=channelDataMapper.getCountByToday(CommonNum.ZERO);
                gameGeneralizeVo.setRequestNum(requestNum2==null?0:requestNum);
                gameGeneralizeVo.setDownloadNum(gameTriggerMapper.getCountByToday(CommonNum.TWO, gameId));
                gameGeneralizeVo.setOpenNum(gameTriggerMapper.getCountByToday(CommonNum.THREE, gameId));
                list.add(gameGeneralizeVo);
            });
        }
        dataBoardVo.setGameGeneralize(list);
        return dataBoardVo;
    }


}
