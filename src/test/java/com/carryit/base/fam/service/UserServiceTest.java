package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by hlzou on 2018/2/27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
public class UserServiceTest {


    @Autowired
    private UserService userService;

    private User user = new User();

    @Before
    public void init() {
        user.setUserId("hlzou1");
        user.setUserName("hlzou1");
        user.setUserPwd("123456");
        user.setUserEmail("hlzou1@Ctrip.com");
        user.setUserRole("admin");
        user.setChangeTime("2018-02-27 15:00:00");
        user.setCreateTime("2018-02-27 15:00:00");
    }

    @Test
    public void addUser() throws Exception {
        int res = userService.addUser(user);

        System.out.println(res);
    }

    @Test
    public void deleteUser() throws Exception {
        int res = userService.deleteUser(user);
        System.out.println(res);
    }

    @Test
    public void updateUser() throws Exception {
        int res = userService.updateUser(user);
        System.out.println(res);
    }

    @Test
    public void queryUsersById() throws Exception {
        User user1 = userService.queryUsersById(user);
        System.out.println(user1);
    }

    @Test
    public void queryAllUsersByRole() throws Exception {
        List<User> user1 = userService.queryAllUsersByRole(user);
        System.out.println(user1);
    }

    @Test
    public void checkUserByPwd() throws Exception {
        User user1 = userService.checkUserByPwd(user);
        System.out.println(user1);
    }

}