package ru.damirmanapov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.damirmanapov.exception.AppException;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        switch (args[0]) {
            case "test":
                logger.info("test");
                break;
            default:
                throw new AppException("wrong argument");

        }
    }
}
