package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.claa.LoraDataRetrieve;
import com.carryit.base.fam.connection.CSQuit;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.hpb.Change;
import com.carryit.base.fam.init.SpringBeanFactory;
import com.carryit.base.fam.service.impl.AlertRuleServiceTestImpl;
import com.carryit.base.fam.service.impl.DatasService;
import com.carryit.base.fam.service.impl.PushDataToCsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hlzou on 2018/2/28.
 */

@Controller
public class DatasController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private AlertRuleServiceTestImpl alertRuleServiceTest;

    @Autowired
    private DatasService datasService;

    @Autowired
    private PushDataToCsService pushDataToCsService;

    @PostMapping("/refreshData")
    public
    @ResponseBody
    Object refreshData(HttpServletRequest request) {
        String appEui = request.getParameter("appEui");
        String createTime = request.getParameter("createTime");
        Datas datas = new Datas();
        datas.setAppEui(appEui);
        datas.setCreateTime(createTime);
        List<Datas> resDatas = datasService.queryAllUsersByAppEui(datas);
        if (resDatas.size() == 0) {
            return 0;
        }
        if (resDatas.size() > 10) {
            return resDatas.subList(0, 3);
        }
        return resDatas;
    }

    @PostMapping("/startReceiveData")
    public
    @ResponseBody
    Object startReceiveData(HttpServletRequest request) {
        Map<String, LoraDataRetrieve> dataRetrieveMap = (Map<String, LoraDataRetrieve>) servletContext.getAttribute("dataRetrieveMap");
        Map<String, Boolean> startedApp = (Map<String, Boolean>) servletContext.getAttribute("startedApp");
        if (dataRetrieveMap == null) {
            dataRetrieveMap = new HashMap<String, LoraDataRetrieve>();
        }
        if (startedApp == null) {
            startedApp = new HashMap<String, Boolean>();
        }
        String appEui = request.getParameter("appEui");
        String appKey = appEui;
        if (startedApp.get(appKey) == true) {
            return 2;
        }
        LoraDataRetrieve loraDataRetrieve = SpringBeanFactory.getBean(LoraDataRetrieve.class);
        try {
            loraDataRetrieve.setAppEui(appEui);
            loraDataRetrieve.setRunFlag(true);
            loraDataRetrieve.setAlertRuleService(alertRuleServiceTest);
            loraDataRetrieve.initConnection();
            Thread thread = new Thread(loraDataRetrieve);
            thread.start();
            Thread.sleep(3000L);

            if (!loraDataRetrieve.isAccept()) {
                loraDataRetrieve.setRunFlag(false);
                return 3;
            }

            //发送join，注册app（公司）
            startedApp.put(appKey, true);
            dataRetrieveMap.put(appKey, loraDataRetrieve);
            servletContext.setAttribute("dataRetrieveMap", dataRetrieveMap);
        } catch (Exception e) {
            loraDataRetrieve.setRunFlag(false);
            e.printStackTrace();
            return 0;
        } finally {
        }
        return 1;
    }


    @PostMapping("/stopReceiveData")
    public
    @ResponseBody
    Object stopReceiveData(HttpServletRequest request) {
        Map<String, LoraDataRetrieve> dataRetrieveMap = (Map<String, LoraDataRetrieve>) servletContext.getAttribute("dataRetrieveMap");
        if (dataRetrieveMap == null) {
            dataRetrieveMap = new HashMap<>();
        }
        Map<String, Boolean> startedApp = (Map<String, Boolean>) servletContext.getAttribute("startedApp");
        String appEui = request.getParameter("appEui");
        String appKey = appEui;
        if (startedApp.get(appKey) == false) {
            return 2;
        }
        LoraDataRetrieve loraDataRetrieve = dataRetrieveMap.get(appKey);
        Connection connection = loraDataRetrieve.getConnection();
        try {
            //发送quit
            CSQuit quit = new CSQuit();
            quit.setAppEUI(appEui);
            quit.setCMD("QUIT");
            quit.setCmdSeq(3);
            pushDataToCsService.putDataForQUIT(connection, quit);
//            String body = encapsulateContent(quit);
//            System.out.println(body);
//            quit.setHeader(Integer.toString(body.length()));
//            quit.setContent(body);
//            byte[] message = composeMessage(body);
//            connection.putData(message);
            dataRetrieveMap.get(appKey).setRunFlag(false);
            System.out.println("quit");
            //quit时，同时关闭取数线程，loraDataRetrieve.setRunFlag(false)
            startedApp.put(appKey, false);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
//            try {
//                connection.disconnect();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        return 1;
    }

    @PostMapping("/getNewData")
    public
    @ResponseBody
    Object getNewData(HttpServletRequest request) {
        String appEui = request.getParameter("appEui");
        Datas datas = new Datas();
        datas.setAppEui(appEui);
        List<Datas> datasList = datasService.queryAllUsersByAppEui(datas);
        if (datasList.size() > 0) {
            datas = datasList.get(0);
            String allContent = datas.getRealData();
            Map<String, String> parseData = Change.strDatas(allContent);
            parseData.put("careData", allContent);
            return parseData;
        } else {
            return "";
        }
    }

    @RequestMapping("/dataRetrieveByAppEui")
    public ModelAndView devicesForGroup(HttpServletRequest request) {
        HashMap<String, Boolean> startedApp = (HashMap<String, Boolean>) servletContext.getAttribute("startedApp");
        String appEui = request.getParameter("appEui");
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
//        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
        Datas datas = new Datas();
        datas.setAppEui(appEui);
        List<Datas> datasList = datasService.queryAllUsersByAppEui(datas);
        List<String> timeList = new ArrayList<>();
        List<Double> gasVal = new ArrayList<>();
        Map<Integer, Map<String, String>> parseData = toCareMapData(datasList, timeList, gasVal);
        modelAndView.addObject("datasList", datasList);
        modelAndView.addObject("parseData", parseData);
        modelAndView.addObject("startedApp", startedApp);
        modelAndView.addObject("timeList", timeList);
        modelAndView.addObject("gasVal", gasVal);
//        }
        modelAndView.setViewName("new/detailDataInfo");
        return modelAndView;
    }

    public Map<Integer, Map<String, String>> toCareMapData(List<Datas> datasList, List<String> timeList, List<Double> gasVal) {
        Map<Integer, Map<String, String>> careDatas = new HashMap<>(1000);
        for (Datas datas : datasList) {
            String allContent = datas.getRealData();
            Map<String, String> parseData = Change.strDatas(allContent);
            parseData.put("careData", allContent);
            careDatas.put(datas.getId(), parseData);
            if(allContent.startsWith("6b")){
                continue;
            }
            timeList.add("\""+datas.getCreateTime()+"\"");
            gasVal.add(Double.parseDouble(parseData.get("40003")));
        }
        return careDatas;
    }

}
