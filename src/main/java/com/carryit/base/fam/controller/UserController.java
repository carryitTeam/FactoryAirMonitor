package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.*;
import com.carryit.base.fam.service.*;
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
        if (userId ==null ){
            if(userSession.getAttribute("cuser") != null){
                cuser = (User) userSession.getAttribute("cuser");
            }else {
                model.setViewName("redirect:/");
            }
        }else {
            cuser = userService.checkUserByPwd(user);
        }
        // 验证db是否成功
        if (cuser == null || cuser.getUserId() == null) {
            model.addObject("userId", userId);
            model.setViewName("new/loginError");
        } else {
            userSession.setAttribute("cuser", cuser);
            model.addObject("cuser", cuser);
            if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())){
                List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
                model.addObject("groupInfos", groupInfos);
            }
            model.setViewName("new/main");
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
            Map<Integer,GroupInfo> mapData = toMapData(groupInfos);
            modelAndView.addObject("groupMapData", mapData);
            modelAndView.addObject("userList", userList);
        }
        modelAndView.setViewName("new/userManager");
        return modelAndView;
    }

    private Map<Integer,GroupInfo> toMapData(List<GroupInfo> groupInfos) {
        Map<Integer,GroupInfo> groupInfoMap = new HashMap<>(100);
        for (GroupInfo groupInfo: groupInfos){
            groupInfoMap.put(groupInfo.getId(), groupInfo);
        }
        return groupInfoMap;
    }

    @RequestMapping("/userUpdateAndInsert")
    public @ResponseBody
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
        if (datasList.size() > 10) {
            datasList = datasList.subList(0, 10);
        }
        model.addObject("user", cuser);
        Set<String> devEuis = getDevEui(datasList);
        if ("show".equalsIgnoreCase(select)) {
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
            List<Alarm> alarmList = new ArrayList<>();
            for (String de : devEuis) {
                Alarm alarm = new Alarm();
                alarm.setDevEui(de);
                List<Alarm> tmpAlarms = alarmService.queryByDevEui(alarm);
                if (!tmpAlarms.isEmpty()) {
                    alarmList.addAll(tmpAlarms);
                }
            }
            model.addObject("devEuiAlarms", alarmList);
            FaultRecords faultRecords = new FaultRecords();
            faultRecords.setAppEui(cuser.getAppEui());
            List<FaultRecords> frs = faultRecordsService.queryFaultRecordsByAppEui(faultRecords);
            model.addObject("frs", frs);
            model.setViewName("deviceData");
        }
        return model;
    }

    public Set<String> getDevEui(List<Datas> datas) {
        Set<String> devEuis = new HashSet<>();
        for (Datas d : datas) {
            devEuis.add(d.getDevEui());
        }

        return devEuis;
    }

}
