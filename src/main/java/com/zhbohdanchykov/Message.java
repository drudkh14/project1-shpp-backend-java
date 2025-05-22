package com.zhbohdanchykov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class Message represents a message with greeting "Привіт " and given username
 */
public class Message {

    private final String name;

    private static final String GREETING = "Привіт ";

    private static final Logger logger = LoggerFactory.getLogger(Message.class);

    /**
     * Constructs Message with given username
     *
     * @param name Given username
     */
    Message(String name) {
        this.name = name;
        logger.info("Created Message: {}", this);
    }

    /**
     * Returns message
     *
     * @return Message
     */
    public String getMessage() {
        return GREETING + name + "!";
    }

    @Override
    public String toString() {
        return "Message [name = " + name + ", greetings = " + GREETING + "]";
    }
}
