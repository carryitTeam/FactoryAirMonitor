package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.User;

import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */

public interface IUserService {

    int addUser(User user);

    int deleteUser(User user);

    int updateUser(User user);

    User queryUsersById(User user);

    List<User> queryAllUsersByRole(User user);

    User checkUserByPwd(User user);

}
