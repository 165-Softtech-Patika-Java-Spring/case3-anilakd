package com.anilakdemir.case3anilakd.usr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsrUserUsernameAndPhoneNumberMismatchException extends RuntimeException{

    public UsrUserUsernameAndPhoneNumberMismatchException (String message) {
        super(message);

    }
}
