package com.z.tech.rbac.enums;

public enum UserType {

    UNKNOWN(0, "未知"),
    ADMIN(1, "管理员"),
    GUEST(2, "游客");

    UserType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
