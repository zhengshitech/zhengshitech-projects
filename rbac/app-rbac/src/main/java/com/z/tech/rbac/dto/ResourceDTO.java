package com.z.tech.rbac.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author H
 */
public class ResourceDTO implements Serializable {

    private static final long serialVersionUID = -1896294459234508267L;


    @ApiModelProperty(value = "主键", allowEmptyValue = true)
    private Integer id;

    @NotNull(message = "名称不能为空")
    @Length(min = 1, max = 64, message = "名称长度不正确")
    @ApiModelProperty("名称")
    private String name;

    @NotNull(message = "资源代码不能为空")
    @Length(min = 1, max = 32, message = "资源代码长度不正确")
    @ApiModelProperty("资源代码")
    private String resourceKey;

    @NotNull(message = "类型不能为空")
    @ApiModelProperty("类型")
    private Integer type;

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

    public String getResourceKey() {
        return resourceKey;
    }

    public void setResourceKey(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "ResourceDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", resourceKey='" + resourceKey + '\'' +
                ", type=" + type +
                ", applicationId=" + applicationId +
                '}';
    }
}
