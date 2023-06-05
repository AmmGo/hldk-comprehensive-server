package generator.utils;

import com.hldk.common.util.core.DateUtil;
import com.hldk.common.util.core.JsonUtil;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class WriteUtil {

    public static void writerJava(String filePath, String fileName,String tempLateName, Object object){
        String content = getContent(tempLateName, object);
        writer(filePath,fileName,content);
    }

    private static String getContent(String tempLateName,Object object) {
        try {
            String objectJson = JsonUtil.toJSON(object);
            Map map = JsonUtil.parse(objectJson, HashMap.class);
            return FreemarkerUtils.getTemplate(tempLateName, map);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    public static void writer(String filePath, String fileName, String content) {
        File dir  = new File(filePath);
        if (!dir.exists()) {// 判断目录是否存在
            dir.mkdirs();  //多层目录需要调用mkdirs
        }
        File file = new File(filePath, fileName);
        try {
            FileUtils.write(file, content, "utf-8");
            System.out.println("写入文件::"+filePath+"===>"+fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getFileName(String name,String suffix){

        Date date = new Date();
        String format = DateUtil.format(date, "yyyy/MM/dd");
        String fileName =  format+ "/" + name+ DateUtil.format(new Date(),"yyyy-MM-dd.")+suffix;
        return fileName;
    }
}
