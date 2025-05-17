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
public class Project0 {
    /**
     * Name of properties file
     */
    public static final String PROPERTIES_FILE = "project0.properties";

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Project0.class);

    /**
     * Entry point to the program
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        logger.info("Starting Main");

        PropertiesLoader propertiesLoader = new PropertiesLoader(PROPERTIES_FILE);
        Properties properties;

        try {
            properties = propertiesLoader.loadProperties();
        } catch (Exception e) {
            System.out.println("Could not load properties file: " + PROPERTIES_FILE + ". Exiting.");
            logger.error("Could not load properties file: " + PROPERTIES_FILE, e);
            return;
        }

        Message message = new Message(properties.getProperty("username"));
        String output;

        try {
            output = System.getProperty("format").equals("xml") ? message.toXml() : message.toJson();
            logger.info("Serialized {} to {}", message, output);
        } catch (JsonProcessingException e) {
            System.out.println("Could not serialize: " + e.getMessage());
            logger.error("Could not serialize {}", message, e);
            return;
        }

        System.out.println(output);
        logger.info("Exiting Main");
    }
}