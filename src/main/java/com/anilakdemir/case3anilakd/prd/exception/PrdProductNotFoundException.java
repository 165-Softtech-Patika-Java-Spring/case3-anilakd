package com.anilakdemir.case3anilakd.prd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PrdProductNotFoundException extends RuntimeException {

    private static final String PRODUCT_NOT_FOUND = "Product not found";

    public PrdProductNotFoundException () {
        super(PRODUCT_NOT_FOUND);
    }
}
