package com.z.tech.core.exception;

/**
 * @author H
 */
public class BizException extends RuntimeException {
    private Integer code;
    private String msg;

    public BizException(BizCode bizCode) {
        this.code = bizCode.getCode();
        this.msg = bizCode.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
