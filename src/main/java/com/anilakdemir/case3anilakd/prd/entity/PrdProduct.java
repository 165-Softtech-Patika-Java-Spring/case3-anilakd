package com.anilakdemir.case3anilakd.prd.entity;

import com.anilakdemir.case3anilakd.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author anilakdemir
 */
@Entity
@Table(name = "PRD_PRODUCT")
@Data
public class PrdProduct extends BaseEntity {

    @Id
    @SequenceGenerator(name = "PrdProduct", sequenceName = "PRD_PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "PrdProduct")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PRICE", precision = 19, scale = 2)
    private BigDecimal price;
}
