package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.hpb.Change;
import com.carryit.base.fam.service.IAlertRuleService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AlertRuleServiceTest implements IAlertRuleService {
    @Override
    public int checkData(Datas datas, DeviceConfig deviceConfig) {
        int alertLevel = -1;
        String allContent = datas.getRealData();
        Map<String, String> parseData = Change.strDatas(allContent);
        String res = parseData.get(deviceConfig.getAlertField());
        if (res != null && Double.parseDouble(res) > deviceConfig.getAlertNumber()) {
            alertLevel = Integer.parseInt(deviceConfig.getDeviceLevel());
        }
        System.out.println(alertLevel);
        return alertLevel;
    }
}
