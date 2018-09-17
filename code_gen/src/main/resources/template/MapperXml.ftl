<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${base_package_name}.mapper.${base_class_name}Mapper">
    <resultMap type="${base_class_name}Domain" id="default${base_class_name}Domain">
    <#if columns?exists>
    <#list columns as model>
        <#if (model.columnName = 'id')>
            <id column="id" property="id"/>
        <#else>
            <result column="${model.columnName}" property="${model.javaFieldName?uncap_first}"/>
        </#if>
    </#list>
    </#if>
    </resultMap>

    <select id="selectById" parameterType="Long" resultType="${base_class_name}Domain">
        select * from `${table_name}` where id = ${r"#{id}"} and s=1
    </select>

    <select id="selectByIds" parameterType="Long" resultType="${base_class_name}Domain">
        select * from `student` where s=1 and id IN
        <foreach item="item" index="index" collection="list"
                 open="(" separator="," close=")">
        ${r"#{item}"}
        </foreach>
    </select>

    <insert id="add" parameterType="${base_class_name}Domain" useGeneratedKeys="true" keyProperty="id">
        insert into `student`(
            <#if columns?exists>
                <#list columns as model>
                    ${model.columnName}<#if model_has_next>,</#if>
                </#list>
            </#if>
        )
        values(
            <#if columns?exists>
                <#list columns as model>
                    ${r"#{"}${model.javaFieldName?uncap_first}${r"}"}<#if model_has_next>,</#if>
                </#list>
            </#if>
        )
    </insert>

    <update id="update" parameterType="${base_class_name}Domain">
        update `student` set
        <#if columns?exists>
        <#list columns as model>
        <#if (model.columnName != 'id')>
            ${model.columnName}=${r"#{"}${model.javaFieldName?uncap_first}${r"}"}<#if model_has_next>,</#if>
        </#if>
        </#list>
        </#if>
        where id=${r"#{id}"}
    </update>

    <update id="deleteById" parameterType="Long">
        update `student` set s=2  where id=${r"#{id}"}
    </update>


</mapper>