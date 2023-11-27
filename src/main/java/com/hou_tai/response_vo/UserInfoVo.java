package com.hou_tai.response_vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: GaoLu
 * @Date: 2023-10-18 17:53
 * @Description: 用户信息返回类
 */
@Data
@Schema(title = "用户信息", description = "用户信息对象")
public class UserInfoVo {
    @Schema(title = "Id", description = "用户Id", name = "id")
    private long id;
    @Schema(title = "昵称", description = "用户昵称", name = "userName")
    private String userName;
    @Schema(title = "头像", description = "用户头像", name = "userImg")
    private String userImg;
    @Schema(title = "性别", description = "用户性别", name = "userSex")
    private String userSex;
    @Schema(title = "属性", description = "属性", name = "userStatsName")
    private String userStatsName;
    @Schema(title = "游戏时长", description = "总游戏时长", name = "gameTimeAll")
    private int gameTimeAll;//暂时未同步
    @Schema(title = "游戏名", description = "游戏名集合", name = "gameNameAll")
    private List<String> gameNameAll;
    @Schema(title = "登录时间", description = "最近登录时间", name = "recentLoginTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime recentLoginTime;
    @Schema(title = "注册时间", description = "用户注册时间", name = "signTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime signTime;
    @Schema(title = "手机账户", description = "手机账户", name = "phoneAccount")
    private String phoneAccount;
    @Schema(title = "邮箱账户", description = "邮箱账户", name = "emailAccount")
    private String emailAccount;
    @Schema(title = "账户", description = "邮箱/手机账户", name = "account")
    private String account;
    @Schema(title = "注册类型", description = "首次注册类型：手机/邮箱", name = "firstSignTypeName")
    private String firstSignTypeName;
    @Schema(title = "注册载体类型", description = "注册载体类型：对应载体类型", name = "carrierId")
    private String carrierId;

}
