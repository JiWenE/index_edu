package com.inxedu.os.edu.service.log;

import com.inxedu.os.edu.dao.course.CourseKpointDao;
import com.inxedu.os.edu.dao.log.VideoLogDao;
import com.inxedu.os.edu.entity.log.VideoLog;
import com.inxedu.os.edu.entity.log.VideoLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VideoLogServiceImpl implements VideoLogService{

    @Autowired
    private VideoLogDao videoLogDao;

    @Autowired
    private CourseKpointDao courseKpointDao;


    @Override
    public void addLog(List<VideoLogDto> logArray) {
        String url = splitUrl(logArray.get(0).getFileLocation());
        int videoId = courseKpointDao.getVideoIdByUrl(url);
        VideoLog videoLog = new VideoLog();
        for (VideoLogDto videoLogDto: logArray) {
            videoLog.setUserId(videoLogDto.getUserId());
            videoLog.setVideoId(videoId);
            videoLog.setPlayTime(videoLogDto.getVideoTime());
            videoLog.setTotalTime(videoLogDto.getTotalTime());
            videoLog.setCreationTime(videoLogDto.getCreationTime());
            if(videoLogDto.getEventName().equals(VideoLog.STATUS_PLAY_EVENT)){
                videoLog.setStatus(VideoLog.STATUS_PLAY);
            }else{
                videoLog.setStatus(VideoLog.STATUS_PAUSE);
            }
            videoLogDao.addLog(videoLog);
            courseKpointDao.addEventCountById(videoId);
        }
    }

    @Override
    public void setDeleted(Long id) {
        videoLogDao.deletedById(id);
    }

    private String splitUrl(String url) {
        String [] sourceArray = url.split("/");
        int length = sourceArray.length;
        String aimUrl = "/"+ sourceArray[length-5] + "/"+ sourceArray[length-4]+ "/"+ sourceArray[length-3]+ "/"+ sourceArray[length-2]+ "/"+ sourceArray[length-1];
        return aimUrl;
    }
}
