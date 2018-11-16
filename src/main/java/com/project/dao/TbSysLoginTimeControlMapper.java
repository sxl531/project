package com.project.dao;

import com.project.entity.SysLoginTimeControl;

public interface TbSysLoginTimeControlMapper {
    int insert(SysLoginTimeControl record);

    int insertSelective(SysLoginTimeControl record);

    SysLoginTimeControl selectByPrimaryKey(int ids);
}