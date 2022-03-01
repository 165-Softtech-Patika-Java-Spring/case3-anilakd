package com.anilakdemir.case3anilakd.cmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NoCmtCommentByUsrUserException extends RuntimeException{

    public NoCmtCommentByUsrUserException (String message) {
        super(message);
    }
}
