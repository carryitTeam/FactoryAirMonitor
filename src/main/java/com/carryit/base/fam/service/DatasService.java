package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.dao.DatasDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hlzou on 2018/3/1.
 */
@Service
public class DatasService implements IDatasService {

    @Resource
    private DatasDao datasDao;

    @Override
    public int addDatas(Datas datas) {
        return datasDao.addDatas(datas);
    }

    @Override
    public List<Datas> queryUsersByUserId(User user) {
        return datasDao.queryUsersByUserId(user);
    }

    @Override
    public List<Datas> queryAllUsersByAppEui(Datas datas) {
        return datasDao.queryAllUsersByAppEui(datas);
    }

    @Override
    public List<Datas> queryAllUsersByAppDevEui(Datas datas) {
        return datasDao.queryAllUsersByAppDevEui(datas);
    }
}
