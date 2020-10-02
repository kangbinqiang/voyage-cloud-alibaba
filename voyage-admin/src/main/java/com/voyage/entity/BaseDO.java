package com.voyage.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description:基类
 * Author:kbq
 * Date: 2019-12-10 16:05
 */
@Data
public class BaseDO {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "created_time")
    private Date createdTime;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_time")
    private Date updatedTime;

    @Column(name = "updated_by")
    private String updatedBy;


    public void initArgs() {
        this.createdTime = new Date();
        this.updatedTime = new Date();
    }
}
