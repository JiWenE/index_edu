package com.inxedu.os.edu.entity.log;

import java.util.Date;

public class VideoLog {
    public final static String STATUS_PLAY_EVENT = "播放"; //播放
    public final static String STATUS_PAUSE_EVENT = "暂停"; // 暂停
    public final static int STATUS_PLAY = 1; //播放
    public final static int STATUS_PAUSE = 2; // 暂停

    private Integer id;
    private Integer userId;
    private Integer videoId;
    private Integer status; //事件类型：1 播放 2 暂停
    private Double playTime;
    private Double totalTime;
    private Date creationTime;
    private Date updateTime;

    public Double getPlayTime() {
        return playTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }
    public Integer getUserId() {
        return userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Double getEventTime() {
        return playTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setPlayTime(Double playTime) {
        this.playTime = playTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "VideoLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoId=" + videoId +
                ", status=" + status +
                ", playTime=" + playTime +
                ", totalTime=" + totalTime +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
