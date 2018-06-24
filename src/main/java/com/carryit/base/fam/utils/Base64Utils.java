package com.carryit.base.fam.utils;

import java.util.regex.Matcher;

/**
 * Created by hlzou on 2018/2/2.
 */
public class Base64Utils {

    private static Integer[] base64DecodeChars = new Integer[]{
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};


    public static String base64Decode(String str) {
        int c1, c2, c3, c4;
        int i, len;
        String out = "";

        len = str.length();
        i = 0;
        while (i < len) {
            do {
                if (i < len) {
                    c1 = base64DecodeChars[((byte) str.charAt(i++)) & 0xff];
                } else {
                    c1 = -1;
                }
            } while (i < len && c1 == -1);
            if (c1 == -1)
                break;

            do {
                if (i < len) {
                    c2 = base64DecodeChars[((byte) str.charAt(i++)) & 0xff];
                } else {
                    c2 = -1;
                }
            } while (i < len && c2 == -1);
            if (c2 == -1)
                break;

            out += (char) ((c1 << 2) | ((c2 & 0x30) >> 4));

            do {
                if (i < len) {
                    c3 = ((byte) str.charAt(i++)) & 0xff;
                } else {
                    c3 = 0;
                }
                if (c3 == 61)
                    return out;
                c3 = base64DecodeChars[c3];
            } while (i < len && c3 == -1);
            if (c3 == -1)
                break;

            out += (char) (((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));

            do {
                if (i < len) {
                    c4 = ((byte) str.charAt(i++)) & 0xff;
                } else {
                    c4 = 0;
                }
                if (c4 == 61)
                    return out;
                c4 = base64DecodeChars[c4];
            } while (i < len && c4 == -1);
            if (c4 == -1)
                break;
            out += (char) (((c3 & 0x03) << 6) | c4);
        }
        return out;

    }

    public static String base64Encode(String str) {
        String base64EncodeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
        int i, len;
        int c1, c2, c3;

        len = str.length();
        i = 0;
        String out = "";
        while (i < len) {
            c1 = str.charAt(i++) & 0xff;
            if (i == len) {
                out += base64EncodeChars.charAt(c1 >> 2);
                out += base64EncodeChars.charAt((c1 & 0x3) << 4);
                out += "==";
                break;
            }
            c2 = str.charAt(i++);
            if (i == len) {
                out += base64EncodeChars.charAt(c1 >> 2);
                out += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
                out += base64EncodeChars.charAt((c2 & 0xF) << 2);
                out += "=";
                break;
            }
            c3 = str.charAt(i++);
            out += base64EncodeChars.charAt(c1 >> 2);
            out += base64EncodeChars.charAt(((c1 & 0x3) << 4) | ((c2 & 0xF0) >> 4));
            out += base64EncodeChars.charAt(((c2 & 0xF) << 2) | ((c3 & 0xC0) >> 6));
            out += base64EncodeChars.charAt(c3 & 0x3F);
        }
        return out;

    }

    public static String CharToHex(String str) {
        String h = "";
        int c;
        String out = "";
        int len = str.length();
        int i = 0;
        while (i < len) {
            c = str.charAt(i++);
            h = Integer.toHexString(c);
            if (h.length() < 2)
                h = "0" + h;

            out += h + " ";
            if (i > 0 && i % 8 == 0) {
            }
        }
        return out;
    }

    public static String HexToChar(String str) {
        int len = str.length();
        String out = "";
        String c1, c2;
        int val;
        if (len % 2 != 0) {
//            console.error("Bad data, should be even.");
            return out;
        } else {
            //TODO:should first check the str is [0-9A-F] and trim all the blank char
            for (int i = 0; i < (len / 2); i++) {
                c1 = str.charAt(i * 2) + "";
                c2 = str.charAt(i * 2 + 1) + "";
                val = Integer.parseInt(c1, 16) * 16 + Integer.parseInt(c2, 16);
                out = out + (char) val;
            }
            return out;
        }
    }


    public static String encodeBase64(byte[] input) throws Exception {
        //return new sun.misc.BASE64Encoder().encode(input);
        //Modify by weiwei on 2016.11.16 to set the problem that every
        //76 chars will insert \r,\n or \r\n  by RFC2045:
        //Encoded lines must not be longer than 76 characters,
        //not counting the trailing CRLF. If longer lines are
        //found in incoming, encoded data, a robust
        //implementation might nevertheless decode the lines, and
        //might report the erroneous encoding to the user.
        String put = new sun.misc.BASE64Encoder().encode(input);
        put = put.replaceAll(Matcher.quoteReplacement("\r|\n"), "");
        return put;
    }


}
