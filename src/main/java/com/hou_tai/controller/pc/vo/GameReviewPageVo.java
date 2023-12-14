package com.hou_tai.controller.pc.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: GaoLu
 * @Date: 2023-11-06 15:48
 * @Description: 游戏评论列表输出
 */
@Data
@Schema(title = "游戏评论输出")
public class GameReviewPageVo {
    @Schema(title = "ID", description = "game_review_id", name = "id")
    private int id;
    @Schema(title = "游戏ID", description = "游戏ID", name = "gameId")
    private long gameId;
    @Schema(title = "游戏名称", description = "游戏名称", name = "gameName")
    private String gameName;
    @Schema(title = "评论内容", description = "评论内容", name = "reviewContent")
    private String reviewContent;
    @Schema(title = "回复内容", description = "回复内容", name = "replyContent")
    private String replyContent;
    @Schema(title = "评论打分", description = "评论打分", name = "reviewGrade")
    private String reviewGrade;
    @Schema(title = "创建时间", description = "评论时间", name = "reviewTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //后端返回给前端的时间格式
    private LocalDateTime reviewTime;
    @Schema(title = "是否回复", description = "是否回复：0.否；1.是", name = "haveReply")
    private int haveReply;
    @Schema(title = "游戏类型", description = "游戏类型", name = "gameType")
    private String gameType;
    @Schema(title = "游戏语言", description = "游戏语言", name = "gameLanguage")
    private String gameLanguage;
}
