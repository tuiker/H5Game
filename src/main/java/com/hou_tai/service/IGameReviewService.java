package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hou_tai.model.base.PageDaoEntity;
import com.hou_tai.model.dto.MobileGameReviewDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.response_vo.GameReviewVo;
import com.hou_tai.response_vo.GameReviewPageVo;
import com.hou_tai.response_vo.MobileGameReviewVo;

/**
 * @InterfaceName: GameService
 * @Description: 游戏方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IGameReviewService extends IService<GameReview> {


    /**
     * @Description 分页查询 游戏评论 列表
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     * @Param pageDao 分页参数
     **/
    Page<GameReviewPageVo> getReviewPage(PageDaoEntity pageDao);

    /**
     * @Description 根据 游戏评论ID找 游戏评论详情
     * @Author GaoLu
     * @Date 2023/11/6
     * @Return
     * @Param id 游戏评论ID
     **/
    GameReviewPageVo getGameReviewById(Integer id);


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GameReview queryById(Integer id);

    /**
     * 分页查询-移动端
     *
     * @param dto 筛选条件
     * @return
     */
    Page<MobileGameReviewVo> pageQuery(MobileGameReviewDto dto);

    /**
     * 新增数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    GameReview insert(GameReview gameReview);

    /**
     * 更新数据
     *
     * @param gameReview 实例对象
     * @return 实例对象
     */
    GameReview update(GameReview gameReview);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * @Author Sam
     * @Description 添加评论帮助数
     * @Date 17:16 2023/11/8
     * @Param  * @param dto
     * @return GameReview
     **/
    GameReview addHelpNum(MobileGameReviewDto dto);

    /**
     * @Author Sam
     * @Description 评论保存
     * @Date 17:16 2023/11/8
     * @Param  * @param gameReview
     * @return boolean
     **/
    boolean saveReply(GameReview gameReview);


}
