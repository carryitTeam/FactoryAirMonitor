package com.carryit.base.fam.service;

import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.dao.UserDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hlzou on 2018/2/27.
 */

@Service("userService")
public class UserService implements IUserService{

    @Resource
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userDao.deleteUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User queryUsersById(User user) {
        return userDao.queryUsersById(user);
    }

    @Override
    public List<User> queryAllUsersByRole(User user) {
        return userDao.queryAllUsersByRole(user);
    }

    @Override
    public User checkUserByPwd(User user) {
        return userDao.checkUserByPwd(user);
    }
}
