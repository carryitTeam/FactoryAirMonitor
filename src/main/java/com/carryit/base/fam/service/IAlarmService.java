package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.Alarm;


public interface IAlarmService {


    int addAlarm(Alarm alarm);

    int updateAlarm(Alarm alarm);

    int deleteAlarm(Alarm alarm);
}
