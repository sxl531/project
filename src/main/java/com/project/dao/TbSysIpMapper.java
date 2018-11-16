package com.project.dao;

import com.project.entity.SysIp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbSysIpMapper {
    int insert(SysIp record);

    int insertSelective(SysIp record);

    List<SysIp> selectByIp(@Param("ip") String ip);
}