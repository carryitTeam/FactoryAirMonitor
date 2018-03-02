package com.carryit.base.fam.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.UnsupportedEncodingException;

/**
 * Created by hlzou on 2018/2/28.
 */
public class CmdMessageUtils {


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

    public static String encapsulateHeader(int header) {
        String newheader = null;
        if (header <= 0 || header > 2048) {
            return null;
        }
        newheader = Integer.toString(header);
        return newheader;
    }
}
