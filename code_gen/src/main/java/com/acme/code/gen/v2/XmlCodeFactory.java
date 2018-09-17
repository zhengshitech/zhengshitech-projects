package com.acme.code.gen.v2;

import com.acme.code.gen.entity.TableDesc;

import static com.acme.code.gen.config.CodeGenerationConfig.SUFFIX_XML;
import static com.acme.code.gen.util.StringKitUtil.replaceUnderLineAndUpperCase;

/**
 * @author H
 */
public class XmlCodeFactory extends AbstractCodeFactory {
    @Override
    public XmlTemplateCode createTemplateCode(String ftlTemplate, TableDesc tableDesc) {
        XmlTemplateCode xmlTemplateCode = new XmlTemplateCode();
        xmlTemplateCode.setTableDesc(tableDesc);
        String fileName = getDefaultFileName(ftlTemplate, tableDesc, SUFFIX_XML);
        xmlTemplateCode.setFileName(fileName);
        xmlTemplateCode.setTemplateName(ftlTemplate);
        return xmlTemplateCode;
    }

    @Override
    String getDefaultFileName(String ftlTemplate, TableDesc tableDesc, String fileSuffix) {
        return replaceUnderLineAndUpperCase(tableDesc.getName()) + fileSuffix;
    }
}
