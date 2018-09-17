package com.z.tech.rbac.enums;

/**
 * @author H
 */

public enum ResourceType {

    UNKNOWN(0, "未知"),
    MENU(1, "菜单"),
    BUTTON(2, "按钮");

    ResourceType(int code, String name) {
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
