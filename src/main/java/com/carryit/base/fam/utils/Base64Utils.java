package com.carryit.base.fam.utils;

/**
 * Created by hlzou on 2018/2/2.
 */
public class Base64Utils {

    private static Integer [] base64DecodeChars = new Integer []{
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14,
            15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};


    public static String base64Decode(String str) {
        int c1, c2, c3, c4;
        int i, len;
        String out="";

        len = str.length();
        i = 0;
        while(i < len) {
            do {
                if (i<len){
                    c1 = base64DecodeChars[((byte)str.charAt(i++)) & 0xff];
                }else {
                    c1 = -1;
                }
            } while(i < len && c1 == -1);
            if(c1 == -1)
                break;

            do {
                if (i<len){
                    c2 = base64DecodeChars[((byte)str.charAt(i++)) & 0xff];
                }else {
                    c2 = -1;
                }
            } while(i < len && c2 == -1);
            if(c2 == -1)
                break;

            out += (char)((c1 << 2) | ((c2 & 0x30) >> 4));

            do {
                if (i<len){
                    c3 = ((byte)str.charAt(i++)) & 0xff;
                }else {
                    c3 = 0;
                }
                if(c3 == 61)
                    return out;
                c3 = base64DecodeChars[c3];
            } while(i < len && c3 == -1);
            if(c3 == -1)
                break;

            out += (char)(((c2 & 0XF) << 4) | ((c3 & 0x3C) >> 2));

            do {
                if (i<len){
                    c4 = ((byte)str.charAt(i++)) & 0xff;
                }else {
                    c4=0;
                }
                if(c4 == 61)
                    return out;
                c4 = base64DecodeChars[c4];
            } while(i < len && c4 == -1);
            if(c4 == -1)
                break;
            out += (char)(((c3 & 0x03) << 6) | c4);
        }
        return out;

    }

    public static String CharToHex(String str) {
        String h="";
        int c;
        String out = "";
        int len = str.length();
        int i = 0;
        while(i < len)
        {
            c = str.charAt(i++);
            h =  Integer.toHexString(c);
            if(h.length() < 2)
                h = "0" + h;

            out +=  h + " ";
            if(i > 0 && i % 8 == 0) {
            }
        }
        return out;
    }

}
