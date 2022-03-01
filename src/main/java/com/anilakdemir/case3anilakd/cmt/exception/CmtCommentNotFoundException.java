package com.anilakdemir.case3anilakd.cmt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author anilakdemir
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CmtCommentNotFoundException extends RuntimeException{

    private static final String CMT_COMMENT_NOT_FOUND = "Comment not found";

    public CmtCommentNotFoundException () {
        super(CMT_COMMENT_NOT_FOUND);
    }
}