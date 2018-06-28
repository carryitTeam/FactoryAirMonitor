package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.*;
import com.carryit.base.fam.service.impl.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by hlzou on 2018/2/27.
 */

@Controller
public class UserController {

    @Resource
    private UserService userService;


    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DatasService datasService;

    @Autowired
    private AlertRulesService alertRulesService;

    @Autowired
    private AlertHistoryService alertHistoryService;

    @Autowired
    private FaultRecordsService faultRecordsService;

    @Autowired
    private AlarmService alarmService;

    @Autowired
    private GroupInfoService groupInfoService;


    @PostMapping("/submitAddUser")
    public
    @ResponseBody
    Object submitAddUser(User user) {

        Map<String, Boolean> userData = (Map<String, Boolean>) servletContext.getAttribute("userData");

        userData.put(user.getUserId() + "_" + user.getAppEui(), false);

        int res = userService.addUser(user);
        return res;
    }

    @PostMapping("/submitUpdateUser")
    public
    @ResponseBody
    Object submitUpdateUser(User user) {
        Map<String, Boolean> userData = (Map<String, Boolean>) servletContext.getAttribute("userData");

        userData.put(user.getUserId() + "_" + user.getAppEui(), false);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String changeTime = sdf.format(new Date());
        user.setChangeTime(changeTime);

        int res = userService.updateUser(user);
        return res;
    }

    @RequestMapping("/checkUser")
    public ModelAndView checkUser(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession userSession = request.getSession();
        User user = new User();
        String userId = request.getParameter("userId");
        user.setUserId(userId);
        user.setUserPwd(request.getParameter("userPwd"));
        User cuser = null;

        // 验证session
        if (userId == null) {
            if (userSession.getAttribute("cuser") != null) {
                cuser = (User) userSession.getAttribute("cuser");
            } else {
                model.setViewName("redirect:/");
            }
        } else {
            cuser = userService.checkUserByPwd(user);
        }
        // 验证db是否成功
        List<GroupInfo> groupInfos = new ArrayList<>();
        if (cuser == null || cuser.getUserId() == null) {
            model.addObject("userId", userId);
            model.setViewName("new/loginError");
        } else {
            userSession.setAttribute("cuser", cuser);
            model.addObject("cuser", cuser);
            if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
                groupInfos = groupInfoService.queryAllGroupInfo();
                model.addObject("groupInfos", groupInfos);
                model.setViewName("new/main");
            } else {
                GroupInfo groupInfo = new GroupInfo();
                groupInfo.setId(cuser.getGroupId());
                groupInfos.add(groupInfoService.queryGroupInfoById(groupInfo));
                model.addObject("groupInfos", groupInfos);
                model.setViewName("new/main");
            }
        }

        return model;
    }

    @RequestMapping("/userManager")
    public ModelAndView userManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            User user = new User();
            user.setUserRole("user");
            List<User> userList = userService.queryAllUsersByRole(user);
            user.setUserRole("admin");
            userList.addAll(userService.queryAllUsersByRole(user));
            List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
            Map<Integer, GroupInfo> mapData = toMapData(groupInfos);
            modelAndView.addObject("groupMapData", mapData);
            modelAndView.addObject("userList", userList);
        } else if ("admin".equalsIgnoreCase(cuser.getUserRole())) {
            List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
            Map<Integer, GroupInfo> mapData = toMapData(groupInfos);
            modelAndView.addObject("groupMapData", mapData);
            User user = new User();
            user.setGroupId(cuser.getGroupId());
            List<User> userList = userService.queryAllUsersByGroupId(user);
            modelAndView.addObject("userList", userList);
        }
        modelAndView.setViewName("new/userManager");
        return modelAndView;
    }

    private Map<Integer, GroupInfo> toMapData(List<GroupInfo> groupInfos) {
        Map<Integer, GroupInfo> groupInfoMap = new HashMap<>(100);
        for (GroupInfo groupInfo : groupInfos) {
            groupInfoMap.put(groupInfo.getId(), groupInfo);
        }
        return groupInfoMap;
    }

    @RequestMapping("/userUpdateAndInsert")
    public
    @ResponseBody
    Object userUpdateAndInsert(HttpServletRequest request, @ModelAttribute User user) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int res = -1;
        if (user.getId() == null) {
            res = userService.addUser(user);
        } else {
            user.setChangeTime(simpleDateFormat.format(new Date()));
            res = userService.updateUser(user);
        }
        return res;
    }

}
