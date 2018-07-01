package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.DeviceConfigService;
import com.carryit.base.fam.service.impl.GroupInfoService;
import com.carryit.base.fam.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GroupInfoController {

    @Autowired
    private GroupInfoService groupInfoService;

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceConfigService deviceConfigService;

    @RequestMapping("/groupManager")
    public ModelAndView groupManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
            modelAndView.addObject("groupInfos", groupInfos);
        }
        modelAndView.setViewName("new/groupManager");
        return modelAndView;
    }

    @RequestMapping("/groupUpdateAndInsert")
    public @ResponseBody
    Object groupUpdateAndInsert(HttpServletRequest request, @ModelAttribute GroupInfo groupInfo) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int res = -1;
        if (groupInfo.getId() == null) {
            res = groupInfoService.addGroupInfo(groupInfo);
        } else {
            groupInfo.setChangeTime(simpleDateFormat.format(new Date()));
            res = groupInfoService.updateGroupInfo(groupInfo);
        }
        return res;
    }

    @RequestMapping("/deleteGroup")
    public @ResponseBody
    Object deleteGroup(HttpServletRequest request, @ModelAttribute GroupInfo groupInfo) {
        groupInfoService.deleteGroupInfo(groupInfo);
        User user = new User();
        user.setGroupId(groupInfo.getId());
        userService.deleteUserByGroupId(user);

        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setGroupId(groupInfo.getId());
        List<DeviceConfig> deviceConfigList = deviceConfigService.queryDeviceConfigByGroupId(deviceConfig);
        if (deviceConfigList.size()>0){
            DeviceConfig d1 = deviceConfigList.get(0);
            d1.setParentId(d1.getId());
            deviceConfigService.deleteDeviceConfigByParentId(d1);
            deviceConfigService.deleteDeviceConfigByGroupId(deviceConfig);
        }
        return 1;
    }

}
