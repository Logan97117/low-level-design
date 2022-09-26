package com.lowleveldesign.projects.logger;

public class LoggerFactory {
    public static Logger getLogger()  {
        return new InfoLogger(new ErrorLogger(new DebugLogger(null)));
    }
}
