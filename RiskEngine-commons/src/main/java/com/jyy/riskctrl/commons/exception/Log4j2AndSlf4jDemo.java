package com.jyy.riskctrl.commons.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Slf4j
public class Log4j2AndSlf4jDemo {

    private static final Logger logger = LogManager.getLogger(Log4j2AndSlf4jDemo.class);

    /*slf4j */
    public static void slf4jOutput() {
        log.warn("this is slf4j output");
    }

    /*log4j2 */
    public static void log4j2Output() {
        logger.error("this log4j2 output");
    }
}
