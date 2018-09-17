package com.z.tech.core.json;

/**
 * @author H
 */
public class UniformJSONObject {
    private String message;
    private Object data;
    private Integer code;
    private Boolean success;


    public UniformJSONObject() {
        this("",null,200,true);
    }

    public UniformJSONObject(Object data) {
        this("",data,200,true);
    }

    public UniformJSONObject(String message, Integer code, Boolean success) {
        this(message,null,code,success);
    }

    public UniformJSONObject(String message, Object data, Integer code, Boolean success) {
        this.message = message;
        this.data = data;
        this.code = code;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}

