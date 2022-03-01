package com.anilakdemir.case3anilakd.cmt.exception.exceptionHandler;

import com.anilakdemir.case3anilakd.cmt.exception.CmtCommentNotFoundException;
import com.anilakdemir.case3anilakd.cmt.exception.NoCmtCommentAboutPrdProductException;
import com.anilakdemir.case3anilakd.cmt.exception.NoCmtCommentByUsrUserException;
import com.anilakdemir.case3anilakd.gen.dto.RestResponse;
import com.anilakdemir.case3anilakd.gen.exception.GenExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author anilakdemir
 */
@ControllerAdvice
@RestController
public class CmtCommentCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(NoCmtCommentByUsrUserException exception, WebRequest webRequest){
        RestResponse restResponse = createRestResponseExceptionBody(exception, webRequest);
        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(NoCmtCommentAboutPrdProductException exception, WebRequest webRequest){
        RestResponse restResponse = createRestResponseExceptionBody(exception, webRequest);
        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(CmtCommentNotFoundException exception, WebRequest webRequest){
        RestResponse restResponse = createRestResponseExceptionBody(exception, webRequest);
        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private final RestResponse createRestResponseExceptionBody (RuntimeException exception, WebRequest webRequest){
        Date errorDate = new Date();
        String message = exception.getMessage();
        String description = webRequest.getDescription(false);

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);

        RestResponse<GenExceptionResponse> restResponse = RestResponse.error(genExceptionResponse);
        restResponse.setMessage(message);
        return restResponse;
    }


}
