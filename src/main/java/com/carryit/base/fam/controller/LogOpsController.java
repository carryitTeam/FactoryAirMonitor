package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.LogOps;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.LogOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
        List<LogOps> logOpsList = null;
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            logOpsList = logOpsService.queryAllLogOps();
        }else {
            LogOps logOps = new LogOps();
            logOps.setUserId(cuser.getUserId());
            logOpsList = logOpsService.queryLogOpsByUid(logOps);
        }
        modelAndView.addObject("logOpsList", logOpsList);
        modelAndView.setViewName("new/logManager");
        return modelAndView;
    }

}
