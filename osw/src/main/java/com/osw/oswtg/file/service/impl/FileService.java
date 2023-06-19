package com.osw.oswtg.file.service.impl;

import com.osw.oswtg.config.Config;
import com.osw.oswtg.file.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class FileService implements IFileService {

    @Resource
    private Config config;

    @Override
    public String getFileName(String sourceName) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String format = simpleDateFormat.format(new Date());
        String string = UUID.randomUUID().toString();
        String ext = sourceName.substring(sourceName.lastIndexOf("."));
        String fileName = format + "/" + string + ext;
        return fileName;
    }

    @Override
    public String getFileName(String sourceName, String fileName) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String format = simpleDateFormat.format(new Date());
        String string = UUID.randomUUID().toString();
        String ext = sourceName.substring(sourceName.lastIndexOf("."));
        if (StringUtils.isBlank(fileName)){
            return format + "/" + string + ext;
        }else{
            return format + "/" +fileName+"/"+string + ext;
        }
    }

    @Override
    public String writeFileAndReturnFileName(MultipartFile file) throws IOException {
        if (file == null) {
            return "";
        }
        String filePath = config.getFilePath();
        String fileName = getFileName(file.getOriginalFilename());
        log.info(filePath);
        File file1 = new File(filePath, fileName);
        if (!file1.getParentFile().exists()) {
            file1.getParentFile().mkdirs();
        }
        file.transferTo(new File(filePath, fileName));
        return fileName;
    }

    @Override
    public boolean deleteFolder(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }

    @Override
    public boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;

    }

    @Override
    public boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) {
                    break;
                }
            }
        }
        if (!flag) {
            return false;
        }
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
}
