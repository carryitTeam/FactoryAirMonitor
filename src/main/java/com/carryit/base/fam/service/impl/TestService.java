package com.carryit.base.fam.service.impl;

import com.carryit.base.fam.dao.TestDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hlzou on 2018/2/27.
 */
@Service
public class TestService {

    @Resource
    private TestDao testDao;

    public int countData() {
        return testDao.countData();
    }

}
