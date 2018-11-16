package com.project.exceptions;

public class UserException extends RuntimeException {

    private int errorCode;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public UserException(int errorCode){
        super(UserExceptionEnum.getMsg(errorCode));
    }
}
