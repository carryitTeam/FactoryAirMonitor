package com.carryit.base.fam;


import com.carryit.base.fam.claa.LoraDataRetrieve;
import com.carryit.base.fam.connection.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.*;
import org.junit.Test;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by hlzou on 2018/1/15.
 */
public class TestTest {

    @Test
    public void test6() throws Exception {
        TCPConnection connection = new TCPConnection();
        connection.getConnection("139.129.216.128",30002);

        //获取数据
        LoraDataRetrieve loraDataRetrieve = new LoraDataRetrieve();
        loraDataRetrieve.setConnection(connection);
        Thread thread= new Thread(loraDataRetrieve);
        thread.start();


        Thread.sleep(3000l);

        //发送join，注册app（公司）
        CSJoinReq jq = new CSJoinReq();
        jq.setAppEUI("2c26c5045c000002");
        jq.setAppNonce(Integer.parseInt("12345678"));
//        jq.setChallenge(challenge(composeHexMsg("2c26c5045c000002", "12345678"), "45:4c:53:4f:4e:49:43:00:00:00:00:00:00:00:00:01"));
        // System.out.println(jq.getChallenge().length());
        jq.setChallenge("12345678");
        jq.setCmdSeq(Configure.cmdseq_counter);
        jq.setCMD("JOIN");
        String body = encapsulateContent(jq);
        System.out.println(body);
        jq.setHeader(Integer.toString(body.length()));
        jq.setContent(body);
        byte[] message = composeMessage(body);
        connection.putData(message);
        System.out.println("join");


        Thread.sleep(60000l);

        //发送quit
        CSQuit quit = new CSQuit();
        quit.setAppEUI("2c26c5045c000002");
        quit.setCMD("QUIT");
        quit.setCmdSeq(3);
        body = encapsulateContent(quit);
        System.out.println(body);
        quit.setHeader(Integer.toString(body.length()));
        jq.setContent(body);
        message = composeMessage(body);
        connection.putData(message);
        System.out.println("quit");

        //quit时，同时关闭取数线程，loraDataRetrieve.setRunFlag(false)
        loraDataRetrieve.setRunFlag(false);


        Thread.sleep(120000l);

    }



    public static String encapsulateHeader(int header) {
        String newheader = null;
        if (header <= 0 || header > 2048) {
            return null;
        }
        newheader = Integer.toString(header);
        return newheader;
    }

    public static byte[] composeMessage(String body) throws UnsupportedEncodingException {
        int len = body.length();
        String head = encapsulateHeader(len);
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append(head);
        sb.append("\n");
        sb.append(body);
        return sb.toString().getBytes("UTF-8");
    }

    public static String encapsulateContent(Object content) throws UnsupportedEncodingException {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        return gson.toJson(content);
    }

}