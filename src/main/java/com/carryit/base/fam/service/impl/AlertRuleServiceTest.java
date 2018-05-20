package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.service.IAlertRuleService;
import org.springframework.stereotype.Service;

@Service
public class AlertRuleServiceTest implements IAlertRuleService {
    @Override
    public boolean checkData(Datas datas) {
        return false;
    }
}
