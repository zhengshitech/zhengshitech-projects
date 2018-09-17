package com.acme.code.gen.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;

import static com.acme.code.gen.config.TemplateConfig.FTL_TEMPLATE_ENCODING;
import static com.acme.code.gen.config.TemplateConfig.FTL_TEMPLATE_PATH;


/**
 * @author H
 */
public class FreeMarkerTemplateUtil {

    private FreeMarkerTemplateUtil() {
    }

    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);


    static {
        //这里比较重要，用来指定加载模板所在的路径
        CONFIGURATION.setTemplateLoader(new ClassTemplateLoader(FreeMarkerTemplateUtil.class, FTL_TEMPLATE_PATH));
        CONFIGURATION.setDefaultEncoding(FTL_TEMPLATE_ENCODING);
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    public static Template getTemplate(String templateName) throws IOException {
        try {
            return CONFIGURATION.getTemplate(templateName);
        } catch (IOException e) {
            throw e;
        }
    }

    public static void clearCache() {
        CONFIGURATION.clearTemplateCache();
    }
}