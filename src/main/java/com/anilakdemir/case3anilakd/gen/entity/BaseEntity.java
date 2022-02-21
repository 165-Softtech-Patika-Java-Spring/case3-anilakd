package com.anilakdemir.case3anilakd.gen.entity;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author anilakdemir
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements BaseModel, Serializable {

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
