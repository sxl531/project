package com.project.service.impl;


import com.project.dao.TbDepartmentsMapper;
import com.project.entity.DepartmentInfo;
import com.project.service.IDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartServiceImpl implements IDepartService {

    @Autowired
    TbDepartmentsMapper departmentsMapper;

    @Override
    public DepartmentInfo selectDepartmentById(int id) {
        return departmentsMapper.selectByPrimaryKey(id);
    }
}
