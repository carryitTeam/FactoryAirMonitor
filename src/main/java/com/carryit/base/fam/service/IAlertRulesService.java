package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.AlertRules;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface IAlertRulesService {

    int addAlertRules(AlertRules alertRules);

    int deleteAlertRules(AlertRules alertRules);

    int updateAlertRules(AlertRules alertRules);

    AlertRules queryAlertRulesByRuleId(AlertRules alertRules);

    List<AlertRules> queryAlertRulesByAppEui(AlertRules alertRules);
}
