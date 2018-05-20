package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.connection.CSData2Dev;
import com.carryit.base.fam.connection.Connection;
import org.springframework.stereotype.Service;


import static com.carryit.base.fam.utils.CmdMessageUtils.composeMessage;
import static com.carryit.base.fam.utils.CmdMessageUtils.encapsulateContent;

/**
 * Created by hlzou on 2018/3/30.
 */
@Service("pushDataToCsService")
public class PushDataToCsService {

    public void sendToData(Connection connection, CSData2Dev csData2Dev) throws Exception {
        String body = encapsulateContent(csData2Dev);
        System.out.println(body);
        csData2Dev.setHeader(Integer.toString(body.length()));
        csData2Dev.setContent(body);
        byte[] message = composeMessage(body);
        connection.putData(message);
    }

}
