package com.lowleveldesign.projects.logger;

public class ErrorLogger extends Logger {
    public ErrorLogger(Logger next) {
        super(next);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel == LogLevel.ERROR)
            System.out.println("ERROR: " + message);
        else this.next.log(logLevel, message);
    }
}
