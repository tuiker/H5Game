package com.hou_tai.model.pojo;

import java.util.Date;

public class Game {
    private Integer id;

    private String gameName;

    private Integer gameType;

    private Integer languageId;

    private String gameLogo;

    private String gameMainLogo;

    private String gameBackground;

    private String gameUrl;

    private String gameDesc;

    private String dataSecurity;

    private Integer gameGrade;

    private Integer gameDownload;

    private Integer gameAge;

    private String devEmail;

    private String devUrl;

    private Long createId;

    private Date createTime;

    private Long updateId;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName == null ? null : gameName.trim();
    }

    public Integer getGameType() {
        return gameType;
    }

    public void setGameType(Integer gameType) {
        this.gameType = gameType;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public String getGameLogo() {
        return gameLogo;
    }

    public void setGameLogo(String gameLogo) {
        this.gameLogo = gameLogo == null ? null : gameLogo.trim();
    }

    public String getGameMainLogo() {
        return gameMainLogo;
    }

    public void setGameMainLogo(String gameMainLogo) {
        this.gameMainLogo = gameMainLogo == null ? null : gameMainLogo.trim();
    }

    public String getGameBackground() {
        return gameBackground;
    }

    public void setGameBackground(String gameBackground) {
        this.gameBackground = gameBackground == null ? null : gameBackground.trim();
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl == null ? null : gameUrl.trim();
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc == null ? null : gameDesc.trim();
    }

    public String getDataSecurity() {
        return dataSecurity;
    }

    public void setDataSecurity(String dataSecurity) {
        this.dataSecurity = dataSecurity == null ? null : dataSecurity.trim();
    }

    public Integer getGameGrade() {
        return gameGrade;
    }

    public void setGameGrade(Integer gameGrade) {
        this.gameGrade = gameGrade;
    }

    public Integer getGameDownload() {
        return gameDownload;
    }

    public void setGameDownload(Integer gameDownload) {
        this.gameDownload = gameDownload;
    }

    public Integer getGameAge() {
        return gameAge;
    }

    public void setGameAge(Integer gameAge) {
        this.gameAge = gameAge;
    }

    public String getDevEmail() {
        return devEmail;
    }

    public void setDevEmail(String devEmail) {
        this.devEmail = devEmail == null ? null : devEmail.trim();
    }

    public String getDevUrl() {
        return devUrl;
    }

    public void setDevUrl(String devUrl) {
        this.devUrl = devUrl == null ? null : devUrl.trim();
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}