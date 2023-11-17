package com.hou_tai.response_vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hou_tai.model.pojo.Game;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName: MobileGameVo
 * @Description: 移动端游戏输出
 * @Author: Sam
 * @Date: 2023-11-04 11:52
 * @Version: 1.0
 **/
@Data
@EqualsAndHashCode(callSuper = false)
@Schema(title = "移动端游戏输出")
public class MobileGameVo extends Game {
    //获取游戏ID需要
    private Long id;

    @Schema(title = "游戏类型名称")
    private String typeName;
    /**
     * 游戏语言ID
     */
    @Schema(title = "游戏语言")
    private String languageName;

    @Schema(title = "游戏评论集合")
    List<MobileGameReviewVo> gameReviewList;

    @Schema(title = "游戏更新日期")
    @JsonFormat(pattern = "yyyy-MM-dd")  //前后端接收日期都可以改变格式
    @JSONField(format = "yyyy-MM-dd") //ResponseBody做了拦截，封装了一层导致原来JsonFormat无效，前端返回日期，要用JSONField来处理
    //@TableField(value = "update_time")
    private LocalDateTime updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    // @TableField(value = "create_time")
    private LocalDateTime createTime;
}
