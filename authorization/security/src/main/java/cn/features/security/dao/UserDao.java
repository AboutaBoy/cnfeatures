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
     * @param userGroup 用户组id
     * @return 返回用户
     */
    List<User> listUserByGroup(String userGroup);

}
