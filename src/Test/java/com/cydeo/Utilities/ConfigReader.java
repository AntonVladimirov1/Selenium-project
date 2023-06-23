package com.cydeo.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties.load(file);

            file.close();

        } catch (IOException e) {
            System.out.println("FILE NOT FOUND with given path!!!");
            e.printStackTrace();
        }
    }
           // creating Utility method to use the object to read
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }

}
