package com.inxedu.os.edu.dao.log;

import com.inxedu.os.common.dao.GenericDaoImpl;
import com.inxedu.os.edu.entity.log.VideoLog;
import org.springframework.stereotype.Repository;

@Repository("videoLogDao")
public class VideoLogDaoImpl extends GenericDaoImpl implements VideoLogDao {

    public void addLog(VideoLog videoLog) {
        this.insert("VideoLogDaoMapper.addLog", videoLog);
    }

    @Override
    public void deletedById(Long id) {
        this.update("VideoLogDaoMapper.deletedById", id);
    }
}
