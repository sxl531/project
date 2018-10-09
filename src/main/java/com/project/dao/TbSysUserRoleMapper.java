package com.project.dao;

import com.project.entity.SysUserRole;

public interface TbSysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);
}