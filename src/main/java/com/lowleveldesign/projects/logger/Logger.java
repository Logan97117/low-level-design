package com.lowleveldesign.projects.logger;

public abstract class Logger {
    protected Logger next;
    public Logger(Logger next) {
        this.next = next;
    }

    public abstract void log(LogLevel logLevel, String message);
}
