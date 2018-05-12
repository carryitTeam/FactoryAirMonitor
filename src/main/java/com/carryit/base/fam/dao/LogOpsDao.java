package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.AlertHistory;
import com.carryit.base.fam.bean.LogOps;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface LogOpsDao {

    int addLogOps(LogOps logOps);

    LogOps queryLogOpsByUid(LogOps logOps);

    List<LogOps> queryAllLogOps();

}
