package com.z.tech.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author H
 */
public class TenantDTO implements Serializable {

    private static final long serialVersionUID = -1896294459234508267L;


    @ApiModelProperty(value = "主键", allowEmptyValue = true)
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(min = 1, max = 128, message = "名称长度不正确")
    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty(value = "层级", allowEmptyValue = true)
    private Integer level;

    @ApiModelProperty(value = "上级ID")
    private Integer pid;

    @ApiModelProperty(value = "层级掩码", readOnly = true, allowEmptyValue = true)
    private String mask;


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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }


    @Override
    public String toString() {
        return "TenantDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", pid=" + pid +
                ", mask='" + mask + '\'' +
                '}';
    }

}
