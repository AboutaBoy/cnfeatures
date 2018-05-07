package cn.features.shiro.service;

import cn.features.common.model.User;

import java.util.List;

/**
 * 用户服务
 *
 * @author limouren
 */
public interface UserService {

    /**
     * 查询当前用户组里的name的用户信息
     *
     * @param name 用户名
     * @return 返回用户信息
     */
    User getUserByName(String name);


    /**
     * 根据用户组id查询用户
     *
     * @param groupId 用户组id
     * @return 返回用户
     */
    List<User> listUserByGroup(String groupId);

}
