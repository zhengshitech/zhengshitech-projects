package com.acme.code.gen;

import com.acme.code.gen.entity.TableDesc;
import com.acme.code.gen.util.LogUtil;
import com.acme.code.gen.util.MetaDataReadUtil;
import com.acme.code.gen.v2.AbstractCodeFactory;
import com.acme.code.gen.v2.AbstractTemplateCode;
import com.acme.code.gen.v2.JavaCodeFactory;
import com.acme.code.gen.v2.XmlCodeFactory;
import org.apache.commons.lang3.time.StopWatch;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.acme.code.gen.config.TemplateConfig.FTL_MAPPER_XML;
import static com.acme.code.gen.config.TemplateConfig.getJavaTemplates;

/**
 * @author H
 */
public class Application {
    public static void main(String[] args) {
        AbstractCodeFactory javaCodeFactory = new JavaCodeFactory();
        AbstractCodeFactory xmlCodeFactory = new XmlCodeFactory();
        Map<String, TableDesc> tablesMap = MetaDataReadUtil.readTablesInfo();
        StopWatch stopWatch = new StopWatch();
        for (Map.Entry<String, TableDesc> entry : tablesMap.entrySet()) {
            TableDesc table = entry.getValue();
            stopWatch.start();
            //生成java文件
            for (String template : getJavaTemplates()) {
                AbstractTemplateCode javaTemplate = javaCodeFactory.createTemplateCode(template, table);
                javaTemplate.writeCode();
            }
            //生成xml文件
            AbstractTemplateCode xmlTemplate = xmlCodeFactory.createTemplateCode(FTL_MAPPER_XML, table);
            xmlTemplate.writeCode();

            LogUtil.log("[" + stopWatch.getTime(TimeUnit.MILLISECONDS) + "ms] 生成[" + table.getName() + "]代码完成");
            stopWatch.reset();
        }
    }

}
