package com.carryit.base.fam.utils;

import java.util.ArrayList;

public class ChangeToSevenUtils {

    /*
    * 40007-->
    *   0-2转换十进制
    *
    * */
    public static long transferHexZeroToTwo(String hexStr){
        //以空格切割
        String str=hexStr.substring(18,hexStr.length()-6);
        String sys=ChangeUtils.transferHexToBinary(str);


        ArrayList list=new ArrayList<>();
        StringBuffer s1=new StringBuffer(sys);
        int index;
        for(index=16;index<=s1.length();index+=17){
            s1.insert(index, " ");
        }
        String[] hexs=s1.toString().split(" ");

        for(int i=0;i<hexs.length;i++){
            list.add(hexs[i]);
        }

        String sttsStarts=list.get(6).toString().substring(13,16);
        long zeroToTwo = ChangeUtils.toDecimalism(sttsStarts,2);

        return zeroToTwo;
    }


    /*
    * 40007-->
    *   3-7转换十进制
    *
    * */
    public static Long transferHexThreeToSeven(String hexStr){
        //以空格切割
        String str=hexStr.substring(18,hexStr.length()-6);
        String sys=ChangeUtils.transferHexToBinary(str);


        ArrayList list=new ArrayList<>();
        StringBuffer s1=new StringBuffer(sys);
        int index;
        for(index=16;index<=s1.length();index+=17){
            s1.insert(index, " ");
        }
        String[] hexs=s1.toString().split(" ");

        for(int i=0;i<hexs.length;i++){
            list.add(hexs[i]);
        }

        String sttsStarts=list.get(6).toString().substring(8,13);
        long threeToSeven = ChangeUtils.toDecimalism(sttsStarts,2);

        return threeToSeven;
    }

    /*
    * 40007-->
    *   8-15转换十进制
    *
    * */
    public static String transferHexEightToFifteen(String hexStr){
        //以空格切割
        String str=hexStr.substring(18,hexStr.length()-6);
        String sys=ChangeUtils.transferHexToBinary(str);


        ArrayList list=new ArrayList<>();
        StringBuffer s1=new StringBuffer(sys);
        int index;
        for(index=16;index<=s1.length();index+=17){
            s1.insert(index, " ");
        }
        String[] hexs=s1.toString().split(" ");

        for(int i=0;i<hexs.length;i++){
            list.add(hexs[i]);
        }

        String sttsStarts=list.get(6).toString().substring(0,8);
        //转换十进制
        long eightToFifteen = ChangeUtils.toDecimalism(sttsStarts,2);
        //转换字符串
        String eightToFifteens=String.valueOf(eightToFifteen);
        //判断赋值
        if(eightToFifteens.equals("1")){
            eightToFifteens= "ppm";
        }else if(eightToFifteens.equals("2")){
            eightToFifteens= "ppb";
        }else if(eightToFifteens.equals("4")){
            eightToFifteens="%volume";
        }else if(eightToFifteens.equals("8")){
            eightToFifteens="%LEL";
        }else {
            eightToFifteens= "mA";
        }
        return eightToFifteens;
    }
}
