package com.project.dao;

import com.project.entity.SysRole;

import java.util.List;

public interface TbSysRoleMapper {
    int insert(SysRole record);

    int insertSelective(SysRole record);

    List<SysRole> findRolesByUserId(int userId);
}