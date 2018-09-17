package ${base_package_name}.domain;
import com.project.core.base.domain.BaseDomain;

import java.time.LocalDateTime;

/**
* 描述：${table_remarks}
* @author ${author}
* @date ${date}
*/
public class ${base_class_name}Domain extends BaseDomain{

<#if columns?exists>
<#list columns as model>
    /**
    *${model.remarks!}
    *@Column(name = "${model.columnName}")
    */
    private ${model.javaFieldType} ${model.javaFieldName?uncap_first};
</#list>
</#if>

<#if columns?exists>
<#list columns as model>
    <#if (model.columnName = 'id' || model.columnName = 's')>
    @Override
    </#if>
    public ${model.javaFieldType} get${model.javaFieldName?cap_first }() {
        return this.${model.javaFieldName?uncap_first};
    }
    <#if (model.columnName = 'id' || model.columnName = 's')>
    @Override
    </#if>
    public void set${model.javaFieldName?cap_first}(${model.javaFieldType} ${model.javaFieldName?uncap_first}) {
        this.${model.javaFieldName?uncap_first} = ${model.javaFieldName?uncap_first};
    }
</#list>
</#if>

}