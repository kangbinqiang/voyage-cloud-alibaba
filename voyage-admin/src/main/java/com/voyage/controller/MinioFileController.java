package com.voyage.controller;

import com.voyage.common.ResponseMO;
import com.voyage.dao.MinioFileMapper;
import com.voyage.entity.MinioFileDO;
import com.voyage.utils.StringUtil;
import io.minio.MinioClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

/**
 * @Author: kangb on 2020/10/2 23:18
 * @param:
 * @return:
 * @Description: minio文件管理器
 */

@RestController
@Api(tags = "Minio文件管理器")
@RequestMapping("file")
@Slf4j
public class MinioFileController extends BaseController {


    @Value("${minio.url}")
    private String url;
    @Value("${minio.accessKey}")
    private String accessKey;
    @Value("${minio.secretKey}")
    private String secretKey;
    @Value("${minio.bucket}")
    private String bucket;

    private final MinioFileMapper minioFileMapper;

    public MinioFileController(MinioFileMapper minioFileMapper) {
        this.minioFileMapper = minioFileMapper;
    }


    @SneakyThrows
    @PostMapping("upload")
    @ApiOperation(value = "上传文件")
    public ResponseMO upload(@RequestParam("file") MultipartFile file) {
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            InputStream inputStream = file.getInputStream();
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            String prefix = LocalDateTime.now().format(dateTimeFormatter).toString();
            String fileName = prefix + file.getOriginalFilename();
            String contentType = file.getContentType();
            minioClient.putObject(bucket, fileName, inputStream, contentType);
            MinioFileDO minioFileDO = new MinioFileDO();
            minioFileDO.initArgs();
            minioFileDO.setBucket(bucket);
            minioFileDO.setFileName(fileName);
            minioFileDO.setUploadTime(new Date());
            minioFileMapper.insertSelective(minioFileDO);
            log.info("文件上传成功，文件名称={}", fileName);
            return success("文件上传成功");
        } catch (Exception e) {
            log.error("文件上传失败", e);
            throw new Exception();
        }
    }


    @SneakyThrows
    @GetMapping("download")
    @ApiOperation(value = "下载文件")
    public ResponseMO<String> download(@RequestParam("bucket") String bucket,
                                       @RequestParam("fileName") String fileName) {
        try {
            MinioClient minioClient = new MinioClient(url, accessKey, secretKey);
            String url = minioClient.presignedGetObject(bucket, fileName);
            return success(url, "文件下载成功");
        } catch (Exception e) {
            log.error("文件下载失败", e);
            throw new Exception();
        }
    }


}
