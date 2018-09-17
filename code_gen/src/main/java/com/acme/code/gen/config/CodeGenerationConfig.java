package com.acme.code.gen.config;

import java.io.File;

/**
 * @author H
 */
public class CodeGenerationConfig {

    public static final String PROJECT_ROOT = "D:\\my_code\\auto_project\\app";
    public static final String SRC_ROOT = "src\\main\\java";
    public static final String RESOURCE_ROOT = "src\\main\\resources";

    public static final String SUFFIX_JAVA = ".java";
    public static final String SUFFIX_XML = ".xml";

    public static final String AUTHOR = "Heaven.Zheng";

    public static final String BASE_PACKAGE_NAME = "com.project.demo";

    public static final String PACKAGE_SPLITTER = ".";
    public static final String PATH_SPLITTER = File.separator;

    public static final String PACKAGE_IMPL_NAME = "impl";
    public static final String PACKAGE_DOMAIN_NAME = "domain";
    public static final String PACKAGE_DTO_NAME = "dto";
    public static final String PACKAGE_SERVICE_NAME = "service";
    public static final String PACKAGE_SERVICE_IMPL_NAME = PACKAGE_SERVICE_NAME+PACKAGE_SPLITTER+PACKAGE_IMPL_NAME;
    public static final String PACKAGE_CONTROLLER_NAME = "controller";
    public static final String PACKAGE_DAO_NAME = "dao";
    public static final String PACKAGE_DAO_IMPL_NAME = PACKAGE_DAO_NAME+PACKAGE_SPLITTER+PACKAGE_IMPL_NAME;
    public static final String PACKAGE_MAPPER_NAME = "mapper";


}
