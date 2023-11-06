package com.hou_tai.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.pojo.Game;
import com.hou_tai.model.vo.GameVo;

/**
 * @InterfaceName: GameService
 * @Description: 游戏方法
 * @Author: Sam
 * @Date: 2023-11-04 11:37
 * @Version: 1.0
 **/
public interface IGameService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Game queryById(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GameVo getVoById(GameDto dto);

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return
     */
    Page<GameVo> paginQuery(GameDto dto);
    /**
     * 新增数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    Game insert(Game game);
    /**
     * 更新数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    Game update(Game game);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
}
