package com.project.service;

import com.project.entity.SysRole;

import java.util.List;

public interface ISysRoleService {

    /**
     * 根据用户id获取角色列表
     * @param sysUserId
     * @return
     */
    List<SysRole> findRolesByUserId(int sysUserId);
}
