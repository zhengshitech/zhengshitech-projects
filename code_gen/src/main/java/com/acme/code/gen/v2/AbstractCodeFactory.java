package com.acme.code.gen.v2;

import com.acme.code.gen.entity.TableDesc;

import static com.acme.code.gen.util.StringKitUtil.replaceUnderLineAndUpperCase;

/**
 * @author H
 */
public abstract class AbstractCodeFactory {
    /**
     * 创建模板代码
     *
     * @param ftlTemplate ftl模板
     * @param tableDesc   数据库表信息
     * @return 模板代码生成器
     */
    public abstract AbstractTemplateCode createTemplateCode(String ftlTemplate, TableDesc tableDesc);

    /**
     * 默认的文件名
     *
     * @param ftlTemplate ftl模板
     * @param tableDesc   数据库表信息
     * @param fileSuffix  文件后缀名
     * @return 默认文件名
     */
    String getDefaultFileName(String ftlTemplate, TableDesc tableDesc, String fileSuffix) {
        return replaceUnderLineAndUpperCase(tableDesc.getName()) + ftlTemplate.substring(0, ftlTemplate.indexOf("ftl") - 1) + fileSuffix;
    }
}
