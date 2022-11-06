package com.lowleveldesign.projects.carrental.exceptions;

public class NoSuchEntityException extends RuntimeException{
    public NoSuchEntityException(String message) {
        super(message);
    }
}
