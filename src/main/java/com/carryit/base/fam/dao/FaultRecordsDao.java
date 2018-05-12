package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.FaultRecords;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface FaultRecordsDao {

    int addFaultRecords(FaultRecords faultRecords);

    List<FaultRecords> queryFaultRecordsByAppEui(FaultRecords faultRecords);

    List<FaultRecords> queryAllFaultRecords();

}
