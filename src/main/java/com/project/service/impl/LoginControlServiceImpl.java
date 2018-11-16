package com.project.service.impl;

import com.project.dao.TbSysLoginTimeControlMapper;
import com.project.entity.SysLoginTimeControl;
import com.project.service.ILoginControlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginControlServiceImpl implements ILoginControlService {

    @Autowired
    private TbSysLoginTimeControlMapper loginTimeControlMapper;

    @Override
    public SysLoginTimeControl selectById(int id) {
        return loginTimeControlMapper.selectByPrimaryKey(id);
    }
}
