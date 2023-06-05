package generator.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author Administrator
 */
public class FreemarkerUtils {

    public static void main(String[] args) {

        String template = getTemplate("controller.ftl", null);
        System.out.println(template);

    }


    public static String getTemplate(String template, Map<String,Object> map){
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_28);
            cfg.setDirectoryForTemplateLoading(new File(System.getProperty("user.dir")+"\\tools\\gen\\gen-base\\src\\main\\resources\\template"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            Template temp = cfg.getTemplate(template);
            StringWriter stringWriter = new StringWriter();
            temp.process(map, stringWriter);
            return stringWriter.toString();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}