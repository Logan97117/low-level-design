package com.lowleveldesign.projects.logger;

public class DebugLogger extends Logger {
    public DebugLogger(Logger next) {
        super(next);
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        if(logLevel == LogLevel.DEBUG)
            System.out.println("DEBUG: " + message);
        else this.next.log(logLevel, message);
    }
}
