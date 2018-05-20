package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.service.impl.AlertHistoryService;
import com.carryit.base.fam.utils.ChangeToOneUtils;
import com.carryit.base.fam.utils.ChangeToSevenUtils;
import com.carryit.base.fam.utils.ChangeToSixUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
public class ChangeTest {
    @Autowired
    private AlertHistoryService alertHistoryService;


    //40001 4-5故障码判断
    @Test
    public void test10() throws Exception {

        String careData = "6a 00 27 01 e2 01 "
                + "08 21 ff 01 00 00 00 00 00 00 00 30 01 01 00 00 00 00 "
                + "6f 67 00 12 00 00 00 00 00 00 00 00 00 00 00 00 00 22 "
                + "da 16";
        String devEui="4a77006600288a";
        String appEui="2c26c5045c000002";
        String allContent="{\"CODE\":100,\"AppEUI\":\"2c26c5045c000002\",\"CmdSeq\":0,\"" +
                "DevEUI\":\"4a77006600288a\",\"MSG\":\"UPLOAD\",\"payload\":\"" +
                "agAnAREBCCH/AQAAAAAAAAAwAQEAAAAASxIAFgAAAAAAAAAAAAAAAAAilBY\",\"Port\":10,\"" +
                "detail\":{\"app\":{\"moteeui\":\"4a77006600288a\",\"appeui\":\"2c26c5045c000002\",\"dir\":\"up\",\"seqno\":787,\"userdata\":{\"port\":10,\"payload\":\"4IsL/7RFUianFJkfLRpeWfPRsfhDwc32tQsqXBDf0GsOdyFZA3KNowDbDJU\",\"conf\":true},\"motetx\":{\"freq\":483.7,\"datr\":\"SF7BW125\",\"codr\":\"4/5\",\"adr\":true},\"gwrx\":[{\"gweui\":\"6073bc000100001c\",\"ant\":1,\"ChMask\":\"00:3f:c0:00:00:00\",\"time\":\"2018-03-06T12:53:22.265Z\",\"timefromgateway\":false,\"chan\":7,\"rfch\":1,\"rssic\":-98,\"lsnr\":9.2}]}}}";
        Object lsnr = ChangeToOneUtils.transferHexFourToFive(careData);
        if (lsnr.equals(0)) {
            AlertHistory alertHistory = new AlertHistory();
            alertHistory.setAppEui(appEui);
            alertHistory.setDevEui(devEui);
            alertHistory.setJsonData(allContent);
            String id = Long.toString(new Date().getTime());
            alertHistory.setRuleId("ruleid_" + id);
            alertHistory.setHistoryId("historyId_" + id);
            alertHistory.setIsProcess("0");
            alertHistory.setGasConcentration(ChangeToSevenUtils.transferHexEightToFifteen(careData));
            alertHistory.setFaultContect("没有故障"+ ChangeToSixUtils.transferHexSixth(careData));
            alertHistoryService.addAlertHistory(alertHistory);
        }else if(lsnr.equals(1)){
            AlertHistory alertHistory = new AlertHistory();
            alertHistory.setAppEui(appEui);
            alertHistory.setDevEui(devEui);
            alertHistory.setJsonData(allContent);
            String id = Long.toString(new Date().getTime());
            alertHistory.setRuleId("ruleid_" + id);
            alertHistory.setHistoryId("historyId_" + id);
            alertHistory.setIsProcess("1");
            alertHistory.setGasConcentration(ChangeToSevenUtils.transferHexEightToFifteen(careData));
            alertHistory.setFaultContect("维修故障"+ ChangeToSixUtils.transferHexSixth(careData));
            alertHistoryService.addAlertHistory(alertHistory);
        }else {
            AlertHistory alertHistory = new AlertHistory();
            alertHistory.setAppEui(appEui);
            alertHistory.setDevEui(devEui);
            alertHistory.setJsonData(allContent);
            String id = Long.toString(new Date().getTime());
            alertHistory.setRuleId("ruleid_" + id);
            alertHistory.setHistoryId("historyId_" + id);
            alertHistory.setIsProcess("1");
            alertHistory.setGasConcentration(ChangeToSevenUtils.transferHexEightToFifteen(careData));
            alertHistory.setFaultContect("仪器故障"+ ChangeToSixUtils.transferHexSixth(careData));
            alertHistoryService.addAlertHistory(alertHistory);
        }
    }
}
