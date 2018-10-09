package com.project.dao;

import com.project.entity.DepartmentInfo;

public interface TbDepartmentsMapper {
    int insert(DepartmentInfo record);

    int insertSelective(DepartmentInfo record);
}