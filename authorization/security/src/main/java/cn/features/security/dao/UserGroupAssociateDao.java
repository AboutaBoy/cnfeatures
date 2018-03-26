package cn.features.security.dao;

import cn.features.security.model.UserGroupAssociate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserGroupAssociateDao {

    /**
     * 新增用户组中间表
     *
     * @param userGroupAssociate 用户组中间表
     * @return 返回新增个数
     */
    int addUserGroupAssociate(UserGroupAssociate userGroupAssociate);

    /**
     * 移除用户组中间表
     *
     * @param id 中间表ID
     * @return 返回删除个数
     */
    int removeUserGroupAssociate(String id);

    /**
     * 根据用户组ID查询用户组下用户ID
     *
     * @param groupId 用户组id
     * @return 返回用户与用户组中间表信息
     */
    List<UserGroupAssociate> listUserGroupAssociate(String groupId);
}
