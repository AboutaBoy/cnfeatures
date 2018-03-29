package cn.features.security.service;

import cn.features.security.vo.UserUpVo;
import cn.features.security.model.User;

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
     * 新增用户
     *
     * @param user 用户
     * @return 返回新增个数
     */
    int addUser(UserUpVo user);

    /**
     * 根据用户组id查询用户
     *
     * @param groupId 用户组id
     * @return 返回用户
     */
    List<User> listUserByGroup(String groupId);

}
