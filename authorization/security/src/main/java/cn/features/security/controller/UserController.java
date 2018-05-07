package cn.features.security.controller;

import cn.features.common.model.User;
import cn.features.security.model.LoginParam;
import cn.features.security.service.UserService;
import cn.features.security.vo.UserUpVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    private AuthenticationManager authenticationManager;

    @PostMapping(value = "/add")
    public void addUser(@RequestBody UserUpVo user) {
        userService.addUser(user);
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> listUserByGroupId(
            @RequestParam(value = "groupId") String groupId) {
        return userService.listUserByGroup(groupId);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void loginUser(
            @RequestBody LoginParam loginParam) {

    }

}
