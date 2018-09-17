package com.acme.code.gen.v2;

import static com.acme.code.gen.config.CodeGenerationConfig.*;
import static com.acme.code.gen.config.CodeGenerationConfig.PATH_SPLITTER;

/**
 * @author H
 */
public class XmlTemplateCode extends AbstractTemplateCode implements TemplateCodeWriter {
    @Override
    public void writeCode() {
        String javaFilePath = getXmlFilePath(getFileName());
        super.writeFile(javaFilePath, getDataMap());
    }


    private String getXmlFilePath(String targetFileName) {
        String dir = PROJECT_ROOT + PATH_SPLITTER + RESOURCE_ROOT + PATH_SPLITTER + PACKAGE_MAPPER_NAME;
        super.checkOrCreateDir(dir);
        return (dir + PATH_SPLITTER + targetFileName);
    }
}
