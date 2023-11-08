package com.hou_tai.model.dao;

import com.hou_tai.model.dto.DataDto;
import com.hou_tai.response_vo.DataBoardVo;
import com.hou_tai.response_vo.DataLineVo;
import com.hou_tai.response_vo.DataListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataOverviewMapper {

    List<DataBoardVo> getBoardList();

    List<DataLineVo> getLinesStats(@Param("dto") DataDto dto, @Param("type") Integer type);

    List<DataListVo> getListStats();

}