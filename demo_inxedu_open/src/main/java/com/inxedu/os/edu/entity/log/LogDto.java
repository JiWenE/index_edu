package com.inxedu.os.edu.entity.log;

import java.util.List;

public class LogDto {
    private List<VideoLogDto> logArray;

    public List<VideoLogDto> getLogArray() {
        return logArray;
    }

    public void setLogArray(List<VideoLogDto> logArray) {
        this.logArray = logArray;
    }

    @Override
    public String toString() {
        return "LogDto{" +
                "logArray=" + logArray +
                '}';
    }
}
