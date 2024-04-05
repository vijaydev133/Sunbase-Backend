package com.project.Exceptions;

public class CustomerAldreadyExists extends RuntimeException {

    public CustomerAldreadyExists(String message){
        super(message);
    }
}
