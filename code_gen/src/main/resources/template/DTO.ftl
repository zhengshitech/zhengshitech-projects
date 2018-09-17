package ${base_package_name}.dto;

import com.project.core.base.dto.BaseDTO;
import java.io.Serializable;

import java.time.LocalDateTime;

/**
* 描述：${table_remarks}
* @author ${author}
* @date ${date}
*/
public class ${base_class_name}DTO implements Serializable,BaseDTO{

    private static final long serialVersionUID =${serial_version_uid};

<#if columns?exists>
<#list columns as model>
    /**
    *${model.remarks!}
    */
    private ${model.javaFieldType} ${model.javaFieldName?uncap_first};
</#list>
</#if>

<#if columns?exists>
<#list columns as model>
    public ${model.javaFieldType} get${model.javaFieldName?cap_first }() {
        return this.${model.javaFieldName?uncap_first};
    }
    public void set${model.javaFieldName?cap_first}(${model.javaFieldType} ${model.javaFieldName?uncap_first}) {
        this.${model.javaFieldName?uncap_first} = ${model.javaFieldName?uncap_first};
    }
</#list>
    @Override
    public String toString() {
        return super.toString();
    }
</#if>

}