package com.project.service;

import com.project.entity.SysUser;

public interface ISysUserService {

    /**
     * 根据登录名获取系统用户信息
     * @param loginName
     * @return
     */
    SysUser findUserByLoginName(String loginName);


}
