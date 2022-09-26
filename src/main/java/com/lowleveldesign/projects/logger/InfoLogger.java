package com.lowleveldesign.projects.logger;

public class InfoLogger extends Logger {
    public InfoLogger(Logger next) {
        super(next);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel == LogLevel.INFO)
            System.out.println("INFO: " + message);
        else this.next.log(logLevel, message);
    }
}
