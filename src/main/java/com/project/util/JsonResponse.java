package com.project.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse<T> implements Serializable {
    private boolean success;
    private String error;
    private String msg;
    private T data;


    /**
     * 无参返回成功
     * @return
     */
    public static JsonResponse success(){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setSuccess(true);
        return jsonResponse;
    }


    public static JsonResponse success(String msg){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setSuccess(true);
        jsonResponse.setMsg(msg);
        return jsonResponse;
    }


    public static<T> JsonResponse<T> success(T data){
        JsonResponse<T> jsonResponse=new JsonResponse();
        jsonResponse.setSuccess(true);
        jsonResponse.setData(data);
        return jsonResponse;
    }

    public static JsonResponse error(String errorCode,String errorMsg){
        JsonResponse jsonResponse=new JsonResponse();
        jsonResponse.setSuccess(false);
        jsonResponse.setError(errorCode);
        jsonResponse.setMsg(errorMsg);
        return jsonResponse;
    }



    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
