package com.inxedu.os.edu.controller.log;

import com.inxedu.os.edu.entity.log.LogDto;
import com.inxedu.os.edu.entity.log.VideoLog;
import com.inxedu.os.edu.entity.log.VideoLogDto;
import com.inxedu.os.edu.service.log.VideoLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/video")
public class LogController {

    @Autowired
    private VideoLogService videoLogService;

    @RequestMapping(value = "/log/add", method = RequestMethod.POST, consumes = "application/json")
    public void addLog(@RequestBody LogDto logDto){
        //todo = 增加log
        videoLogService.addLog(logDto.getLogArray());
    }

    @RequestMapping(value = "/log/deleted/{id}", method = RequestMethod.DELETE)
    public void deletedLog(@PathVariable Long id){
        videoLogService.setDeleted(id);
    }


}
