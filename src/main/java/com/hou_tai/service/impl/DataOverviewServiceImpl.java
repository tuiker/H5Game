package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.hou_tai.enums.DataTypeEnums;
import com.hou_tai.enums.TriggerTypeEnums;
import com.hou_tai.model.dao.DataOverviewMapper;
import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.DataLineVo;
import com.hou_tai.response_vo.DataListVo;
import com.hou_tai.service.IDataOverviewService;
import com.hou_tai.util.BeanUtil;
import com.hou_tai.util.DateUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Stream;


/**
 * @Author: Sam
 * @Date:2023-10-18 13:41
 */
@Service
public class DataOverviewServiceImpl implements IDataOverviewService {

    @Resource
    DataOverviewMapper dataOverviewMapper;

    @Override
    public List<DataBoardVo> getBoardList() {
        List<DataBoardVo> list=this.dataOverviewMapper.getBoardList();
        return list;
    }
    @Override
    public Map<String,List<DataLineVo>> getLinesList(DataDto dto) {
        List<String> dateList=DateUtil.getDatesBetween(dto.getStartDate(), dto.getEndDate(),false);
        Map<String,List<DataLineVo>> map=new HashMap<>();

        List<DataLineVo> dataList=new ArrayList<>();
        dateList.stream().forEach(date->{
            dataList.add(DataLineVo.builder().days(date).total(0).build());
        });
        DataDto nDto=dto;
        Stream.of(TriggerTypeEnums.values()).forEach(e -> {
            //if(e.getCode()!=DataBoardTypeEnums.REQUESTS.getCode()){
                map.put(e.getCodeStr(), Arrays.asList());
                List<DataLineVo> realList=this.dataOverviewMapper.getLinesStats(nDto,e.getCode());
                List<DataLineVo> allList= BeanUtil.copyListProperties(dataList, DataLineVo.class);
                if(CollectionUtil.isNotEmpty(realList)){
                    allList.stream().forEach(all->{
                        realList.stream()
                                .filter(real -> all.getDays().equals(real.getDays()))
                                .findFirst()
                                .ifPresent(vo -> {
                                    if (vo != null && vo.getTotal() > 0) {
                                        all.setTotal(vo.getTotal());
                                    }
                                });
                    });
                }
                if(CollectionUtil.isNotEmpty(allList)){
                    map.put(e.getCodeStr(),allList);
                }
           // }
        });
        return map;
    }


    @Override
    public List<DataListVo> getListStats(){
        return dataOverviewMapper.getListStats();
    }


    public Map<String,Object> getAllStates(DataDto dto){
        Map<String,Object> map=new HashMap<>();
        map.put(DataTypeEnums.BOARD.getCodeStr(), getBoardList());
        map.put(DataTypeEnums.LINE.getCodeStr(), getLinesList(dto));
        map.put(DataTypeEnums.LIST.getCodeStr(), getListStats());
        return map;
    }








}
