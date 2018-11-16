package com.project.controller;

import com.project.entity.*;
import com.project.exceptions.NullValueException;
import com.project.exceptions.UserException;
import com.project.exceptions.UserExceptionEnum;
import com.project.service.*;
import com.project.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 系统登录
 */
@RestController
@Api("logincontroller")
public class LoginController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysIpService sysIpService;
    @Autowired
    private ILoginControlService loginControlService;
    @Autowired
    private IDepartService departService;
    @Autowired
    private ISysRoleService roleService;
    @Autowired
    private ISysMenuService menuService;
    @Autowired
    private ISysFunctionService functionService;

    @ApiOperation(value = "login",notes = "登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginName" ,value = "登录名",required = false),
            @ApiImplicitParam(name = "password" ,value = "密码",required = false)
    })
    @RequestMapping("/login")
    public JsonResponse userLogin(HttpServletRequest request, @RequestParam("loginName") String loginName,@RequestParam("password")  String password){

        if(ToolsUtil.isNull(loginName) || ToolsUtil.isNull(password)){
            throw new NullValueException();
        }

        //获取用户信息
        SysUser sysUser=userService.findUserByLoginName(loginName);
        if(sysUser == null){
            throw new UserException(UserExceptionEnum.USER_NOT_FOUND);
        }

        //判断用户登录ip限制
        String ip=IpUtil.getIpAddress(request);
        List<SysIp> ipList=sysIpService.findByIp(ip);
        if(!(ipList != null && ipList.size() > 0)){
            throw new UserException(UserExceptionEnum.USER_IP_FORBIDDEN);
        }

        //判断用户是否启用
        if (sysUser.getDeleteFlag() == 1){
            throw new UserException(UserExceptionEnum.USER_FORBIDDEN);
        }

        //判断用户登录时间
        if(sysUser.getLoginTimeControl() != 0){
            SimpleDateFormat df = new SimpleDateFormat("HH:mm");
            String nowTime = df.format(new Date());
            SysLoginTimeControl loginTimeControl=loginControlService.selectById(sysUser.getLoginTimeControl());
            if(loginTimeControl != null){
                if(!(loginTimeControl.getStartTime().compareTo(nowTime) < 0 && loginTimeControl.getEndTime().compareTo(nowTime) > 0)){
                    throw new UserException(UserExceptionEnum.LOGIN_TIME_FORBIDDEN );
                }
            }
        }


        //判断部门是否启用
        DepartmentInfo departmentInfo=departService.selectDepartmentById(sysUser.getDepartId());
        if(departmentInfo == null ){
            return JsonResponse.error(null,"用户部门信息有误");
        }
        if(departmentInfo.getDeleted() == 1){
            return JsonResponse.error(null,"用户部门已禁用");
        }


        //验证用户名，密码
        if(!MD5.MD5Encrypt(password).equals(sysUser.getPassword())){
            return  JsonResponse.error(null,"用户密码错误");
        }

        //用户信息放入session
        HttpSession session=request.getSession();
        session.setAttribute("department",departmentInfo);
        session.setAttribute("user",sysUser);

        return JsonResponse.success();
    }

    @RequestMapping("/logout")
    @ResponseBody
    public JsonResponse userLogin(HttpServletRequest request){
        HttpSession session=request.getSession();
        if(session != null){
            session.removeAttribute("user");
            session.removeAttribute("department");
        }
        return JsonResponse.success();
    }

    /*public static void test(String args[]) throws Exception {
        JaxWsDynamicClientFactory FACTORY = JaxWsDynamicClientFactory.newInstance();//1，获取一个工厂实例

        Client client = FACTORY.createClient("http://localhost:10008/xj/check/checkService?wsdl");//2，生成针对指定服务接口URL的客户端
        SysUser user=new SysUser();
        user.setId(2);
        user.setCreateTime(new Date());
        Object[] objs = client.invoke("check",JaxbUtil.convertToXml(user));//3，调用指定的方法，注意入参第一个为方法名称，第二个为方法的参数（可以传入一个参数列表，一般为数组）
        System.out.print(objs[0].toString());
    }*/

}
