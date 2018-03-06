package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.FaultRecords;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface IFaultRecordsService {

    int addFaultRecords(FaultRecords faultRecords);

    List<FaultRecords> queryFaultRecordsByAppEui(FaultRecords faultRecords);
}
