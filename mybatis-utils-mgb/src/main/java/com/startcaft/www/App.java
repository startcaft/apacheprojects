package com.startcaft.www;

import com.alibaba.druid.pool.DruidDataSource;
import mgb.utils.builder.Configuration;
import mgb.utils.builder.XmlConfigBuilder;

/**
 * test app
 */
public class App {
    public static void main(String[] args) throws Exception {

        //构建Configuration对象
        Configuration config = new Configuration();
        config.setJarPath("D:\\maven\\repo\\mysql\\mysql-connector-java\\5.1.40\\mysql-connector-java-5.1.40.jar");
        config.setDriverClass("com.mysql.jdbc.Driver");
        config.setConnectionURL("jdbc:mysql://localhost:3306/db_shiro");
        config.setUserId("root");
        config.setPassword("5904395");
        config.setProjectPath("D:\\Github_Sources\\apache_projects_git\\mybatis-utils-mgb\\src\\main\\java");
        config.setModelPackage("com.mgb.model");
        config.setMapperPackage("com.mgb.mapper");
        config.setDaoPackage("com.mgb.dao");

        //构建DruidDataSource对象
        DruidDataSource dataSource = new DruidDataSource();
        // jdbc connection
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("5904395");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        //构建XmlConfigBuilder对象，将DataSource实例和Configuration实例注入
        XmlConfigBuilder builder = new XmlConfigBuilder(config,dataSource);
        builder.builderConfig();
    }
}
