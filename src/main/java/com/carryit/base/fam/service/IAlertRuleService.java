package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.DeviceConfig;

public interface IAlertRuleService {

    int checkData(Datas datas, DeviceConfig deviceConfig);
}
