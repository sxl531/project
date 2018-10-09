package com.project.dao;

import com.project.entity.SysMenu;

public interface TbSysMenuMapper {
    int insert(SysMenu record);

    int insertSelective(SysMenu record);
}