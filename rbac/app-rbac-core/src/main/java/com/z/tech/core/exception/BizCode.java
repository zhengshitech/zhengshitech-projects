package com.z.tech.core.exception;

public enum BizCode {

    OPERATION_DATA_NOT_EXIST(5000001, "操作数据不存在"),
    QUERY_DATA_NOT_EXIST(5000002, "没有查询到数据");

    private int code;
    private String msg;

    BizCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
