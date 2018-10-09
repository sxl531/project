package com.project.dao;

import com.project.entity.MenuRole;

public interface TbMenuRoleMapper {
    int insert(MenuRole record);

    int insertSelective(MenuRole record);
}