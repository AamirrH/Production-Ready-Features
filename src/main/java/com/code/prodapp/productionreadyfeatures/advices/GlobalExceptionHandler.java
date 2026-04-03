package com.code.prodapp.productionreadyfeatures.advices;

import com.code.prodapp.productionreadyfeatures.exceptions.PostNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<CustomAPIError> handlePostNotFoundException(PostNotFoundException pnfexception){
        CustomAPIError customAPIError = new CustomAPIError(pnfexception.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(customAPIError);

    }




}


