package com.project.exceptions;

public enum UserExceptionEnum {

    E_USER_NOT_FOUND(1,"用户不存在"),
    E_USER_IP_FORBIDDEN(2,"用户ip受限"),
    E_USER_FORBIDDEN(3,"用户禁用"),
    E_LOGIN_TIME_FORBIDDEN(4,"用户登录时间受限"),
    E_LOGIN_INFO_ERROR(5,"登录名密码错误"),
    E_USER_ROLE_NOT_FOUND(6,"用户角色不存在")
    ;


    public static final int USER_NOT_FOUND=1;
    public static final int USER_IP_FORBIDDEN=2;
    public static final int USER_FORBIDDEN=3;
    public static final int LOGIN_TIME_FORBIDDEN=4;
    public static final int LOGIN_INFO_ERROR=5;
    public static final int USER_ROLE_NOT_FOUND=6;


    UserExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(int code) {
       String msg="";
        for(UserExceptionEnum enums:UserExceptionEnum.values()){
            if(enums.getCode()==code){
                msg=enums.getMsg();
            }
        }
       return  msg;
    }
}
