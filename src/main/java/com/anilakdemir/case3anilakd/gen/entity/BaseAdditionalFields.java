package com.anilakdemir.case3anilakd.gen.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

/**
 * @author anilakdemir
 */
@Embeddable
@Data
public class BaseAdditionalFields {

    @CreatedDate
    @Column(name = "CREATE_DATE", updatable = false)
    private Date createDate;

    @LastModifiedDate
    @Column(name = "UPDATE_DATE")
    private Date updateDate;
}
