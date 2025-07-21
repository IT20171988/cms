package com.cms.cms.util;

import com.cms.cms.enums.LoggType;
import org.slf4j.Logger;

public class LoggerUtil {

    public static void loggerMsg(Logger logger, String message, LoggType loggType) {
        switch (loggType) {
            case INFO:
                logger.info(message);
                break;
            case ERROR:
                logger.error(message);
                break;
            case DEBUG:
                logger.debug(message);
                break;
            case WARN:
                logger.warn(message);
                break;
            default:
                logger.info(message);
        }
    }
}
