package com.carryit.base.fam.utils;

import java.util.ArrayList;

public class ChangeToOneUtils {

    /*
    * 40001-->
    *   0-3转换
    *
    * */
    public static Long transferHexZeroToThree(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(12,16);
        long zeroToThree = ChangeUtils.toDecimalism(sttsStarts,10);

        return zeroToThree;
    }

    /*
    * 40001-->
    *   4-5转换
    *
    * */
    public static Long transferHexFourToFive(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(10,12);
        long fourToFive = ChangeUtils.toDecimalism(sttsStarts,10);

        return fourToFive;
    }

    /*
   * 40001-->
   *   6转换
   *
   * */
    public static Long transferHexSix(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(9,10);
        long six = ChangeUtils.toDecimalism(sttsStarts,10);

        return six;
    }


    /*
  * 40001-->
  *   7转换
  *
  * */
    public static Long transferHexSeven(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(8,9);
        long seven = ChangeUtils.toDecimalism(sttsStarts,10);

        return seven;
    }

    /*
  * 40001-->
  *   8转换
  *
  * */
    public static Long transferHexEight(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(7,8);
        long eight = ChangeUtils.toDecimalism(sttsStarts,10);

        return eight;
    }

    /*
 * 40001-->
 *   9转换
 *
 * */
    public static Long transferHexNine(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(6,7);
        long nine = ChangeUtils.toDecimalism(sttsStarts,10);

        return nine;
    }

    /*
 * 40001-->
 *   10转换
 *
 * */
    public static Long transferHexTen(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(5,6);
        long ten = ChangeUtils.toDecimalism(sttsStarts,10);

        return ten;
    }


    /*
 * 40001-->
 *  11转换
 *
 * */
    public static Long transferHexEleven(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(4,5);
        long eleven = ChangeUtils.toDecimalism(sttsStarts,10);

        return eleven;
    }

    /*
 * 40001-->
 *   12转换
 *
 * */
    public static Long transferHexTwelev(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(3,4);
        long twelev = ChangeUtils.toDecimalism(sttsStarts,10);

        return twelev;
    }

    /*
* 40001-->
*   13-15转换
*
* */
    public static Long transferHexThirteenToFifteen(String hexStr){
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

        //40001    000010000010 0001
        String sttsStarts=list.get(0).toString().substring(0,3);
        long thirteenToFifteen = ChangeUtils.toDecimalism(sttsStarts,10);

        return thirteenToFifteen;
    }

}
