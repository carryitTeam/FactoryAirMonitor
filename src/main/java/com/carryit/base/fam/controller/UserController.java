package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.AlertRules;
import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.AlertHistoryService;
import com.carryit.base.fam.service.AlertRulesService;
import com.carryit.base.fam.service.DatasService;
import com.carryit.base.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

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

    @PostMapping("/checkUser")
    public
    @ResponseBody
    Object checkUser(HttpServletRequest request) {

        User user = new User();
        user.setUserId(request.getParameter("userId"));
        user.setUserPwd(request.getParameter("userPwd"));
        User cuser = userService.checkUserByPwd(user);
        if (cuser == null || cuser.getUserId() == null) {
            return 0;
        } else {
            return cuser;
        }
    }

    @PostMapping("/adminUser")
    public ModelAndView adminUser(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        User user = new User();
        user.setUserRole("user");
        String userId = request.getParameter("userId");
        String pwd = request.getParameter("userPassword");
        user.setUserId(userId);
        user.setUserPwd(pwd);
        User cuser = userService.checkUserByPwd(user);
        List<User> users = userService.queryAllUsersByRole(user);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            user.setUserRole("admin");
            List<User> adminUsers = userService.queryAllUsersByRole(user);
            users.addAll(adminUsers);
        }
        model.addObject("userId", userId);
        model.addObject("users", users);
        model.addObject("userData", servletContext.getAttribute("userData"));
        model.setViewName("adminUser");
        return model;
    }

    @PostMapping("/commonUser")
    public ModelAndView commonUser(HttpServletRequest request) {
        Map<String, Boolean> userData = (Map<String, Boolean>) servletContext.getAttribute("userData");
        ModelAndView model = new ModelAndView();

        User user = new User();
        String userId = request.getParameter("userId");
        String pwd = request.getParameter("userPassword");
        user.setUserId(userId);
        user.setUserPwd(pwd);
        User cuser = userService.checkUserByPwd(user);
        String select = request.getParameter("select");

        List<Datas> datasList = datasService.queryUsersByUserId(user);
        if (datasList.size()>10){
            datasList = datasList.subList(0,10);
        }
        model.addObject("user", cuser);
        if ("show".equalsIgnoreCase(select)) {
            Set<String> devEuis = getDevEui(datasList);
            model.addObject("isStarted", userData.get(cuser.getUserId() + "_" + cuser.getAppEui()));
            model.addObject("datasList", datasList);
            model.addObject("devEuis", devEuis);
            model.setViewName("showData");
        } else if ("alert".equalsIgnoreCase(select)) {
            AlertRules alertRules = new AlertRules();
            alertRules.setAppEui(cuser.getAppEui());
            List<AlertRules> ars = alertRulesService.queryAlertRulesByAppEui(alertRules);
            model.addObject("alertRules", ars);

            AlertHistory alertHistory = new AlertHistory();
            alertHistory.setAppEui(cuser.getAppEui());
            List<AlertHistory> ahs = alertHistoryService.queryAlertHistoryByAppEui(alertHistory);
            model.addObject("alertHistories", ahs);

            model.setViewName("alertData");
        } else if ("device".equalsIgnoreCase(select)) {
            model.setViewName("deviceData");
        }
        return model;
    }

    public Set<String> getDevEui(List<Datas> datas){
        Set<String> devEuis = new HashSet<>();
        for (Datas d : datas){
            devEuis.add(d.getDevEui());
        }

        return devEuis;
    }

}
