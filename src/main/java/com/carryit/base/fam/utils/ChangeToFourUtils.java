package com.carryit.base.fam.utils;

import java.util.ArrayList;

public class ChangeToFourUtils {

    /*
    * 40004-->
    *   转换十进制
    *
    * */
    public static Long transferHexFourth(String hexStr){
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

        String sttsStarts=list.get(3).toString();
        long fourth = ChangeUtils.toDecimalism(sttsStarts,10);

        return fourth;
    }



}
