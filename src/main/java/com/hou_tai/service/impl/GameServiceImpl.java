package com.hou_tai.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.hou_tai.model.dao.GameMapper;
import com.hou_tai.model.dto.GameDto;
import com.hou_tai.model.pojo.*;
import com.hou_tai.model.vo.GameReviewVo;
import com.hou_tai.model.vo.GameVo;
import com.hou_tai.model.vo.ReviewReplyVo;
import com.hou_tai.service.IGameReviewService;
import com.hou_tai.service.IGameService;
import com.hou_tai.service.IReviewReplyService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @ClassName: GameServiceImpl
 * @Description: 游戏实现
 * @Author: Sam
 * @Date: 2023-11-04 11:39
 * @Version: 1.0
 **/
@Service
@AllArgsConstructor
public class GameServiceImpl extends ServiceImpl<GameMapper, Game> implements IGameService {

    @Resource
    IGameReviewService gameReviewService;

    @Resource
    IReviewReplyService reviewReplyService;

    public Game queryById(Integer id){
        return this.getById(id);
    }

    public GameVo getVoById(GameDto dto){
        GameVo gameVo=this.baseMapper.selectJoinOne(GameVo.class, new MPJLambdaWrapper<Game>()
                .selectAll(Game.class)
                .select("gt.type_name,l.language_name")
                .leftJoin(GameType.class,"gt", GameType::getId,Game::getGameType)
                .leftJoin(Language.class,"l", Language::getId,Game::getLanguageId)
                .eq(Game::getId, dto.getGameId()));
        if(gameVo!=null){
            //加载评论
            Page<GameReviewVo> reviewPage=gameReviewService.pageQuery(dto);
            if(reviewPage.getTotal()>0){
                List<GameReviewVo> grList=reviewPage.getRecords();
                //回复数据
//                if(CollectionUtil.isNotEmpty(grList)){
//                    List<Integer> reviewIds=grList.stream().map(GameReview::getId).collect(Collectors.toList());
//                    List<ReviewReplyVo> replyList=reviewReplyService.getListByReviewIds(reviewIds);
//                    //填充
//                    if(CollectionUtil.isNotEmpty(replyList)) {
//                        grList.forEach(vo1 -> {
//                            replyList.stream().filter(vo2 -> vo1.getId() == vo2.getReviewId())
//                                    .findFirst().ifPresent(vo -> {
//                                        if (vo != null) {
//                                            List<ReviewReplyVo> rlist = vo1.getReviewReplyList();
//                                            if(CollectionUtil.isEmpty(rlist)){
//                                                rlist=new ArrayList<>();
//                                            }
//                                            rlist.add(vo);
//                                            vo1.setReviewReplyList(rlist);
//                                        }
//                                    });
//                        });
//                    }
//                }
                gameVo.setGameReviewList(grList);
            }
        }
        return gameVo;
    }

    /**
     * 分页查询
     *
     * @param dto 筛选条件
     * @return
     */
    public Page<GameVo> paginQuery(GameDto dto){
        Page<GameVo> pagin=this.baseMapper.selectJoinPage(
                new Page<>(dto.getPage(),dto.getPageSize()) ,
                GameVo.class, new MPJLambdaWrapper<Game>()
                        .selectAll(Game.class)
                        .select("u.user_name,l.language_name,gt.type_name")
                        .leftJoin(UserInfo.class,"u", UserInfo::getId,Game::getCreateId)
                        .leftJoin(Language.class,"l", Language::getId,Game::getLanguageId)
                        .leftJoin(GameType.class,"gt", GameType::getId,Game::getGameType)
                        .leftJoin(Game.class,"g", Game::getId,Game::getId));
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    public Game insert(Game game){
        this.save(game);
        return game;
    }

    /**
     * 更新数据
     *
     * @param game 实例对象
     * @return 实例对象
     */
    public Game update(Game game){
        //1. 根据条件动态更新
        LambdaUpdateWrapper<Game> wrapper = new LambdaUpdateWrapper<Game>();
            wrapper.set(StrUtil.isNotBlank(game.getGameName()),Game::getGameName, game.getGameName())
                   .set(StrUtil.isNotBlank(game.getGameLogo()),Game::getGameLogo, game.getGameLogo());
        if(StrUtil.isNotBlank(game.getGameMainLogo())){
            wrapper.set(Game::getGameMainLogo, game.getGameMainLogo());
        }
        if(StrUtil.isNotBlank(game.getGameBackground())){
            wrapper.set(Game::getGameBackground, game.getGameBackground());
        }
        if(StrUtil.isNotBlank(game.getGameUrl())){
            wrapper.set(Game::getGameUrl, game.getGameUrl());
        }
        if(StrUtil.isNotBlank(game.getGameDesc())){
            wrapper.set(Game::getGameDesc, game.getGameDesc());
        }
        if(StrUtil.isNotBlank(game.getDataSecurity())){
            wrapper.set(Game::getDataSecurity, game.getDataSecurity());
        }
        if(StrUtil.isNotBlank(game.getDevEmail())){
            wrapper.set(Game::getDevEmail, game.getDevEmail());
        }
        if(StrUtil.isNotBlank(game.getDevUrl())){
            wrapper.set(Game::getDevUrl, game.getDevUrl());
        }
        //2. 设置主键，并更新
        wrapper.eq(Game::getId, game.getId());
        boolean ret = this.update(wrapper);
        //3. 更新成功了，查询最最对象返回
        if(ret){
            return queryById(game.getId());
        }else{
            return game;
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    public boolean deleteById(Integer id){
        return this.removeById(id);
    }
}
