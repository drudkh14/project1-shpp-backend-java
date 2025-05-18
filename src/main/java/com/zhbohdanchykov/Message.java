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

    private String name;

    private static final String GREETING = "Привіт ";

    private final ObjectMapper jsonMapper = new ObjectMapper();
    private final XmlMapper xmlMapper = new XmlMapper();

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
        return GREETING + name + "!";
    }

    @Override
    public String toString() {
        return "Message [name = " + name + ", greetings = " + GREETING + "]";
    }

    /**
     * Returns message in JSON format
     *
     * @return Message in JSON format
     * @throws JsonProcessingException to throw if there is a problem with serializing
     */
    public String toJson() throws JsonProcessingException {
        logger.debug("Serializing {} to JSON with ObjectMapper", this);
        return jsonMapper.writeValueAsString(this);
    }

    /**
     * Returns message in XML format
     *
     * @return Message in XML format
     * @throws JsonProcessingException to throw if there is a problem with serializing
     */
    public String toXml() throws JsonProcessingException {
        logger.debug("Serializing {} to XML with XmlMapper", this);
        return xmlMapper.writeValueAsString(this);
    }
}
