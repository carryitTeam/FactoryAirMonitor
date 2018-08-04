package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.DeviceConfigService;
import com.carryit.base.fam.service.impl.GroupInfoService;
import com.carryit.base.fam.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Menu {

    @Autowired
    private GroupInfoService groupInfoService;

    @Autowired
    private DeviceConfigService deviceConfigService;

    @RequestMapping("/menu")
    public ModelAndView checkUser(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        String groupId = request.getParameter("groupId");
        User cuser = (User) request.getSession().getAttribute("cuser");
        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setGroupId(Integer.parseInt(groupId));
        List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByGroupId(deviceConfig);

        List<DeviceConfig> sensorConfigList = new ArrayList<>();
        for (DeviceConfig d: deviceConfigList){
            d.setParentId(d.getId());
            sensorConfigList.addAll(deviceConfigService.queryDeviceConfigByParentId(d));
        }

        modelAndView.addObject("deviceConfigList", deviceConfigList);
        modelAndView.addObject("sensorConfigList", sensorConfigList);
        modelAndView.addObject("groupId", groupId);
        modelAndView.setViewName("new/menu");

        return modelAndView;
    }

}
