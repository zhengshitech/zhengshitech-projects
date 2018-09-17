package com.z.tech.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author H
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -1896294459234508267L;


    @ApiModelProperty(value = "主键", allowEmptyValue = true)
    private Integer id;


    @ApiModelProperty(value = "租户ID")
    private Integer tenantId;

    @NotNull(message = "名称不能为空")
    @Length(min = 1, max = 16, message = "名称长度不正确")
    @ApiModelProperty("名称")
    private String name;

    @NotNull(message = "电话号码不能为空")
    @Length(min = 11, max = 11, message = "电话号码长度不正确")
    @ApiModelProperty("电话号码")
    private String phone;

    @Length(min = 18, max = 18, message = "身份证号码长度不正确")
    @ApiModelProperty(value = "身份证号码", allowEmptyValue = true)
    private String idnumber;


    @NotNull(message = "密码不能为空")
    @Length(min = 6, max = 128, message = "密码长度不正确")
    @ApiModelProperty("密码")
    private String password;

    @Length(min = 6, max = 32, message = "加密因子长度不正确")
    @ApiModelProperty(value = "加密因子", allowEmptyValue = true)
    private String passwordKey;

    @NotNull(message = "用户类型不能为空")
    @ApiModelProperty(value = "用户类型")
    private Integer type;

    @Length(max = 128, message = "头像长度不正确")
    @ApiModelProperty(value = "头像", allowEmptyValue = true)
    private String portrait;

    @NotNull(message = "部门ID不能为空")
    @ApiModelProperty(value = "部门ID")
    private Integer departmentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordKey() {
        return passwordKey;
    }

    public void setPasswordKey(String passwordKey) {
        this.passwordKey = passwordKey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", tenantId=" + tenantId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", password='" + password + '\'' +
                ", passwordKey='" + passwordKey + '\'' +
                ", type=" + type +
                ", portrait='" + portrait + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
