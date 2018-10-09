package com.project.service.impl;

import com.project.dao.TbSysUserMapper;
import com.project.entity.SysUser;
import com.project.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    public SysUser findUserByLoginName(String loginName) {
        List<SysUser> list=tbSysUserMapper.findSysUserByLoginName(loginName);
        if(list == null){
            return null;
        }
        return list.get(0);
    }
}
