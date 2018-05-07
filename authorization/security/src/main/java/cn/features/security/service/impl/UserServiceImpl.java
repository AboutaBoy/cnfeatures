package cn.features.security.service.impl;

import cn.features.common.model.User;
import cn.features.common.util.UUIDUtils;
import cn.features.security.model.SecurityUser;
import cn.features.security.vo.UserUpVo;
import cn.features.common.dao.UserDao;
import cn.features.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现层
 *
 * @author limouren
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public SecurityUser getUserByName(String name) {
        return (SecurityUser) userDao.getUserByName(name);
    }

    @Override
    public int addUser(UserUpVo userUpVo) {
        User user = new User();
        user.setId(UUIDUtils.timeBasedStr());
        user.setUserName(userUpVo.getUserName());
        user.setPassword(passwordEncoder.encode(userUpVo.getPassword()));
        return userDao.addUser(user);

    }

    @Override
    public List<User> listUserByGroup(String groupId) {
        return userDao.listUserByGroup(groupId);
    }
}
