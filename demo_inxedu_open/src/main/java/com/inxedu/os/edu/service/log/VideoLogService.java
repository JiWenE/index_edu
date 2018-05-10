package com.inxedu.os.edu.service.log;

import com.inxedu.os.edu.entity.log.VideoLog;
import com.inxedu.os.edu.entity.log.VideoLogDto;

import java.util.List;

public interface VideoLogService {
    /**
     * 增加日志数据
     * @param logArray
     */
    public void addLog(List<VideoLogDto> logArray);

    /**
     * 标记删除
     * @param id
     */
    public void setDeleted(Long id);

}
