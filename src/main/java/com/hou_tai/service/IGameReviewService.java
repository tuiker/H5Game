package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.dto.PointDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.pojo.GameReview;
import com.hou_tai.model.vo.GameReviewVo;
import com.hou_tai.model.vo.GameVo;

/**
 * @InterfaceName: GameService
 * @Description: 游戏方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IGameReviewService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GameReview queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return
     */
    Page<GameReviewVo> pageQuery(GameDto dto);
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

    boolean addHelpNum(PointDto dto);



    boolean saveReply(GameReview gameReview);

}
