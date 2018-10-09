package com.project.dao;

import com.project.entity.SysFunction;

public interface TbSysFunctionMapper {
    int insert(SysFunction record);

    int insertSelective(SysFunction record);
}