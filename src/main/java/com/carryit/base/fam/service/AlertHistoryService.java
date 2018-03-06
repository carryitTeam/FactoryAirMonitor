package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.dao.AlertHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
@Service
public class AlertHistoryService implements IAlertHistoryService {

    @Autowired
    private AlertHistoryDao alertHistoryDao;

    @Override
    public int addAlertHistory(AlertHistory alertHistory) {
        return alertHistoryDao.addAlertHistory(alertHistory);
    }

    @Override
    public int deleteAlertHistory(AlertHistory alertHistory) {
        return alertHistoryDao.deleteAlertHistory(alertHistory);
    }

    @Override
    public int updateAlertHistory(AlertHistory alertHistory) {
        return alertHistoryDao.updateAlertHistory(alertHistory);
    }

    @Override
    public AlertHistory queryAlertHistoryByHistoryId(AlertHistory alertHistory) {
        return alertHistoryDao.queryAlertHistoryByHistoryId(alertHistory);
    }

    @Override
    public List<AlertHistory> queryAlertHistoryByAppEui(AlertHistory alertHistory) {
        return alertHistoryDao.queryAlertHistoryByAppEui(alertHistory);
    }
}
