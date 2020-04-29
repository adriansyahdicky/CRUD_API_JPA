/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.exception.controller;

import com.dicky.react.ApiReact.exception.ResourceIsExistingException;
import com.dicky.react.ApiReact.exception.ResourceNotFoundException;
import com.dicky.react.ApiReact.response.CustomErrorResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author dickyadriansyah
 */
@RestControllerAdvice
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler{
    
    /** 500 internal server error */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleInternalServerError(Exception e, WebRequest request){
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setError(e.getLocalizedMessage());
        errorResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /** 404  not found rest api global**/
    @ExceptionHandler(ResourceNotFoundException.class)
    protected ResponseEntity<CustomErrorResponse> handleNotFoundException(ResourceNotFoundException ex, WebRequest webRequest) throws IOException {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setError(ex.getLocalizedMessage());
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /** 409 conflict data rest api global **/
    @ExceptionHandler(ResourceIsExistingException.class)
    protected ResponseEntity<CustomErrorResponse> handleResourceExisting(ResourceIsExistingException ex, WebRequest webRequest) throws IOException{
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setError(ex.getLocalizedMessage());
        errorResponse.setStatus(HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    
}
