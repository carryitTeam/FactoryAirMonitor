package com.carryit.base.fam.controller;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.DeviceConfig;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.claa.LoraDataRetrieve;
import com.carryit.base.fam.connection.CSQuit;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.hpb.Change;
import com.carryit.base.fam.init.SpringBeanFactory;
import com.carryit.base.fam.service.DatasService;
import com.carryit.base.fam.utils.Base64Utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.carryit.base.fam.utils.CmdMessageUtils.composeMessage;
import static com.carryit.base.fam.utils.CmdMessageUtils.encapsulateContent;

/**
 * Created by hlzou on 2018/2/28.
 */

@Controller
public class DatasController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private DatasService datasService;

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
        if (dataRetrieveMap == null) {
            dataRetrieveMap = new HashMap<>();
        }
        Map<String, Boolean> userData = (Map<String, Boolean>) servletContext.getAttribute("userData");
        String userId = request.getParameter("userId");
        String appEui = request.getParameter("appEui");
        String appKey = userId + "_" + appEui;
        if (userData.get(appKey) == true) {
            return 2;
        }
        System.out.println(userId);
        LoraDataRetrieve loraDataRetrieve = SpringBeanFactory.getBean(LoraDataRetrieve.class);
        try {
            loraDataRetrieve.setAppEui(appEui);
            loraDataRetrieve.setHost("139.129.216.128");
            loraDataRetrieve.setPort(30002);
            loraDataRetrieve.setRunFlag(true);
            loraDataRetrieve.initConnection();
            Thread thread = new Thread(loraDataRetrieve);
            thread.start();
            Thread.sleep(3000l);

            if (!loraDataRetrieve.isAccept()) {
                loraDataRetrieve.setRunFlag(false);
                return 3;
            }

            //发送join，注册app（公司）
            userData.put(appKey, true);
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
        Map<String, Boolean> userData = (Map<String, Boolean>) servletContext.getAttribute("userData");
        String userId = request.getParameter("userId");
        String appEui = request.getParameter("appEui");
        System.out.println(userId);
        String appKey = userId + "_" + appEui;
        if (userData.get(appKey) == false) {
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
            String body = encapsulateContent(quit);
            System.out.println(body);
            quit.setHeader(Integer.toString(body.length()));
            quit.setContent(body);
            byte[] message = composeMessage(body);
            dataRetrieveMap.get(appKey).setRunFlag(false);
            connection.putData(message);
            System.out.println("quit");
            //quit时，同时关闭取数线程，loraDataRetrieve.setRunFlag(false)
            userData.put(appKey, false);
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

    @RequestMapping("/dataRetrieveByAppEui")
    public ModelAndView devicesForGroup(HttpServletRequest request) {
        String appEui = request.getParameter("appEui");
        ModelAndView modelAndView = new ModelAndView();
        if (request.getSession().getAttribute("cuser") == null) {
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        User cuser = (User) request.getSession().getAttribute("cuser");
        modelAndView.addObject("cuser", cuser);
        if ("superAdmin".equalsIgnoreCase(cuser.getUserRole())) {
            Datas datas = new Datas();
            datas.setAppEui(appEui);
            List<Datas> datasList = datasService.queryAllUsersByAppEui(datas);
            Map<Integer, Map<String, String>> parseData = toCareMapData(datasList);
            modelAndView.addObject("datasList", datasList);
            modelAndView.addObject("parseData", parseData);
        }
        modelAndView.setViewName("new/detailDataInfo");
        return modelAndView;
    }

    public Map<Integer, Map<String, String>> toCareMapData(List<Datas> datasList) {
        Map<Integer, Map<String, String>> careDatas = new HashMap<>(1000);
        for (Datas datas : datasList) {
            String allContent = datas.getRealData();
            Map<String, String> parseData = Change.strDatas(allContent);
            parseData.put("careData", allContent);
            careDatas.put(datas.getId(), parseData);
        }
        return careDatas;
    }

}
