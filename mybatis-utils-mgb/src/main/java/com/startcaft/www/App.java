package com.startcaft.www;

import mgb.utils.builder.Configuration;
import mgb.utils.builder.ConfigurationFactory;
import mgb.utils.builder.XmlConfigBuilder;

import java.io.InputStream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        InputStream is = App.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
        Configuration config = new ConfigurationFactory().createInstance();

        XmlConfigBuilder builder = new XmlConfigBuilder(is);

        builder.builder(config);
    }
}
