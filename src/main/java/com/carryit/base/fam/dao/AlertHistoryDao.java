package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.AlertRules;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface AlertHistoryDao {

    int addAlertHistory(AlertHistory alertHistory);

    int deleteAlertHistory(AlertHistory alertHistory);

    int updateAlertHistory(AlertHistory alertHistory);

    AlertHistory queryAlertHistoryByHistoryId(AlertHistory alertHistory);

    List<AlertHistory> queryAlertHistoryByAppEui(AlertHistory alertHistory);

    List<AlertHistory> queryAllAlertHistory();

}
