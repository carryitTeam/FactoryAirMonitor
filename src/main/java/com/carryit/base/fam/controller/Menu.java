package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.GroupInfoService;
import com.carryit.base.fam.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class Menu {

    @Autowired
    private GroupInfoService groupInfoService;

    @RequestMapping("/menu")
    public ModelAndView checkUser(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        String groupId = request.getParameter("groupId");
        User cuser = (User) request.getSession().getAttribute("cuser");

//        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
        modelAndView.setViewName("new/menu");
//        }
        modelAndView.addObject("groupId", groupId);
        return modelAndView;
    }

}
