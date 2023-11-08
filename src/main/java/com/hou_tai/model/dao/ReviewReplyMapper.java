package com.hou_tai.model.dao;

import com.github.yulichang.base.MPJBaseMapper;
import com.hou_tai.model.pojo.ReviewReply;

public interface ReviewReplyMapper extends MPJBaseMapper<ReviewReply> {
    int deleteByPrimaryKey(Integer id);

    int insert(ReviewReply record);

    int insertSelective(ReviewReply record);

    ReviewReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReviewReply record);

    int updateByPrimaryKey(ReviewReply record);
}