package com.carryit.base.fam.controller;

import com.carryit.base.fam.service.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by hlzou on 2018/2/27.
 */

@Controller
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public @ResponseBody
    Object test(){
        return testService.countData();
    }

}
