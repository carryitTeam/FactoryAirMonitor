package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.LogOps;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.hpb.Change;
import com.carryit.base.fam.service.AlertHistoryService;
import com.carryit.base.fam.service.LogOpsService;
import com.carryit.base.fam.utils.Base64Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LogOpsController {

    @Autowired
    private LogOpsService logOpsService;

    @RequestMapping("/logManager")
    public ModelAndView alertManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            List<LogOps> logOpsList = logOpsService.queryAllLogOps();
            modelAndView.addObject("logOpsList", logOpsList);
        }
        modelAndView.setViewName("new/logManager");
        return modelAndView;
    }

}
