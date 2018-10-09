package com.project.dao;

import com.project.entity.FunctionRole;

public interface TbFunctionRoleMapper {
    int insert(FunctionRole record);

    int insertSelective(FunctionRole record);
}