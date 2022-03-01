package com.anilakdemir.case3anilakd.gen.exception.exceptionHandler;

import com.anilakdemir.case3anilakd.gen.dto.RestResponse;
import com.anilakdemir.case3anilakd.gen.exception.GenExceptionResponse;
import com.anilakdemir.case3anilakd.usr.exception.UsrUserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * @author anilakdemir
 */
@ControllerAdvice
@RestController
public class GenCustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleResponseStatusException(ResponseStatusException exception, WebRequest webRequest){
        Date errorDate = new Date();
        String message = exception.getReason();
        String description = webRequest.getDescription(false);

        GenExceptionResponse genExceptionResponse = new GenExceptionResponse(errorDate, message, description);

        RestResponse<GenExceptionResponse> restResponse = RestResponse.error(genExceptionResponse);
        restResponse.setMessage(message);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

}
