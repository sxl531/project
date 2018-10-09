package com.project.dao;

import com.project.entity.SysRole;

public interface TbSysRoleMapper {
    int insert(SysRole record);

    int insertSelective(SysRole record);
}