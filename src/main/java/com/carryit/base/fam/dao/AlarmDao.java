package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.Alarm;


public interface AlarmDao {


    int addAlarm(Alarm alarm);

    int updateAlarm(Alarm alarm);

    int deleteAlarm(Alarm alarm);
}
