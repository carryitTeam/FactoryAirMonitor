package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.GroupInfo;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.GroupInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GroupInfoController {

    @Autowired
    private GroupInfoService groupInfoService;

    @RequestMapping("/groupManager")
    public ModelAndView groupManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            List<GroupInfo> groupInfos = groupInfoService.queryAllGroupInfo();
            modelAndView.addObject("groupInfos", groupInfos);
        }
        modelAndView.setViewName("new/groupManager");
        return modelAndView;
    }

    @RequestMapping("/groupUpdateAndInsert")
    public @ResponseBody
    Object groupUpdateAndInsert(HttpServletRequest request, @ModelAttribute GroupInfo groupInfo) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int res = -1;
        if (groupInfo.getId() == null) {
            res = groupInfoService.addGroupInfo(groupInfo);
        } else {
            groupInfo.setChangeTime(simpleDateFormat.format(new Date()));
            res = groupInfoService.updateGroupInfo(groupInfo);
        }
        return res;
    }

}
