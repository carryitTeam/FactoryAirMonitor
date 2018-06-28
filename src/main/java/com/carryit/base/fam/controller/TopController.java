package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.DeviceConfigService;
import com.carryit.base.fam.service.impl.GroupInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TopController {

    @Autowired
    private DeviceConfigService deviceConfigService;

    @Autowired
    private GroupInfoService groupInfoService;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/topManager")
    public ModelAndView topManager(HttpServletRequest request) {
        HashMap<String, Boolean> startedApp = (HashMap<String, Boolean>) servletContext.getAttribute("startedApp");
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
        Map<Integer, GroupInfo> mapData = toMapData(groupInfos);
        modelAndView.addObject("groupMapData", mapData);
        modelAndView.addObject("startedApp", startedApp);
//        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
//            DeviceConfig deviceConfig = new DeviceConfig();
//            deviceConfig.setDeviceType("device");
//            List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByType(deviceConfig);
//            modelAndView.addObject("deviceConfigList", deviceConfigList);
//        }else {
        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setGroupId(Integer.parseInt(request.getParameter("groupId")));
        List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByGroupId(deviceConfig);
        modelAndView.addObject("deviceConfigList", deviceConfigList);
//        }
        modelAndView.setViewName("new/topManager");
        return modelAndView;
    }

    private Map<Integer, GroupInfo> toMapData(List<GroupInfo> groupInfos) {
        Map<Integer, GroupInfo> groupInfoMap = new HashMap<>(100);
        for (GroupInfo groupInfo : groupInfos) {
            groupInfoMap.put(groupInfo.getId(), groupInfo);
        }
        return groupInfoMap;
    }
}
