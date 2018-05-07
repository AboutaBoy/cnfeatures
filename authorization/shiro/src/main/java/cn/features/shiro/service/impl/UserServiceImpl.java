package cn.features.shiro.service.impl;

import cn.features.common.model.User;
import cn.features.shiro.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Override
    public User getUserByName(String name) {
        return null;
    }

    @Override
    public List<User> listUserByGroup(String groupId) {
        return null;
    }
}
