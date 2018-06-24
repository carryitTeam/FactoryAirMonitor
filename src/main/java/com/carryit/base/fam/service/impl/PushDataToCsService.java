package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.connection.CSData2Dev;
import com.carryit.base.fam.connection.CSJoinReq;
import com.carryit.base.fam.connection.CSQuit;
import com.carryit.base.fam.connection.Connection;
import com.carryit.base.fam.utils.Base64Utils;
import org.springframework.stereotype.Service;


import static com.carryit.base.fam.utils.CmdMessageUtils.composeMessage;
import static com.carryit.base.fam.utils.CmdMessageUtils.encapsulateContent;

/**
 * Created by hlzou on 2018/3/30.
 */
@Service("pushDataToCsService")
public class PushDataToCsService {

    public void putDataForSENDTO(Connection connection, CSData2Dev csData2Dev) throws Exception {
        String ts = Base64Utils.HexToChar(csData2Dev.getPayload());
        String pltmp = Base64Utils.base64Encode(ts);
        csData2Dev.setPayload(pltmp);
        String body = encapsulateContent(csData2Dev);
        System.out.println("send to body:"+body);
        csData2Dev.setHeader(Integer.toString(body.length()));
        csData2Dev.setContent(body);
        byte[] message = composeMessage(body);
        connection.putData(message);
    }

    public void putDataForJOIN(Connection connection, CSJoinReq jq) throws Exception {
        String body = encapsulateContent(jq);
        System.out.println("join body:"+body);
        jq.setHeader(Integer.toString(body.length()));
        jq.setContent(body);
        byte[] message = composeMessage(body);
        connection.putData(message);
    }

    public void putDataForQUIT(Connection connection, CSQuit quit) throws Exception {
        String body = encapsulateContent(quit);
        System.out.println("quit body:"+body);
        quit.setHeader(Integer.toString(body.length()));
        quit.setContent(body);
        byte[] message = composeMessage(body);
        connection.putData(message);
    }


}
