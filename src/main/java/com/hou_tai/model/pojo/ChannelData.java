package com.hou_tai.model.pojo;

import java.util.Date;

public class ChannelData {
    private Integer id;

    private Integer channelId;

    private Integer requestData;

    private Date recordTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChannelId() {
        return channelId;
    }

    public void setChannelId(Integer channelId) {
        this.channelId = channelId;
    }

    public Integer getRequestData() {
        return requestData;
    }

    public void setRequestData(Integer requestData) {
        this.requestData = requestData;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}