package com.z.tech.rbac.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author H
 */
public class RoleResourceDTO implements Serializable {

    private static final long serialVersionUID = -1896294459234508267L;

    @ApiModelProperty(value = "主键", allowEmptyValue = true)
    private Integer id;

    @NotNull(message = "资源ID不能为空")
    @ApiModelProperty("资源ID")
    private Integer resourceId;

    @NotNull(message = "角色ID不能为空")
    @ApiModelProperty("角色ID")
    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "RoleResourceDTO{" +
                "id=" + id +
                ", resourceId=" + resourceId +
                ", roleId=" + roleId +
                '}';
    }
}
