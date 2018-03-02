package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.User;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface IDatasDao {

    int addDatas(Datas datas);

    List<Datas> queryUsersByUserId(User user);

    List<Datas> queryAllUsersByAppEui(Datas datas);

    List<Datas> queryAllUsersByAppDevEui(Datas datas);
}
