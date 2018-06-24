package com.carryit.base.fam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogOutController {

    @RequestMapping("/logOut")
    public ModelAndView checkUser(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession userSession = request.getSession();
        userSession.removeAttribute("cuser");
        model.setViewName("redirect:/");
        return model;
    }
}
