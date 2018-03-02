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
import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */

@Controller
public class UserController {

    @Resource
    private UserService userService;


    @Autowired
    private ServletContext servletContext;

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
