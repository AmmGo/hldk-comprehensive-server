package com.hldk.emergency.file.controller;

import com.hldk.common.core.base.BaseServiceController;
import com.hldk.common.core.base.CommonCode;
import com.hldk.common.core.base.ResponseJson;
import com.hldk.emergency.config.Config;
import com.hldk.emergency.file.service.IFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Base64;

/****
 * @project:
 * @create-time: 2020/5/19 14:54
 * @description:
 *****/
@RestController
@RequestMapping("file")
@Slf4j
public class FileController extends BaseServiceController {



    @Resource
    private Config config;
    @Resource
    private IFileService fileService;

    @PostMapping("upload")
    public ResponseJson uploadImage(MultipartFile file){
        try {
            if(file == null){
                return buildErrorResult(CommonCode.PARAMETER_ERROR.getCode(), CommonCode.PARAMETER_ERROR.getValue());
            }
            String fileName = fileService.writeFileAndReturnFileName(file);
            return buildSuccessResult(fileName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return buildErrorResult(CommonCode.SERVER_ERROR.getCode(), CommonCode.SERVER_ERROR.getValue());
        }
    }


    @PostMapping("multiUpload")
    public ResponseJson uploadImages(@RequestParam(value = "files") MultipartFile[]files){
        try {
            if(files == null){
                return buildErrorResult(CommonCode.SERVER_ERROR.getCode(), "未选择任何文件，请用参数files多个文件");
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (MultipartFile file : files) {
                stringBuilder.append(fileService.writeFileAndReturnFileName(file)).append(",");
            }
            return buildSuccessResult(stringBuilder.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return buildErrorResult(CommonCode.SERVER_ERROR.getCode(), CommonCode.SERVER_ERROR.getValue());
        }
    }


    @PostMapping("uploadBase64")
    public ResponseJson uploadBase64Image(@RequestBody String [] list, HttpServletRequest request){
        try {
            if(list == null ||  list.length == 0){
                throw new IllegalArgumentException("文件内容为空");
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (String code : list) {
                code = code.substring(code.indexOf(",") + 1);
                String filePath = config.getFilePath();
                String fileName = fileService.getFileName("1.jpg");
                File file = new File(filePath, fileName);
                stringBuilder.append(fileName).append(",");
                byte[] fileBytes = Base64.getDecoder().decode(code);
                FileUtils.writeByteArrayToFile(file, fileBytes);
            }
            return buildSuccessResult(stringBuilder.toString());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return buildErrorResult(CommonCode.SERVER_ERROR.getCode(), CommonCode.SERVER_ERROR.getValue());
        }
    }
}
