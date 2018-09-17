package com.acme.code.gen.v2;

import com.acme.code.gen.entity.TableDesc;

import java.util.HashMap;
import java.util.Map;

import static com.acme.code.gen.config.CodeGenerationConfig.*;
import static com.acme.code.gen.config.TemplateConfig.*;

/**
 * @author H
 */
public class JavaCodeFactory extends AbstractCodeFactory {

    private Map<String, String> ftl2PackageMapping = new HashMap<>();

    {
        ftl2PackageMapping.put(FTL_DOMAIN, PACKAGE_DOMAIN_NAME);
        ftl2PackageMapping.put(FTL_DTO, PACKAGE_DTO_NAME);
        ftl2PackageMapping.put(FTL_CONTROLLER, PACKAGE_CONTROLLER_NAME);
        ftl2PackageMapping.put(FTL_SERVICE, PACKAGE_SERVICE_NAME);
        ftl2PackageMapping.put(FTL_SERVICE_IMPL, PACKAGE_SERVICE_IMPL_NAME);
        ftl2PackageMapping.put(FTL_DAO, PACKAGE_DAO_NAME);
        ftl2PackageMapping.put(FTL_DAO_IMPL, PACKAGE_DAO_IMPL_NAME);
        ftl2PackageMapping.put(FTL_MAPPER_CLASS, PACKAGE_MAPPER_NAME);
    }

    @Override
    public JavaTemplateCode createTemplateCode(String ftlTemplate, TableDesc tableDesc) {
        JavaTemplateCode javaTemplateCode = new JavaTemplateCode();
        javaTemplateCode.setPkg(ftl2PackageMapping.get(ftlTemplate));
        javaTemplateCode.setTableDesc(tableDesc);
        String fileName = getDefaultFileName(ftlTemplate, tableDesc, SUFFIX_JAVA);
        javaTemplateCode.setFileName(fileName);
        javaTemplateCode.setTemplateName(ftlTemplate);
        return javaTemplateCode;
    }

}
