package com.hou_tai.model.dao;

import com.hou_tai.model.pojo.Language;

public interface LanguageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Language record);

    int insertSelective(Language record);

    Language selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);
}