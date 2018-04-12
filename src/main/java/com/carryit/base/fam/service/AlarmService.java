package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.Alarm;
import com.carryit.base.fam.dao.AlarmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmService implements IAlarmService {
    @Autowired
    private AlarmDao alarmDao;


    @Override
    public int addAlarm(Alarm alarm) {
        return alarmDao.addAlarm(alarm);
    }

    @Override
    public int updateAlarm(Alarm alarm) {
        return alarmDao.updateAlarm(alarm);
    }

    @Override
    public int deleteAlarm(Alarm alarm) {
        return alarmDao.deleteAlarm(alarm);
    }

    @Override
    public List<Alarm> queryAll() {
        return alarmDao.queryAll();
    }

    @Override
    public List<Alarm> queryByDevEui(Alarm alarm) {
        return alarmDao.queryByDevEui(alarm);
    }
}
