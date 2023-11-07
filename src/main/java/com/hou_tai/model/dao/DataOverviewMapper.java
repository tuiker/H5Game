package com.hou_tai.model.dao;

import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.LinesStatesVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DataOverviewMapper {

    List<DataBoardVo> getNum();

    List<LinesStatesVo> getStats(@Param("dto") DataDto dto, @Param("type") Integer type);

}