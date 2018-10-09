package com.project.dao;

import com.project.entity.SysUser;

import java.util.List;

public interface TbSysUserMapper {
    int insert(SysUser record);

    int insertSelective(SysUser record);

    List<SysUser> findSysUserByLoginName(String loginName);
}