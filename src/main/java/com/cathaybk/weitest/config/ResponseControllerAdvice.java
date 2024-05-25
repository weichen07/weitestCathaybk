package com.cathaybk.weitest.config;


import com.cathaybk.weitest.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;



@Configuration
@ControllerAdvice(basePackages = "com.cathaybk.weitest.controller")
@Slf4j
public class ResponseControllerAdvice {


    @ExceptionHandler
    @ResponseBody
    Response handleControllerException(HttpServletRequest request, Throwable ex) {
    	log.error(request.getQueryString(), ex);
        if (ex instanceof IllegalArgumentException) {
            return Response.fail(ex.getMessage());
        } else if (ex instanceof MethodArgumentTypeMismatchException) {
            return Response.fail("參數格式錯誤");
        } else if (ex instanceof ServletRequestBindingException) {
            return Response.fail("缺少必要參數");
        } else if (ex instanceof DuplicateKeyException) {
            return Response.fail("已存在相同數據");
        }
        HttpStatus status = getStatus(request);
        return Response.fail(status.value() + ": " + status.getReasonPhrase());

    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
