package cn.features.common.service;

import cn.features.common.model.Role;

import java.util.List;

/**
 * 角色服务
 *
 * @author limouren
 */
public interface RoleService {

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    List<Role> listRoleByUserId(String userId);

}
