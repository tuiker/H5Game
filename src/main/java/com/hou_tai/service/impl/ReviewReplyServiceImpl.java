package com.hou_tai.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.model.dao.ReviewReplyMapper;
import com.hou_tai.model.pojo.*;
import com.hou_tai.response_vo.ReviewReplyVo;
import com.hou_tai.service.IReviewReplyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: GameServiceImpl
 * @Description: 游戏实现
 * @Author: Sam
 * @Date: 2023-11-04 11:39
 * @Version: 1.0
 **/
@Service
@AllArgsConstructor
public class ReviewReplyServiceImpl extends ServiceImpl<ReviewReplyMapper, ReviewReply> implements IReviewReplyService {

    /**
     * 通过ID查询单条数据 
     *
     * @param id 主键
     * @return 实例对象
     */
    public ReviewReply queryById(Integer id){
        return baseMapper.selectById(id);
    }

    /**
     * 分页查询
     *
     * @param reviewReply 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<ReviewReply> pageQuery(ReviewReply reviewReply, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<ReviewReply> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(reviewReply.getReplyContent())){
            queryWrapper.eq(ReviewReply::getReplyContent, reviewReply.getReplyContent());
        }
        //2. 执行分页查询
        Page<ReviewReply> pagin = new Page<>(current , size , true);
//        IPage<ReviewReply> selectResult = baseMapper.selectByPage(pagin , queryWrapper);
//        pagin.setPages(selectResult.getPages());
//        pagin.setTotal(selectResult.getTotal());
//        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param reviewReply 实例对象
     * @return 实例对象
     */
    public ReviewReply insert(ReviewReply reviewReply){
        baseMapper.insert(reviewReply);
        return reviewReply;
    }

    /**
     * 更新数据
     *
     * @param reviewReply 实例对象
     * @return 实例对象
     */
    public ReviewReply update(ReviewReply reviewReply){
        //1. 根据条件动态更新
        LambdaUpdateChainWrapper<ReviewReply> chainWrapper = new LambdaUpdateChainWrapper<ReviewReply>(baseMapper);
        if(StrUtil.isNotBlank(reviewReply.getReplyContent())){
            chainWrapper.eq(ReviewReply::getReplyContent, reviewReply.getReplyContent());
        }
        //2. 设置主键，并更新
        chainWrapper.set(ReviewReply::getId, reviewReply.getId());
        boolean ret = chainWrapper.update();
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(reviewReply.getId());
        }else{
            return reviewReply;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id){
        int total = baseMapper.deleteById(id);
        return total > 0;
    }

    public List<ReviewReplyVo> getListByReviewIds(List<Integer> reviewIds){
        List<ReviewReplyVo> voList=this.baseMapper.selectJoinList(ReviewReplyVo.class, new MPJLambdaWrapper<ReviewReply>()
                .selectAll(ReviewReply.class)
                .select("u.user_name")
                .leftJoin(UserInfo.class,"u", UserInfo::getId,ReviewReply::getUserId)
                .in(ReviewReply::getReviewId,reviewIds));
            return voList;
    }
}
