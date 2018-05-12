package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.FaultRecords;
import com.carryit.base.fam.dao.FaultRecordsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
@Service
public class FaultRecordsService implements IFaultRecordsService {

    @Autowired
    private FaultRecordsDao faultRecordsDao;

    @Override
    public int addFaultRecords(FaultRecords faultRecords) {
        return faultRecordsDao.addFaultRecords(faultRecords);
    }

    @Override
    public List<FaultRecords> queryFaultRecordsByAppEui(FaultRecords faultRecords) {
        return faultRecordsDao.queryFaultRecordsByAppEui(faultRecords);
    }

    @Override
    public List<FaultRecords> queryAllFaultRecords() {
        return faultRecordsDao.queryAllFaultRecords();
    }
}
