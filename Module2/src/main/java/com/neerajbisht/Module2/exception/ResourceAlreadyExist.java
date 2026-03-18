package com.neerajbisht.Module2.exception;

public class ResourceAlreadyExist extends RuntimeException{
    public ResourceAlreadyExist(String message){
        super(message);
    }
}
