package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.connection.*;
import com.carryit.base.fam.utils.Base64Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.regex.Matcher;

import static com.carryit.base.fam.utils.CmdMessageUtils.composeMessage;
import static com.carryit.base.fam.utils.CmdMessageUtils.encapsulateContent;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
public class PushDataToCsServiceTest {
    @Autowired
    private PushDataToCsService pushDataToCsService;

    @Autowired
    private TCPConnection connection;

    @Test
    public void sendToData() throws Exception {
        String appEui="2c26c5045c000002";
        connection.getConnection("139.129.216.128",30002);

        Thread.sleep(10000);

        CSJoinReq jq = new CSJoinReq();
        jq.setAppEUI(appEui);
        jq.setAppNonce(Integer.parseInt("1"));
        jq.setChallenge("1");
        jq.setCmdSeq(Configure.cmdseq_counter);
        jq.setCMD("JOIN");

        pushDataToCsService.putDataForJOIN(connection,jq);
        String originData = new String(connection.getData());
        System.out.println("ddd1:"+originData);
        Thread.sleep(10000);

        CSData2Dev data2Dev = new CSData2Dev();
        data2Dev.setCMD("SENDTO");
        data2Dev.setCmdSeq(5);
        data2Dev.setAppEUI(appEui);
        data2Dev.setDevEUI("4a7700660030b1");
        data2Dev.setPort(10);
//        String pl = "6B000303FF209016";
        String pl = "6B000303FF108016";
        data2Dev.setPayload(pl);

        pushDataToCsService.putDataForSENDTO(connection,data2Dev);
        originData = new String(connection.getData());
        System.out.println("ddd2:"+originData);

        Thread.sleep(60000);
//        发送quit
        CSQuit quit = new CSQuit();
        quit.setAppEUI(appEui);
        quit.setCMD("QUIT");
        quit.setCmdSeq(3);
        pushDataToCsService.putDataForQUIT(connection,quit);
    }

}