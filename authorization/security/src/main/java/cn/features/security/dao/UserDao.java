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
     * @param name 用户名
     * @param groupId 用户组
     * @return 返回用户信息
     */
    User getUserByName(String name, String groupId);

    /**
     * 新增用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int removeUserById(String id, String groupId);

}
