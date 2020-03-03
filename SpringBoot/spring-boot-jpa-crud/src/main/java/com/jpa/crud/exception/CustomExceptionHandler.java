package com.jpa.crud.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
        List<String> errorMessages = new ArrayList<>();
        for(ObjectError error : e.getBindingResult().getAllErrors()) {
        	errorMessages.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", errorMessages);
        return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request) {
		
        List<String> errorMessages = new ArrayList<>();
        errorMessages.add(e.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse("Internal server Error", errorMessages);
        return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
