package com.anilakdemir.case3anilakd.usr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsrUserNotFoundException extends RuntimeException {

    private static final String USER_NOT_FOUND = "User not found";

    public UsrUserNotFoundException () {
        super(USER_NOT_FOUND);
    }
}
