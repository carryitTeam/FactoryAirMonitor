package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.AlertRules;
import com.carryit.base.fam.dao.AlertRulesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
@Service
public class AlertRulesService implements IAlertRulesService {

    @Autowired
    private AlertRulesDao alertRulesDao;

    @Override
    public int addAlertRules(AlertRules alertRules) {
        return alertRulesDao.addAlertRules(alertRules);
    }

    @Override
    public int deleteAlertRules(AlertRules alertRules) {
        return alertRulesDao.deleteAlertRules(alertRules);
    }

    @Override
    public int updateAlertRules(AlertRules alertRules) {
        return alertRulesDao.updateAlertRules(alertRules);
    }

    @Override
    public AlertRules queryAlertRulesByRuleId(AlertRules alertRules) {
        return alertRulesDao.queryAlertRulesByRuleId(alertRules);
    }

    @Override
    public List<AlertRules> queryAlertRulesByAppEui(AlertRules alertRules) {
        return alertRulesDao.queryAlertRulesByAppEui(alertRules);
    }
}
