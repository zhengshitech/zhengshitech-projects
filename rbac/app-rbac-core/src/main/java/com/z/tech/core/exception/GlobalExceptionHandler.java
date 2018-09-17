package com.z.tech.core.exception;

import com.z.tech.core.exception.BizException;
import com.z.tech.core.json.UniformJSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author H
 */
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(BizException.class)
    @ResponseBody
    public UniformJSONObject biz(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        BizException bizException = (BizException) ex;
        UniformJSONObject json = new UniformJSONObject();
        json.setCode(bizException.getCode());
        json.setMessage(bizException.getMsg());
        json.setSuccess(false);
        return json;
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public UniformJSONObject unknown(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        UniformJSONObject json = new UniformJSONObject();
        json.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        json.setMessage(ex.getMessage());
        json.setSuccess(false);
        return json;
    }
}
