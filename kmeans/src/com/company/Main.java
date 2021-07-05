package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static Properties properties;

    public static void main(String[] args) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("application.properties"));
        Kmean kmean = new Kmean();
        kmean.readData();
        kmean.calculate();
    }
}
