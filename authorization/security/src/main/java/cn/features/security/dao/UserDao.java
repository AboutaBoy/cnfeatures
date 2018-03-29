package cn.features.security.dao;

import cn.features.security.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户dao层
 *
 * @author limouren
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户组id查询用户
     *
     * @param groupId 用户组id
     * @return 返回用户
     */
    List<User> listUserByGroup(String groupId);

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
     * @return 新增个数
     */
    int addUser(User user);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 返回删除个数
     */
    int removeUserById(String id);

}
