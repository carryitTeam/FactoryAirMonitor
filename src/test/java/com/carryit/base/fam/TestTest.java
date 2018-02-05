package com.carryit.base.fam;


import com.carryit.base.fam.claa.LoraDataRetrieve;
import com.carryit.base.fam.connection.*;
import com.carryit.base.fam.utils.Base64Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.*;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

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
    public void test9(){
        Base64Utils utils = new Base64Utils();
        System.out.println(utils.CharToHex(utils.base64Decode("agAnAegBCCH/AQAAAAAAAAAwAQEAAAAA274ACwAAAAAAAAAAAAAAAAAinBY")));
    }

    @Test
    public void test8() {
        System.out.println(('f' - 'A'));
        System.out.println(~0);
        System.out.println(Long.parseLong("3F", 16));
        String str = "NtX34ZmKXAz/FWPz51z6ZmkPPTI3BPt/1nRZIPAM6Nje+6c/Sdt7Dkr1s6s";
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println(ConvertBase64CharacterToBinary(str.charAt(i)));
//        }

        System.out.println(Arrays.toString("hlzou".getBytes()));
        System.out.println((0 << 6));
        System.out.println(bytesToHexFun3("hlzou".getBytes()));
    }

    public static String bytesToHexFun3(byte[] bytes) {
        StringBuilder buf = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) { // 使用String的format方法进行转换
            buf.append(String.format("%02x", new Integer(b & 0xff)));
        }

        return buf.toString();
    }

    public int ConvertBase64CharacterToBinary(char in) {
        if (in >= 'A' && in <= 'Z')
            return (in - 'A');
        else if (in >= 'a' && in <= 'z')
            return (in - 'a' + 26);
        else if (in >= '0' && in <= '9')
            return (in - '0' + 52);
        else if (in == '+')
            return 62;
        else if (in == '/')
            return 63;
        else
            return ~0;
    }

    @Test
    public void test7() throws Exception {
        BASE64Encoder encoder = new BASE64Encoder();
        BASE64Decoder decoder = new BASE64Decoder();
        String text = "字串文字";
        byte[] textByte = text.getBytes("UTF-8");
        String encodedText = encoder.encode(textByte);
        System.out.println(encodedText);
        System.out.println(new String(decoder.decodeBuffer("agAnAewBCCH/AQAAAAAAAAAwAQEAAAAAd+8ACwAAAAAAAAAAAAAAAAAibRY"), "UTF-8"));


    }

    @Test
    public void test6() throws Exception {
        TCPConnection connection = new TCPConnection();
        connection.getConnection("139.129.216.128", 30002);

        //获取数据
        LoraDataRetrieve loraDataRetrieve = new LoraDataRetrieve();
        loraDataRetrieve.setConnection(connection);
        Thread thread = new Thread(loraDataRetrieve);
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

//        CSUpload csUpload = new CSUpload();
//
//        csUpload.setCmdSeq(4);
//        csUpload.setAppEUI("2c26c5045c000002");
//        csUpload.setCODE(100);
//        csUpload.setDevEUI("4a7700660036a7");
//        csUpload.setMSG("UPLOAD");
//        csUpload.setPlayload("awAEBAB4qpUW");
//        csUpload.setPort(21);
//
//        body = encapsulateContent(csUpload);
//        System.out.println(body);
//        csUpload.setHeader(Integer.toString(body.length()));
//        csUpload.setContent(body);
//
//        message = composeMessage(body);
//        connection.putData(message);
//        System.out.println("upload");


//        //发送quit
//        CSQuit quit = new CSQuit();
//        quit.setAppEUI("2c26c5045c000002");
//        quit.setCMD("QUIT");
//        quit.setCmdSeq(3);
//        body = encapsulateContent(quit);
//        System.out.println(body);
//        quit.setHeader(Integer.toString(body.length()));
//        jq.setContent(body);
//        message = composeMessage(body);
//        connection.putData(message);
//        System.out.println("quit");
//        //quit时，同时关闭取数线程，loraDataRetrieve.setRunFlag(false)
//        loraDataRetrieve.setRunFlag(false);


        Thread.sleep(240000l);

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