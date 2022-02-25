package com.anilakdemir.case3anilakd.prd.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author anilakdemir
 */
@Data
public class PrdProductSaveRequestDto {

    private String name;

    private BigDecimal price;
}
