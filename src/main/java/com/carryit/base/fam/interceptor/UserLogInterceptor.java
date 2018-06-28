package com.carryit.base.fam.interceptor;

import com.carryit.base.fam.bean.LogOps;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.LogOpsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogInterceptor implements HandlerInterceptor {

    @Autowired
    private LogOpsService logOpsService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Object cuser = httpServletRequest.getSession().getAttribute("cuser");
        if (cuser == null) {
            return false;
        }

        String clientIp = httpServletRequest.getRemoteAddr();
        User user = (User) cuser;
        //获取请求的url
        String url = httpServletRequest.getRequestURI();
        if (url.contains("login")) {
            LogOps logOps = new LogOps();
            logOps.setUserId(user.getUserId());
            logOps.setLogContent("clientIp：" + clientIp + "，url：" + url);
            logOpsService.addLogOps(logOps);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
