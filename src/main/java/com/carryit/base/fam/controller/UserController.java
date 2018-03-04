package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.User;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
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
        ModelAndView model = new ModelAndView();
        User user = new User();
        String userId = request.getParameter("userId");
        String pwd = request.getParameter("userPassword");
        user.setUserId(userId);
        user.setUserPwd(pwd);
//        User user = new User();
//        user.setUserId(request.getParameter("userId"));
//        user.setUserPwd(request.getParameter("userPwd"));
//        User cuser = userService.checkUserByPwd(user);
//        model.setViewName("forward:asdfasdf.jsp");
//        if (cuser == null || cuser.getUserId() == null) {
//            model.setViewName("redirect:index.jsp");
//        } else {
        model.setViewName("commonUser");
//        }
        return model;
    }


}
