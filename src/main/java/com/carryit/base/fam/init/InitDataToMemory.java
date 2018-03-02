package com.carryit.base.fam.init;

import com.carryit.base.fam.bean.User;
import com.carryit.base.fam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hlzou on 2018/2/28.
 */

@Component
public class InitDataToMemory {

    @Autowired
    private UserService userService;

    @Autowired
    private ServletContext servletContext;

    public void initUserToMemory(){
        User userRole = new User();
        userRole.setUserRole("user");
        List<User> users = userService.queryAllUsersByRole(userRole);
        userRole.setUserRole("admin");
        List<User> adminUsers = userService.queryAllUsersByRole(userRole);
        users.addAll(adminUsers);

        Map<String,Boolean> userData = new HashMap<>();
        for (User user: users){
            userData.put(user.getUserId()+"_"+user.getAppEui(),false);
        }
        servletContext.setAttribute("userData",userData);
    }
}
