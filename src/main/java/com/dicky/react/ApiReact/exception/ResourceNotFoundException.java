/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dicky.react.ApiReact.exception;

/**
 *
 * @author dickyadriansyah
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg){
        super(msg);
    }

    public ResourceNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
