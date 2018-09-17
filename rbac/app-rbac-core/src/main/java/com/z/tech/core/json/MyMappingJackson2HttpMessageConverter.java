package com.z.tech.core.json;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;


/**
 * @author H
 */
public class MyMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

    public static final String WEBAPI = "/webapi/";
    public static final String ERROR = "/error";

    @Override
    protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        System.out.println("开始封装成统一数据对象:" + object);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        if (requestURI.startsWith(WEBAPI)) {
            if (object instanceof UniformJSONObject) {
                super.writeInternal(object, type, outputMessage);
            } else {
                UniformJSONObject jsonObject = new UniformJSONObject(object);
                super.writeInternal(jsonObject, type, outputMessage);
            }
        } else if (requestURI.startsWith(ERROR)) {
            UniformJSONObject jsonObject = new UniformJSONObject(object);
            jsonObject.setSuccess(false);
            if (object instanceof LinkedHashMap) {
                LinkedHashMap msg = (LinkedHashMap) object;
                jsonObject.setMessage("" + msg.get("error"));
                jsonObject.setCode(Integer.valueOf("" + msg.get("status")));
            }
            super.writeInternal(jsonObject, type, outputMessage);
        } else {
            super.writeInternal(object, type, outputMessage);
        }
    }
}
