package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.DeviceConfigService;
import com.carryit.base.fam.service.impl.GroupInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class DeviceConfigController {

    @Autowired
    private DeviceConfigService deviceConfigService;

    @Autowired
    private GroupInfoService groupInfoService;

    @RequestMapping("/deviceManager")
    public ModelAndView deviceManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
        Map<Integer, GroupInfo> mapData = toMapData(groupInfos);
        modelAndView.addObject("groupMapData", mapData);
        modelAndView.addObject("cuser", cuser);
        List<DeviceConfig> deviceConfigList = null;
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            DeviceConfig deviceConfig = new DeviceConfig();
            deviceConfig.setDeviceType("device");
            deviceConfigList = deviceConfigService.queryDeviceConfigByType(deviceConfig);
        } else {
            DeviceConfig deviceConfig = new DeviceConfig();
            deviceConfig.setGroupId(cuser.getGroupId());
            deviceConfigList = deviceConfigService.queryDeviceConfigByGroupId(deviceConfig);
        }
        modelAndView.addObject("deviceConfigList", deviceConfigList);
        modelAndView.setViewName("new/deviceManager");
        return modelAndView;
    }

    @RequestMapping("/deviceUpdateAndInsert")
    public @ResponseBody
    Object deviceUpdateAndInsert(HttpServletRequest request, @ModelAttribute DeviceConfig deviceConfig) {

        int res = -1;
        if (deviceConfig.getId() == null) {
            deviceConfig.setDeviceType("device");
            res = deviceConfigService.addDeviceConfig(deviceConfig);
        } else {
//            deviceConfig.se(simpleDateFormat.format(new Date()));
            res = deviceConfigService.updateDeviceConfigById(deviceConfig);
        }
        return res;
    }

    private Map<Integer, GroupInfo> toMapData(List<GroupInfo> groupInfos) {
        Map<Integer, GroupInfo> groupInfoMap = new HashMap<>(100);
        for (GroupInfo groupInfo : groupInfos) {
            groupInfoMap.put(groupInfo.getId(), groupInfo);
        }
        return groupInfoMap;
    }

    @RequestMapping("/sensorManager")
    public ModelAndView sensorManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        List<DeviceConfig> sensorConfigList = new ArrayList<>();
        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setDeviceType("device");
        List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByType(deviceConfig);
        Map<Integer, DeviceConfig> mapDataDev = toMapDataDev(deviceConfigList);
        List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
        Map<Integer, GroupInfo> mapData = toMapData(groupInfos);
        modelAndView.addObject("groupMapData", mapData);
        modelAndView.addObject("deviceDataMap", mapDataDev);
        deviceConfig.setGroupId(cuser.getGroupId());

        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            DeviceConfig deviceConfig1 = new DeviceConfig();
            deviceConfig1.setDeviceType("sensor");
            sensorConfigList = deviceConfigService.queryDeviceConfigByType(deviceConfig1);
        } else {
            List<DeviceConfig> tmp = deviceConfigService.queryDeviceConfigByGroupId(deviceConfig);
            if (tmp.size() > 0) {
                deviceConfig = tmp.get(0);
                deviceConfig.setParentId(deviceConfig.getId());
                sensorConfigList = deviceConfigService.queryDeviceConfigByParentId(deviceConfig);
            }
        }
        modelAndView.addObject("sensorConfigList", sensorConfigList);
        modelAndView.setViewName("new/sensorManager");
        return modelAndView;
    }

    private Map<Integer, DeviceConfig> toMapDataDev(List<DeviceConfig> deviceConfigList) {
        Map<Integer, DeviceConfig> deviceConfigHashMap = new HashMap<>(100);
        for (DeviceConfig deviceConfig : deviceConfigList) {
            deviceConfigHashMap.put(deviceConfig.getId(), deviceConfig);
        }
        return deviceConfigHashMap;
    }

    @RequestMapping("/sensorUpdateAndInsert")
    public @ResponseBody
    Object sensorUpdateAndInsert(HttpServletRequest request, @ModelAttribute DeviceConfig deviceConfig) {
        deviceConfig.setGroupId(-1);
        int res = -1;
        if (deviceConfig.getId() == null) {
            deviceConfig.setDeviceType("sensor");
            res = deviceConfigService.addSensorConfig(deviceConfig);
        } else {
//            deviceConfig.se(simpleDateFormat.format(new Date()));
            res = deviceConfigService.updateSensorConfigById(deviceConfig);
        }
        return res;
    }

    @RequestMapping("/updateXY")
    public @ResponseBody
    Object updateXY(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer leftX = Integer.parseInt(request.getParameter("leftX"));
        Integer topY = Integer.parseInt(request.getParameter("topY"));
        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setId(id);
        deviceConfig.setLeftX(leftX);
        deviceConfig.setTopY(topY);
        int res = deviceConfigService.updateDeviceXYById(deviceConfig);
        return res;
    }

    @RequestMapping("/devicesForGroup")
    public ModelAndView devicesForGroup(HttpServletRequest request) {
        Integer groupId = Integer.parseInt(request.getParameter("groupId"));
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            DeviceConfig deviceConfig = new DeviceConfig();
            deviceConfig.setGroupId(groupId);
            List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByGroupId(deviceConfig);
            modelAndView.addObject("deviceConfigList", deviceConfigList);
        }
        modelAndView.setViewName("new/detailData");
        return modelAndView;
    }

    @RequestMapping("/senorForDevice")
    public ModelAndView senorForDevice(HttpServletRequest request) {
        Integer parentId = Integer.parseInt(request.getParameter("parentId"));
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            DeviceConfig deviceConfig = new DeviceConfig();
            deviceConfig.setParentId(parentId);
            List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByParentId(deviceConfig);
            modelAndView.addObject("deviceConfigList", deviceConfigList);
        }
        modelAndView.setViewName("new/detailSenorData");
        return modelAndView;
    }

    @RequestMapping("/deleteDeviceConfig")
    public @ResponseBody
    Object deleteDeviceConfig(HttpServletRequest request, @ModelAttribute DeviceConfig deviceConfig) {
        return deviceConfigService.deleteDeviceConfigById(deviceConfig);
    }
}
