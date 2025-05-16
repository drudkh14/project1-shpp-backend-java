package com.zhbohdanchykov;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class Message represents a message with greeting "Привіт " and given username
 */
public class Message {

    /**
     * Username
     */
    private String name;

    private final String greeting = "Привіт ";

    /**
     * Mapper for serializing
     */
    private ObjectMapper mapper;

    /**
     * Logger
     */
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

    Message() {
    }

    /**
     * Returns message
     *
     * @return Message
     */
    public String getMessage() {
        return greeting + name + "!";
    }

    @Override
    public String toString() {
        return "Message [name = " + name + ", greetings = " + greeting + "]";
    }

    /**
     * Returns message in JSON format
     *
     * @return Message in JSON format
     * @throws JsonProcessingException to throw if there is a problem with serializing
     */
    public String toJson() throws JsonProcessingException {
        mapper = new ObjectMapper();
        logger.debug("Serializing {} to JSON with ObjectMapper", this);
        return mapper.writeValueAsString(this);
    }

    /**
     * Returns message in XML format
     *
     * @return Message in XML format
     * @throws JsonProcessingException to throw if there is a problem with serializing
     */
    public String toXml() throws JsonProcessingException {
        mapper = new XmlMapper();
        logger.debug("Serializing {} to XML with XmlMapper", this);
        return mapper.writeValueAsString(this);
    }
}
