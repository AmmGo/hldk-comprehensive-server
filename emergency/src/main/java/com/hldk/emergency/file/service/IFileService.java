package com.hldk.emergency.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Administrator
 */
public interface IFileService {
    /**
     * 获取文件命名
     *
     * @param sourceName
     * @return
     */
    String getFileName(String sourceName);


    /**
     * 获取文件命名
     *
     * @param sourceName
     * @param fileName
     * @return
     */
    String getFileName(String sourceName, String fileName);

    /**
     * 写入文件
     *
     * @param file
     * @return
     * @throws IOException
     */
    String writeFileAndReturnFileName(MultipartFile file) throws IOException;


    /**
     * 根据路径删除指定的目录或文件，无论存在与否
     *
     * @param sPath 要删除的目录或文件
     * @return 删除成功返回 true，否则返回 false。
     */
    boolean deleteFolder(String sPath);

    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    boolean deleteFile(String sPath);


    /**
     * 删除目录（文件夹）以及目录下的文件
     * @param   sPath 被删除目录的文件路径
     * @return  目录删除成功返回true，否则返回false
     */
    boolean deleteDirectory(String sPath);
}
