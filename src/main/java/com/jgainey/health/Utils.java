package com.jgainey.health;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static Logger LOGGER;

    public static void initLogger(){
        LOGGER = Logger.getLogger("health_check_logger");

    }

    public static void logError(String message){
        LOGGER.log(Level.SEVERE, message);
    }
    public static void logInfo(String message){
        LOGGER.log(Level.INFO, message);
    }

}
