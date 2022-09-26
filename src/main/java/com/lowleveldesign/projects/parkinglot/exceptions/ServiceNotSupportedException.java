package com.lowleveldesign.projects.parkinglot.exceptions;

public class ServiceNotSupportedException extends RuntimeException {
    public ServiceNotSupportedException(String errMsg) {
        super(errMsg);
    }
}
