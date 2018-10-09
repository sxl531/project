package com.project.dao;

import com.project.entity.SysIp;

public interface TbSysIpMapper {
    int insert(SysIp record);

    int insertSelective(SysIp record);
}