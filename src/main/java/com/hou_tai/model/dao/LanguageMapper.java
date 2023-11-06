package com.hou_tai.model.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.model.pojo.GameType;
import com.hou_tai.model.pojo.Language;

public interface LanguageMapper extends MPJBaseMapper<Language> {
    int deleteByPrimaryKey(Integer id);

    int insert(Language record);

    int insertSelective(Language record);

    Language selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);
}