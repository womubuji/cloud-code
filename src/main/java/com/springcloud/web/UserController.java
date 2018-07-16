package com.springcloud.web;

import com.springcloud.model.PageBase;
import com.springcloud.model.ResultBase;
import com.springcloud.model.UserInfo;
import com.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wanghonglan on 2018/6/29.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryUserList")
    public PageBase<UserInfo> queryUserList(HttpServletRequest request) {
        UserInfo userInfo = new UserInfo();

        return userService.queryUserList(userInfo);
    }

    @RequestMapping("/addUser")
    public ResultBase addUser(UserInfo userInfo) {
        userService.addUser(userInfo);

        return new ResultBase(true);
    }

    @RequestMapping("/updateUser")
    public ResultBase updateUser(UserInfo userInfo) {
        userService.updateUser(userInfo);

        return new ResultBase(true);
    }

    @RequestMapping("/deleteUser")
    public ResultBase deleteUser(String id) {
        userService.deleteUser(id);

        return new ResultBase(true);
    }
}
