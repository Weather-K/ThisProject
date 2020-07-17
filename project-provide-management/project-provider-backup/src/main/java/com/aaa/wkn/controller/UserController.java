package com.aaa.wkn.controller;

import com.aaa.wkn.base.BaseService;
import com.aaa.wkn.base.CommonController;
import com.aaa.wkn.base.ResultData;
import com.aaa.wkn.model.User;
import com.aaa.wkn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * @author Weather
 * @Company AAA德云社
 * @date 2020/7/10 9:15
 */
@RestController
public class UserController extends CommonController <User>  {
    @Autowired
    private UserService userService;

    @Override
    public BaseService<User> getBaseService() {
        return userService;
    }

    @PostMapping("/add")
    public ResultData add(User user) {
        return userService.insertDta(user);
    }

    @PostMapping("/add")
    public ResultData selectAllRoles() {
        return userService.selectAllRoles();
    }
}
