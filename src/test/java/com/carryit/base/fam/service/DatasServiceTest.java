package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.Datas;
import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.impl.DatasService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hlzou on 2018/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
public class DatasServiceTest {

    @Autowired
    private DatasService datasService;

    private Datas datas;

    private User user=new User();

    @Before
    public void init(){
        user.setUserId("hai");
    }

    @Test
    public void addDatas() throws Exception {

    }

    @Test
    public void queryUsersByUserId() throws Exception {
        List<Datas> datas = datasService.queryUsersByUserId(user);
        System.out.println(datas.size());
    }

    @Test
    public void queryAllUsersByAppEui() throws Exception {

    }

    @Test
    public void queryAllUsersByAppDevEui() throws Exception {

    }

}