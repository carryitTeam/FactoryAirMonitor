package com.carryit.base.fam.controller;

import com.carryit.base.fam.claa.LoraDataRetrieve;
import com.carryit.base.fam.connection.CSQuit;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.init.SpringBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.carryit.base.fam.utils.CmdMessageUtils.composeMessage;
import static com.carryit.base.fam.utils.CmdMessageUtils.encapsulateContent;

/**
 * Created by hlzou on 2018/2/28.
 */

@Controller
public class DatasController {

//    @Autowired
//    private LoraDataRetrieve loraDataRetrieve;

    @Autowired
    private ServletContext servletContext;

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
            try {
                connection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

}
