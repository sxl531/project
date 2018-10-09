package com.project.controller;

import com.project.entity.SysUser;
import com.project.service.ISysUserService;
import com.project.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统登录
 */
@Controller
public class LoginController {

    @Autowired
    private ISysUserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public JsonResponse userLogin(String loginName, String password){

        //获取用户信息
        SysUser sysUser=userService.findUserByLoginName(loginName);
        if(sysUser == null){
            return JsonResponse.error(null,"用户不存在");
        }

        //判断用户登录ip限制

        //判断用户是否启用

        //判断用户登录时间

        //验证用户名，密码

        //获取用户部门，角色

        return JsonResponse.success();
    }

}
