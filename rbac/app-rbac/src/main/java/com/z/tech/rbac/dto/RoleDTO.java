package com.z.tech.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author H
 */
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -1896294459234508267L;


    @ApiModelProperty(value = "主键", allowEmptyValue = true)
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(min = 1, max = 64, message = "名称长度不正确")
    @ApiModelProperty("名称")
    private String name;

    @NotNull(message = "角色代码不能为空")
    @Length(min = 1, max = 32, message = "角色代码长度不正确")
    @ApiModelProperty("角色代码")
    private String code;

    @NotNull(message = "应用ID不能为空")
    @ApiModelProperty("应用ID")
    private Integer applicationId;


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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", applicationId=" + applicationId +
                '}';
    }
}
