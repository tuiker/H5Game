package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.hou_tai.enums.DataBoardTypeEnums;
import com.hou_tai.final_common.CommonNum;
import com.hou_tai.model.dao.DataOverviewMapper;
import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.LinesStatesVo;
import com.hou_tai.service.IDataOverviewService;
import com.hou_tai.util.BeanUtil;
import com.hou_tai.util.DateUtil;
import com.hou_tai.util.NormalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    public List<DataBoardVo> getDataList() {
        List<DataBoardVo> list=this.dataOverviewMapper.getNum();
        //访问数据来自渠道方
        DataBoardVo vo=new DataBoardVo();
        vo.setType(DataBoardTypeEnums.REQUESTS.getCode());
        vo.setTotal(CommonNum.ZERO);
        list.add(vo);
        return list;
    }
    @Override
    public Map<String,List<LinesStatesVo>> getLinesList(DataDto dto) {
        if(dto==null){//默认7天
            dto=new DataDto();
            dto.setStartDate(LocalDate.now().minusDays(6l));
            dto.setEndDate(LocalDate.now());
        }

        List<String> dateList=DateUtil.getDatesBetween(dto.getStartDate(), dto.getEndDate(),false);
        Map<String,List<LinesStatesVo>> map=new HashMap<>();

        List<LinesStatesVo> dataList=new ArrayList<>();
        dateList.stream().forEach(date->{
            dataList.add(LinesStatesVo.builder().days(date).total(0).build());
        });
        DataDto ndto=dto;
        Stream.of(DataBoardTypeEnums.values()).forEach(e -> {
            if(e.getCode()!=DataBoardTypeEnums.REQUESTS.getCode()){
                map.put(e.getCodeStr(), Arrays.asList());
                List<LinesStatesVo> realList=this.dataOverviewMapper.getStats(ndto,e.getCode());
                List<LinesStatesVo> allList= BeanUtil.copyListProperties(dataList,LinesStatesVo.class);
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
            }
        });
        //访问数据来自渠道方
        map.put(DataBoardTypeEnums.REQUESTS.getCodeStr(),dataList);
        return map;
    }










}
