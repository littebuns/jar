package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * trace -> debug -> info ->warn -> error
 */
public class App {

    static Logger logger =  LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
//        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        logger.trace("hello world");
        logger.info("hello world");
//        logger.setLevel(Level.DEBUG);

    }
}
