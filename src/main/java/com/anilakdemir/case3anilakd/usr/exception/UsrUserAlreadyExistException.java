package com.anilakdemir.case3anilakd.usr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsrUserAlreadyExistException extends RuntimeException{

    private static final String USER_ALREADY_EXIST = "User already exists";

    public UsrUserAlreadyExistException () {
        super(USER_ALREADY_EXIST);
    }
}
