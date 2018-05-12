package com.carryit.base.fam.hpb;


import java.util.HashMap;
import java.util.Map;

public class Change {
    public static Map<String, String> strDatas(String hexStr){
        Map<String, String> testMap = new HashMap<>();
        if (hexStr.startsWith("6b")){
            return testMap;
        }
        //40001 0-3
        String oneToOne=String.valueOf(ChangeToOneUtils.transferHexZeroToThree(hexStr));
        //4-5
        String oneToTwo=String.valueOf(ChangeToOneUtils.transferHexFourToFive(hexStr));
        //6
        String oneToThree=String.valueOf(ChangeToOneUtils.transferHexSix(hexStr));
        //7
        String oneToFour=String.valueOf(ChangeToOneUtils.transferHexSeven(hexStr));
        //8
        String oneToFive=String.valueOf(ChangeToOneUtils.transferHexEight(hexStr));
        //9
        String oneToSix=String.valueOf(ChangeToOneUtils.transferHexNine(hexStr));
        //10
        String oneToSeven=String.valueOf(ChangeToOneUtils.transferHexTen(hexStr));
        //11
        String oneToEight=String.valueOf(ChangeToOneUtils.transferHexEleven(hexStr));
        //12
        String oneToNine=String.valueOf(ChangeToOneUtils.transferHexTwelev(hexStr));
        //13-15
        String oneToTen=String.valueOf(ChangeToOneUtils.transferHexThirteenToFifteen(hexStr));

        //40002 0-7
        String twoToOne=String.valueOf(ChangeToTwoUtils.transferHexZeroToSeven(hexStr));
        //8-15
        String twoToTwo=String.valueOf(ChangeToTwoUtils.transferHexEightToFifteen(hexStr));
        //40003
        String three=String.valueOf(ChangeToThreeUtils.transferHexThird(hexStr));
        //40004
        String four=String.valueOf(ChangeToFourUtils.transferHexFourth(hexStr));
        //40005
        String five=String.valueOf(ChangeToFiveUtils.transferHexFifth(hexStr));
        //40006
        String six=String.valueOf(ChangeToSixUtils.transferHexSixth(hexStr));
        //40007 0-3
        String senvenToOne=String.valueOf(ChangeToSevenUtils.transferHexZeroToTwo(hexStr));
        //40007 3-7
        String senvenToTwo=String.valueOf(ChangeToSevenUtils.transferHexThreeToSeven(hexStr));
        //40007 8-15
        String senvenToThree=String.valueOf(ChangeToSevenUtils.transferHexEightToFifteen(hexStr));
        //40008
        String eight=String.valueOf(ChangeToTotalUtils.transferHexEighth(hexStr));
        //40009
        String nine=String.valueOf(ChangeToTotalUtils.transferHexNinth(hexStr));
        //40010
        String ten=String.valueOf(ChangeToTotalUtils.transferHexTenth(hexStr));
        //40011
        String eleven=String.valueOf(ChangeToTotalUtils.transferHexEleventh(hexStr));
        //40012
        String twelfth=String.valueOf(ChangeToTotalUtils.transferHexTwelfth(hexStr));
        //40013
        String thirteenth=String.valueOf(ChangeToTotalUtils.transferHexThirteenth(hexStr));
        //40014
        String fourteenth=String.valueOf(ChangeToTotalUtils.transferHexFourteenth(hexStr));
        //40015
        String fifteenth=String.valueOf(ChangeToTotalUtils.transferHexFifteenth(hexStr));
        //40016
        String sixteenth=String.valueOf(ChangeToTotalUtils.transferHexSixteenth(hexStr));
        //40017
        String seventeenth=String.valueOf(ChangeToTotalUtils.transferHexSeventeenth(hexStr));
        //40018
        String eighteenth=String.valueOf(ChangeToTotalUtils.transferHexEighteenth(hexStr));

        testMap.put("40001.0.3",oneToOne);
        testMap.put("40001.4.5",oneToTwo);
        testMap.put("40001.6",oneToThree);
        testMap.put("40001.7",oneToFour);
        testMap.put("40001.8",oneToFive);
        testMap.put("40001.9",oneToSix);
        testMap.put("40001.10",oneToSeven);
        testMap.put("40001.11",oneToEight);
        testMap.put("40001.12",oneToNine);
        testMap.put("40001.13.15",oneToTen);
        testMap.put("40002.0.7",twoToOne);
        testMap.put("40002.8.15",twoToTwo);
        testMap.put("40003",three);
        testMap.put("40004",four);
        testMap.put("40005",five);
        testMap.put("40006",six);
        testMap.put("40007.0.3",senvenToOne);
        testMap.put("40007.3.7",senvenToTwo);
        testMap.put("40007.8.15",senvenToThree);
        testMap.put("40008",eight);
        testMap.put("40009",nine);
        testMap.put("40010",ten);
        testMap.put("40011",eleven);
        testMap.put("40012",twelfth);
        testMap.put("40013",thirteenth);
        testMap.put("40014",fourteenth);
        testMap.put("40015",fifteenth);
        testMap.put("40016",sixteenth);
        testMap.put("40017",seventeenth);
        testMap.put("40018",eighteenth);
        return testMap;
    }

    public static void main(String[] args){
        String data="6b 00 04 04 00 78 aa 95 16";
        Map<String, String> dd = Change.strDatas(data);
        System.out.println(dd);
    }



}
