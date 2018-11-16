package com.project.exceptions;

import com.project.util.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);


    //声明要捕获的异常
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResponse defultExcepitonHandler(HttpServletRequest request, Exception e) {
        logger.error("",e);
        return JsonResponse.error(null,"error");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NullValueException.class)
    @ResponseBody
    public JsonResponse nullValueExceptionHandler(HttpServletRequest request, Exception e) {
        return JsonResponse.error(null,"必填项为空");
    }
}
