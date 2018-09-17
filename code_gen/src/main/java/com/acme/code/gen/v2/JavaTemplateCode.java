package com.acme.code.gen.v2;

import java.util.Map;

import static com.acme.code.gen.config.CodeGenerationConfig.*;
import static com.acme.code.gen.config.TemplateConfig.TAG_PACKAGE_NAME;

/**
 * @author H
 */
public class JavaTemplateCode extends AbstractTemplateCode implements TemplateCodeWriter {
    private String pkg;

    private String getPkg() {
        return pkg;
    }

    void setPkg(String pkg) {
        this.pkg = pkg;
    }

    @Override
    public void writeCode() {
        String javaFilePath = getJavaFilePath(getPkg(), getFileName());
        super.writeFile(javaFilePath, getDataMap());
    }


    @Override
    public Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = super.getDataMap();
        String targetPackage = BASE_PACKAGE_NAME + PACKAGE_SPLITTER + pkg;
        dataMap.put(TAG_PACKAGE_NAME, targetPackage);
        return dataMap;
    }

    private String getJavaFilePath(String relativePackageName, String targetFileName) {
        String relativePath = BASE_PACKAGE_NAME + PACKAGE_SPLITTER + relativePackageName;
        relativePath = relativePath.replace(PACKAGE_SPLITTER, PATH_SPLITTER);
        String dir = PROJECT_ROOT + PATH_SPLITTER + SRC_ROOT + PATH_SPLITTER + relativePath;
        super.checkOrCreateDir(dir);
        return (dir + PATH_SPLITTER + targetFileName);
    }
}
