package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.bean.LogOps;
import com.carryit.base.fam.dao.LogOpsDao;
import com.carryit.base.fam.service.ILogOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogOpsService implements ILogOpsService {

    @Autowired
    private LogOpsDao logOpsDao;

    @Override
    public int addLogOps(LogOps logOps) {
        return logOpsDao.addLogOps(logOps);
    }

    @Override
    public LogOps queryLogOpsByUid(LogOps logOps) {
        return logOpsDao.queryLogOpsByUid(logOps);
    }

    @Override
    public List<LogOps> queryAllLogOps() {
        return logOpsDao.queryAllLogOps();
    }
}
