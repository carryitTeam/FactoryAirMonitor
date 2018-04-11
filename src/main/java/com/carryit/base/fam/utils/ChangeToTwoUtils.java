package com.carryit.base.fam.utils;

import java.util.ArrayList;

public class ChangeToTwoUtils {

    /*
    * 40002-->
    *   0-7转换
    *
    * */
    public static Long transferHexZeroToSeven(String hexStr){
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

        String sttsStarts=list.get(1).toString().substring(8,16);
        long zeroToSeven = ChangeUtils.toDecimalism(sttsStarts,2);

        return zeroToSeven;
    }

    /*
    * 40002-->
    *   8-15转换
    *
    * */
    public static Long transferHexEightToFifteen(String hexStr){
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

        String sttsStarts=list.get(1).toString().substring(0,8);
        long eightToFifteen = ChangeUtils.toDecimalism(sttsStarts,2);

        return eightToFifteen;
    }

}
