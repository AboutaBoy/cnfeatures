package cn.features.common.service;


import cn.features.common.model.Authorization;

import java.util.List;

/**
 * 权限服务
 *
 * @author limouren
 */
public interface AuthorizationService {

    /**
     * 根据角色ID查询权限
     *
     * @param roleId 角色ID
     * @return 返回权限列表
     */
    List<Authorization> listAuthorizationByRoleId(String roleId);

}
