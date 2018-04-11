package com.carryit.base.fam.utils;

import java.util.ArrayList;

public class ChangeToTotalUtils {

    /*
    * 40008-->
    *   转换十进制
    *
    * */
    public static Long transferHexEighth(String hexStr){
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

        String sttsStarts=list.get(7).toString();
        long eighth = ChangeUtils.toDecimalism(sttsStarts,2);

        return eighth;
    }


    /*
    * 40009-->
    *   转换十进制
    *
    * */
    public static Long transferHexNinth(String hexStr){
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

        String sttsStarts=list.get(8).toString();
        long ninth = ChangeUtils.toDecimalism(sttsStarts,2);

        return ninth;
    }


    /*
   * 40010-->
   *   转换十进制
   *
   * */
    public static Long transferHexTenth(String hexStr){
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

        String sttsStarts=list.get(9).toString();
        long tenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return tenth;
    }

    /*
   * 40011-->
   *   转换十进制
   *
   * */
    public static Long transferHexEleventh(String hexStr){
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

        String sttsStarts=list.get(10).toString();
        long eleventh = ChangeUtils.toDecimalism(sttsStarts,2);

        return eleventh;
    }



    /*
   * 40012-->
   *   转换十进制
   *
   * */
    public static Long transferHexTwelfth(String hexStr){
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

        String sttsStarts=list.get(11).toString();
        long twelfth = ChangeUtils.toDecimalism(sttsStarts,2);

        return twelfth;
    }


    /*
   * 40013-->
   *   转换十进制
   *
   * */
    public static Long transferHexThirteenth(String hexStr){
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

        String sttsStarts=list.get(12).toString();
        long thirteenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return thirteenth;
    }



    /*
   * 40014-->
   *   转换十进制
   *
   * */
    public static Long transferHexFourteenth(String hexStr){
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

        String sttsStarts=list.get(13).toString();
        long fourteenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return fourteenth;
    }

    /*
   * 40015-->
   *   转换十进制
   *
   * */
    public static Long transferHexFifteenth(String hexStr){
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

        String sttsStarts=list.get(14).toString();
        long fifteenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return fifteenth;
    }

    /*
   * 40016-->
   *   转换十进制
   *
   * */
    public static Long transferHexSixteenth(String hexStr){
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

        String sttsStarts=list.get(15).toString();
        long sixteenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return sixteenth;
    }

    /*
   * 40017-->
   *   转换十进制
   *
   * */
    public static Long transferHexSeventeenth(String hexStr){
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

        String sttsStarts=list.get(16).toString();
        long seventeenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return seventeenth;
    }

    /*
   * 40012-->
   *   转换十进制
   *
   * */
    public static Long transferHexEighteenth(String hexStr){
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

        String sttsStarts=list.get(17).toString();
        long eighteenth = ChangeUtils.toDecimalism(sttsStarts,2);

        return eighteenth;
    }


}
