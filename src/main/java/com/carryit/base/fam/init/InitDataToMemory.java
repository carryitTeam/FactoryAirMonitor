package com.carryit.base.fam.init;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.DeviceConfigService;
import com.carryit.base.fam.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hlzou on 2018/2/28.
 */

@Component
public class InitDataToMemory {

    @Autowired
    private DeviceConfigService deviceConfigService;

    @Autowired
    private ServletContext servletContext;

    public void initUserToMemory() {
        List<DeviceConfig> deviceConfigList = deviceConfigService.queryAllDeviceConfig();

        Map<String, Boolean> startedApp = new HashMap<>();
        for (DeviceConfig deviceConfig : deviceConfigList) {
            startedApp.put(deviceConfig.getAppEui(), false);
        }
        servletContext.setAttribute("startedApp", startedApp);
    }
}
