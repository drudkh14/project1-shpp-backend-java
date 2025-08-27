package com.zhbohdanchykov;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * The application Project0 is made for Java-Backend course at Shpp school
 * and supposed to write in console JSON or XML with greeting and username that
 * set in the properties file.
 */
public class Project1 {

    public static final String PROPERTIES_FILE = "project1.properties";

    private static final Logger logger = LoggerFactory.getLogger(Project1.class);

    public static void main(String[] args) {
        logger.info("Starting Main");

        Properties properties;

        try {
            properties = new PropertiesLoader(PROPERTIES_FILE).loadProperties();
        } catch (Exception e) {
            logger.error("Could not load properties file: {}", PROPERTIES_FILE);
            return;
        }

        Message message = new Message(properties.getProperty("username", "Default Default"));
        Serializer<Message> serializer = new Serializer<>(message);
        String output;

        try {
            output = "xml".equals(System.getProperty("format")) ? serializer.serializeToXml() :
                    serializer.serializeToJson();
            logger.info("Serialized {} to {}", message, output);
        } catch (JsonProcessingException e) {
            logger.error("Could not serialize {}", message, e);
            return;
        }

        System.out.println(output);
        logger.info("Exiting Main");
    }
}