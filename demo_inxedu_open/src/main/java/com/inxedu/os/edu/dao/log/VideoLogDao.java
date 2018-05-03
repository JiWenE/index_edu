package com.inxedu.os.edu.dao.log;

import com.inxedu.os.edu.entity.log.VideoLog;
import org.springframework.stereotype.Repository;

//@Repository
public interface VideoLogDao {
    public void addLog(VideoLog videoLog);
    public void deletedById(Long id);
}
