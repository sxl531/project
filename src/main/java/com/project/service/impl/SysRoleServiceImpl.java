package com.project.service.impl;

import com.project.dao.TbSysRoleMapper;
import com.project.dao.TbSysUserRoleMapper;
import com.project.entity.SysRole;
import com.project.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements ISysRoleService {
    @Autowired
    private TbSysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> findRolesByUserId(int sysUserId) {
        return sysRoleMapper.findRolesByUserId(sysUserId);
    }
}
