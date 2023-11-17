package com.cee.tech.utils;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLogger {

    private static CustomLogger loggerInstance;
    private static Logger logger;
    private CustomLogger() {
        logger = Logger.getLogger(CustomLogger.class.getName());
        try {
            FileHandler fileHandler = new FileHandler("log.txt", true); // Append to existing log file
            LoggerFormatter formatter = new LoggerFormatter();
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.info("Test logging");
        } catch (Exception e) {
            // Log the exception
            logger.log(Level.SEVERE, "Error configuring logger:", e);
        }
    }

    public static synchronized CustomLogger getLoggerInstance() {
        if (loggerInstance == null) {
            loggerInstance = new CustomLogger();
        }
        return loggerInstance;
    }

    public void log(Level level, String message) {
        logger.log(level, message);
    }
}
