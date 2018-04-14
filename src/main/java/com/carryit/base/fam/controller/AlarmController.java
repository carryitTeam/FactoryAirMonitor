package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.Alarm;
import com.carryit.base.fam.service.IAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class AlarmController {
    @Autowired
    private IAlarmService alarmService;


    //添加alarm
    @PostMapping("/addRelate")
    public
    @ResponseBody
    Object addRelate(Alarm alarm){
        int res=alarmService.addAlarm(alarm);
        return res;
    }


    //修改更新alarm
    @PostMapping("/updateRelate")
    public
    @ResponseBody
    Object updateRelate(Alarm alarm){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String changeTime = sdf.format(new Date());
        alarm.setChangeTime(changeTime);

        int res=alarmService.updateAlarm(alarm);
        return  res;
    }
    //删除alarm
    @PostMapping("/deleteAlarm")
    public
    @ResponseBody
    Object deleteAlarm(Alarm alarm){

        int res=alarmService.deleteAlarm(alarm);
        return  res;
    }


}