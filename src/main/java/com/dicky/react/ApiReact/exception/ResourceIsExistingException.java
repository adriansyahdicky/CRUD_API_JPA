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
public class ResourceIsExistingException extends RuntimeException{
    public ResourceIsExistingException(String msg){
        super(msg);
    }

    public ResourceIsExistingException(String msg, Throwable cause){
        super(msg, cause);
    }
}
