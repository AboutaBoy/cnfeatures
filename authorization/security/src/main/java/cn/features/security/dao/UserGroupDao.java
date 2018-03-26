package cn.features.security.dao;

import cn.features.security.model.UserGroup;
import cn.features.security.po.UserGroupPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户组
 *
 * @author limouren
 */
@Mapper
public interface UserGroupDao {

    /**
     * 根据用户ID查询所有用户组信息,用户id不传返回全部用户组信息
     *
     * @param userId 用户id
     * @return 返回用户组
     */
    List<UserGroupPo> listUserGroup(String userId);

    /**
     * 根据用户ID查询用户组信息,一个用户可能有多个组
     *
     * @param userId 用户ID
     * @return 返回用户组信息
     */
    List<UserGroup> getUserGroupByUserId(String userId);

    /**
     * 新增用户组
     *
     * @param userGroup 用户组
     * @return 返回新增个数
     */
    int addUserGroup(UserGroup userGroup);

    /**
     * 删除用户组
     *
     * @param id 用户组ID
     * @return 返回删除条数
     */
    int removeUserGroup(String id);

}
