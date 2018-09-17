package com.acme.code.gen.config;

import java.util.HashSet;
import java.util.Set;

/**
 * @author H
 */
public class TemplateConfig {


    public static final String FTL_TEMPLATE_PATH = "/template";
    public static final String FTL_TEMPLATE_ENCODING = "UTF-8";


    /**
     * ----------templates-----------------------
     */
    public static final String FTL_DOMAIN = "Domain.ftl";
    public static final String FTL_DTO = "DTO.ftl";
    public static final String FTL_CONTROLLER = "Controller.ftl";
    public static final String FTL_SERVICE = "Service.ftl";
    public static final String FTL_SERVICE_IMPL = "ServiceImpl.ftl";
    public static final String FTL_DAO = "Dao.ftl";
    public static final String FTL_DAO_IMPL = "DaoImpl.ftl";
    public static final String FTL_MAPPER_CLASS = "Mapper.ftl";
    public static final String FTL_MAPPER_XML = "MapperXml.ftl";

    private static Set<String> javaTemplates = new HashSet<>(8);
    public static Set<String> getJavaTemplates() {
        if (javaTemplates.size() == 0) {
            javaTemplates.add(FTL_DOMAIN);
            javaTemplates.add(FTL_DTO);
            javaTemplates.add(FTL_CONTROLLER);
            javaTemplates.add(FTL_SERVICE);
            javaTemplates.add(FTL_SERVICE_IMPL);
            javaTemplates.add(FTL_DAO);
            javaTemplates.add(FTL_DAO_IMPL);
            javaTemplates.add(FTL_MAPPER_CLASS);
        }
        return javaTemplates;
    }


    /**
     * ----------tags-----------------------
     */

    public static final String TAG_BASE_PACKAGE_NAME = "base_package_name";
    public static final String TAG_PACKAGE_NAME = "package_name";
    public static final String TAG_TABLE_REMARKS = "table_remarks";
    public static final String TAG_AUTHOR = "author";
    public static final String TAG_DATE = "date";
    public static final String TAG_TABLE_NAME = "table_name";
    public static final String TAG_BASE_CLASS_NAME = "base_class_name";
    public static final String TAG_COLUMNS = "columns";
    public static final String TAG_COLUMNS_SIZE = "columns_size";
    public static final String TAG_SERIAL_VERSION_UID = "serial_version_uid";

}
