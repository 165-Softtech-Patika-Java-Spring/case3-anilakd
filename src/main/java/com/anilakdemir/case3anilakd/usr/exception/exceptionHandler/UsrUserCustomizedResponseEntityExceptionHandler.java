package com.anilakdemir.case3anilakd.usr.exception.exceptionHandler;

import com.anilakdemir.case3anilakd.gen.dto.RestResponse;
import com.anilakdemir.case3anilakd.gen.exception.GenExceptionResponse;
import com.anilakdemir.case3anilakd.usr.exception.UsrUserAlreadyExistException;
import com.anilakdemir.case3anilakd.usr.exception.UsrUserNotFoundException;
import com.anilakdemir.case3anilakd.usr.exception.UsrUserUsernameAndPhoneNumberMismatchException;
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
public class UsrUserCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UsrUserNotFoundException exception, WebRequest webRequest){
        RestResponse restResponse = createRestResponseExceptionBody(exception, webRequest);
        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UsrUserAlreadyExistException exception, WebRequest webRequest){
        RestResponse restResponse = createRestResponseExceptionBody(exception, webRequest);
        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUserNotFoundException(UsrUserUsernameAndPhoneNumberMismatchException exception, WebRequest webRequest){
        RestResponse restResponse = createRestResponseExceptionBody(exception, webRequest);
        return new ResponseEntity<>(restResponse, HttpStatus.CONFLICT);
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
