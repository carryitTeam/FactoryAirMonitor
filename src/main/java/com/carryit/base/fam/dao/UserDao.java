package com.carryit.base.fam.dao;

import com.carryit.base.fam.bean.User;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */
public interface UserDao {

    int addUser(User user);

    int deleteUser(User user);

    int deleteUserByGroupId(User user);

    int updateUser(User user);

    User queryUsersById(User user);

    List<User> queryAllUsersByRole(User user);

    List<User> queryAllUsersByGroupId(User user);

    User checkUserByPwd(User user);

}
