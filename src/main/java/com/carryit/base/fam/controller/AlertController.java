package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.hpb.Change;
import com.carryit.base.fam.service.AlertHistoryService;
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
public class AlertController {

    @Autowired
    private AlertHistoryService alertHistoryService;

    @RequestMapping("/alertManager")
    public ModelAndView alertManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            List<AlertHistory> alertHistories = alertHistoryService.queryAllAlertHistory();
            Map<Integer,Map<String,String>> careDatas = toCareMapData(alertHistories);
            modelAndView.addObject("alertHistories", alertHistories);
            modelAndView.addObject("careDatas", careDatas);
        }
        modelAndView.setViewName("new/alertManager");
        return modelAndView;
    }

    private Map<Integer,Map<String,String>> toCareMapData(List<AlertHistory> alertHistories) {
        Map<Integer,Map<String,String>> careDatas = new HashMap<>(1000);
        ObjectMapper objectMapper = new ObjectMapper();
        for (AlertHistory alertHistory: alertHistories){
            String allContent = alertHistory.getJsonData();
            Map<String, Object> dataMap = null;
            try {
                dataMap = objectMapper.readValue(allContent, Map.class);
                String careData = Base64Utils.CharToHex(Base64Utils.base64Decode((String) dataMap.get("payload")));
                Map<String,String> parseData = Change.strDatas(careData);
//                Map<String,String> parseData = new HashMap<>();
                parseData.put("careData", careData);
                careDatas.put(alertHistory.getId(), parseData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return careDatas;
    }
}
