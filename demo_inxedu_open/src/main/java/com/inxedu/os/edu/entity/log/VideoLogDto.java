package com.inxedu.os.edu.entity.log;

import java.util.Date;

public class VideoLogDto {
    private Integer userId;
    private String fileLocation;
    private String eventName;
    private Double videoTime;
    private Double totalTime;
    private Date creationTime;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Double getVideoTime() {
        return videoTime;
    }

    public void setVideoTime(Double videoTime) {
        this.videoTime = videoTime;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "VideoLogDto{" +
                "userId=" + userId +
                ", fileLocation='" + fileLocation + '\'' +
                ", eventName='" + eventName + '\'' +
                ", videoTime=" + videoTime +
                ", totalTime=" + totalTime +
                ", creationTime=" + creationTime +
                '}';
    }
}
