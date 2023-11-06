package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.pojo.ReviewReply;
import com.hou_tai.model.vo.ReviewReplyVo;

import java.util.List;

/**
 * @InterfaceName: GameService
 * @Description: 游戏方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IReviewReplyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReviewReply queryById(Integer id);

    /**
     * 分页查询
     *
     * @param reviewReply 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<ReviewReply> pageQuery(ReviewReply reviewReply, long current, long size);
    /**
     * 新增数据
     *
     * @param reviewReply 实例对象
     * @return 实例对象
     */
    ReviewReply insert(ReviewReply reviewReply);
    /**
     * 更新数据
     *
     * @param reviewReply 实例对象
     * @return 实例对象
     */
    ReviewReply update(ReviewReply reviewReply);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<ReviewReplyVo> getListByReviewIds(List<Integer> reviewIds);
}
