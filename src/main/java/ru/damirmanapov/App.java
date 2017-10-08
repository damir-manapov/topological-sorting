package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Print arguments
        for (String s : args) {
            logger.info("argument: {}", s);
        }

        switch (args[0]) {
            case "do-something":
                logger.info("do-something");
                break;
            case "do-something-else":
                logger.info("do-something-else");
                break;
            default:
                throw new AppException("wrong argument");

        }
    }
}
