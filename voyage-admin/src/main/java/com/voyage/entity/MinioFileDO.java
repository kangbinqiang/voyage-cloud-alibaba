package com.voyage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: kangb on 2020/10/2 23:14
 * @param:
 * @return:
 * @Description: 文件上传记录
 */
@Data
@Table(name = "file_record")
public class MinioFileDO extends BaseDO {


    @Column(name = "bucket")
    private String bucket;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "upload_time")
    private Date uploadTime;

}
