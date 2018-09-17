package com.z.tech.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author H
 */
public class ApplicationDTO implements Serializable {

    private static final long serialVersionUID = -1896294459234508267L;


    @ApiModelProperty(value = "主键", allowEmptyValue = true)
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(min = 1, max = 64, message = "名称长度不正确")
    @ApiModelProperty("名称")
    private String name;

    @Length(min = 32, max = 32, message = "应用代码长度不正确")
    @ApiModelProperty("应用代码")
    private String appKey;

    @Length(max = 128, message = "应用图标长度不正确")
    @ApiModelProperty(value = "应用图标", allowEmptyValue = true)
    private String icon;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "ApplicationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appKey='" + appKey + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
