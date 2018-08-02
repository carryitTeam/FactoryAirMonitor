package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.claa.LoraDataRetrieve;
import com.carryit.base.fam.connection.CSData2Dev;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.hpb.Change;
import com.carryit.base.fam.service.impl.AlertHistoryService;
import com.carryit.base.fam.service.impl.DeviceConfigService;
import com.carryit.base.fam.service.impl.PushDataToCsService;
import com.carryit.base.fam.utils.Base64Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AlertController {

    @Autowired
    private AlertHistoryService alertHistoryService;

    @Autowired
    private DeviceConfigService deviceConfigService;

    @Autowired
    private PushDataToCsService pushDataToCsService;

    @Autowired
    private ServletContext servletContext;


    @RequestMapping("/alertManager")
    public ModelAndView alertManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        List<AlertHistory> alertHistories = null;
//        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
//            alertHistories = alertHistoryService.queryAllAlertHistory();
//
//        } else {
        AlertHistory alertHistory = new AlertHistory();
        alertHistory.setUserId(String.valueOf(cuser.getGroupId()));
        alertHistories = alertHistoryService.queryAlertHistoryByAppEui(alertHistory);
//        }
        Map<Integer, Map<String, String>> careDatas = toCareMapData(alertHistories);
        modelAndView.addObject("alertHistories", alertHistories);
        modelAndView.addObject("careDatas", careDatas);
        modelAndView.setViewName("new/alertManager");
        return modelAndView;
    }

    @RequestMapping("/alertHistoryManager")
    public ModelAndView alertHistoryManager(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        List<AlertHistory> alertHistories = null;
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            alertHistories = alertHistoryService.queryAllAlertHistory();
        } else {
            AlertHistory alertHistory = new AlertHistory();
            alertHistory.setUserId(String.valueOf(cuser.getGroupId()));
            alertHistories = alertHistoryService.queryAlertProcessHistoryByAppEui(alertHistory);
        }
        Map<Integer, Map<String, String>> careDatas = toCareMapData(alertHistories);
        modelAndView.addObject("alertHistories", alertHistories);
        modelAndView.addObject("careDatas", careDatas);
        modelAndView.setViewName("new/alertManager");
        return modelAndView;
    }

    @RequestMapping("/dealAlert")
    public @ResponseBody
    Object dealAlert(HttpServletRequest request) throws Exception {
        String appEui = request.getParameter("appEui");
        String alertId = request.getParameter("alertId");
        int res = 0;
        Map<String, LoraDataRetrieve> dataRetrieveMap = (Map<String, LoraDataRetrieve>) servletContext.getAttribute("dataRetrieveMap");
        DeviceConfig deviceConfig = new DeviceConfig();
        deviceConfig.setDeviceType("sensor");
        List<DeviceConfig> sensorConfigList = deviceConfigService.queryDeviceConfigByType(deviceConfig);

        //还原联动设备（绿灯）
        for (DeviceConfig sensor : sensorConfigList) {
            if (appEui.equalsIgnoreCase(sensor.getAppEui())) {
                if (dataRetrieveMap != null &&
                        dataRetrieveMap.get(appEui) != null &&
                        dataRetrieveMap.get(appEui).isRunFlag()) {
                    Connection connection = dataRetrieveMap.get(appEui).getConnection();
                    CSData2Dev data2Dev = new CSData2Dev();
                    data2Dev.setCMD("SENDTO");
                    data2Dev.setCmdSeq(5);
                    data2Dev.setAppEUI(appEui);
                    data2Dev.setDevEUI(sensor.getDevEui());
                    String pl = sensor.getPayload();
                    String[] pp = pl.split(",");
                    if (pp.length == 1) {
                        data2Dev.setPayload(pp[0]);
                    } else if (pp.length == 2) {
                        data2Dev.setPayload(pp[1]);
                    }
                    data2Dev.setPort(Integer.parseInt(sensor.getDevicePort()));
                    pushDataToCsService.putDataForSENDTO(connection, data2Dev);
                    AlertHistory alertHistory = new AlertHistory();
                    alertHistory.setIsProcess("0");
                    alertHistory.setHistoryId(alertId);
                    alertHistoryService.updateAlertHistory(alertHistory);
                    res++;
                    Thread.sleep(1000);
                } else {
                    return -1;
                }
            }
        }
        return res;
    }

    private Map<Integer, Map<String, String>> toCareMapData(List<AlertHistory> alertHistories) {
        Map<Integer, Map<String, String>> careDatas = new HashMap<>(1000);
        ObjectMapper objectMapper = new ObjectMapper();
        for (AlertHistory alertHistory : alertHistories) {
            String allContent = alertHistory.getJsonData();
            Map<String, Object> dataMap = null;
            try {
                dataMap = objectMapper.readValue(allContent, Map.class);
                String careData = Base64Utils.CharToHex(Base64Utils.base64Decode((String) dataMap.get("payload")));
                Map<String, String> parseData = Change.strDatas(careData);
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
