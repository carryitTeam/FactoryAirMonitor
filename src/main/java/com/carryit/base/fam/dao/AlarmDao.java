package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.Alarm;

import java.util.List;


public interface AlarmDao {


    int addAlarm(Alarm alarm);

    int updateAlarm(Alarm alarm);

    int deleteAlarm(Alarm alarm);

    List<Alarm> queryAll();

    List<Alarm> queryByDevEui(Alarm alarm);
}