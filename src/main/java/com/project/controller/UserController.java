package com.project.controller;

import com.project.entity.SysUser;
import com.project.service.ISysUserService;
import com.project.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping("/getUser")
    public JsonResponse getUserInfo(String loginName){
        SysUser list =  sysUserService.findUserByLoginName(loginName);
        return JsonResponse.success(list);
    }

}
