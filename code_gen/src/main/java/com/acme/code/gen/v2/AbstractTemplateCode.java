package com.acme.code.gen.v2;

import com.acme.code.gen.entity.TableDesc;
import com.acme.code.gen.util.FreeMarkerTemplateUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static com.acme.code.gen.config.CodeGenerationConfig.AUTHOR;
import static com.acme.code.gen.config.CodeGenerationConfig.BASE_PACKAGE_NAME;
import static com.acme.code.gen.config.TemplateConfig.*;
import static com.acme.code.gen.util.StringKitUtil.replaceUnderLineAndUpperCase;

/**
 * @author H
 */
public abstract class AbstractTemplateCode {

    private TableDesc tableDesc;
    private String fileName;
    private String templateName;


    /**
     * 写出文件
     *
     * @param filePath 文件路径
     * @param dataMap  参数
     */
    void writeFile(String filePath, Map<String, Object> dataMap) {
        try {
            File file = new File(filePath);
            Template template = FreeMarkerTemplateUtil.getTemplate(getTemplateName());
            FileOutputStream fos = new FileOutputStream(file);
            Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
            template.process(dataMap, out);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写出代码
     */
    public abstract void writeCode();

    /**
     * 检查目录，如果不存在则创建目标目录
     *
     * @param checkDir 检查目录
     */
    void checkOrCreateDir(String checkDir) {
        File targetFolder = new File(checkDir);
        if (!targetFolder.exists()) {
            boolean mkdirs = targetFolder.mkdirs();
            if (mkdirs) {
                //System.out.println("CREATE DIR:" + checkDir);
            }
        }
    }

    /**
     * 获取模板参数
     *
     * @return 模板参数
     */
    public Map<String, Object> getDataMap() {
        Map<String, Object> dataMap = new HashMap<>(9);
        dataMap.put(TAG_TABLE_REMARKS, tableDesc.getRemarks());
        dataMap.put(TAG_AUTHOR, AUTHOR);
        dataMap.put(TAG_DATE, LocalDateTime.now());
        dataMap.put(TAG_TABLE_NAME, tableDesc.getName());
        dataMap.put(TAG_BASE_CLASS_NAME, replaceUnderLineAndUpperCase(tableDesc.getName()));
        dataMap.put(TAG_COLUMNS, tableDesc.getColumns());
        dataMap.put(TAG_SERIAL_VERSION_UID, System.nanoTime() + "L");
        dataMap.put(TAG_BASE_PACKAGE_NAME, BASE_PACKAGE_NAME);
        dataMap.put(TAG_COLUMNS_SIZE, tableDesc.getColumns().size());

        return dataMap;
    }


    // ===================================== getter & setter

    String getFileName() {
        return fileName;
    }

    void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String getTemplateName() {
        return templateName;
    }

    void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    void setTableDesc(TableDesc tableDesc) {
        this.tableDesc = tableDesc;
    }


}
