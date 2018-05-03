package com.inxedu.os.edu.service.log;

import com.inxedu.os.edu.entity.log.VideoLog;
import com.inxedu.os.edu.entity.log.VideoLogDto;

import java.util.List;

public interface VideoLogService {
    public void addLog(List<VideoLogDto> logArray);
    public void setDeleted(Long id);

}
