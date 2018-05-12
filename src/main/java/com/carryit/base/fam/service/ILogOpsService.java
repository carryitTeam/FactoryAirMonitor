package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.LogOps;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface ILogOpsService {

    int addLogOps(LogOps logOps);

    LogOps queryLogOpsByUid(LogOps logOps);

    List<LogOps> queryAllLogOps();

}
