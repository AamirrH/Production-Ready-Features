package com.code.prodapp.productionreadyfeatures.advices;

import lombok.*;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
public class CustomAPIError {

    private LocalDate timestamp;
    private String message;
    private HttpStatus status;

    public CustomAPIError(String message, HttpStatus status){
        this.timestamp = LocalDate.now();
        this.message = message;
        this.status = status;

    }

}
