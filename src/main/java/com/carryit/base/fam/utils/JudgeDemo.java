package com.carryit.base.fam.utils;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.service.AlertHistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.carryit.base.fam.utils.ChangeToOneUtils;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JudgeDemo {
    @Autowired
    private AlertHistoryService alertHistoryService;


    public void runJudge(){
        String careData="";
        //如果0-3字段取出来是多少的时候做判断

        if(ChangeToOneUtils.transferHexZeroToThree(careData)==0){


        } else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 1) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 2) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 3) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 4) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 5) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 6) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 7) {


        }else if (ChangeToOneUtils.transferHexZeroToThree(careData) == 8) {


        }else {

        }


        //4-5做判断
        if(ChangeToOneUtils.transferHexFourToFive(careData)==0){

        }else if(ChangeToOneUtils.transferHexFourToFive(careData)==1){

        }else {

        }

        //6判断
        if(ChangeToOneUtils.transferHexSix(careData)==1){

        }

        //7判断
        if(ChangeToOneUtils.transferHexSeven(careData)==2){

        }


    }

}



