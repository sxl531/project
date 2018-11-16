package com.project.dao;

import com.project.entity.SysUserRole;

import java.util.List;

public interface TbSysUserRoleMapper {
    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    List<SysUserRole> findBySysUserId(int userId);
}