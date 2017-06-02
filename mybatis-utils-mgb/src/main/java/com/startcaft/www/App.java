package com.startcaft.www;

import com.alibaba.druid.pool.DruidDataSource;
import mgb.utils.builder.Configuration;
import mgb.utils.builder.DbTableHandler;
import mgb.utils.builder.ManualTableNamesHandler;
import mgb.utils.builder.XmlConfigBuilder;

/**
 * test app
 */
public class App {
    public static void main(String[] args) throws Exception {

        /*使用默认的MySqlTableNamesHandler
        Configuration config = new Configuration();
        config.setJarPath("D:\\maven\\repo\\mysql\\mysql-connector-java\\5.1.40\\mysql-connector-java-5.1.40.jar");
        config.setDriverClass("com.mysql.jdbc.Driver");
        config.setConnectionURL("jdbc:mysql://localhost:3306/db_shiro");
        config.setUserId("root");
        config.setPassword("5904395");
        config.setProjectPath("D:\\Github_Sources\\apache_projects_git\\mybatis-utils-mgb\\src\\main\\java");//绝对路径
        config.setModelPackage("com.mgb.model");
        config.setMapperPackage("com.mgb.mapper");
        config.setDaoPackage("com.mgb.dao");

        //构建XmlConfigBuilder对象，注入Configuration对象(该对象最终被注入给DbTableHandler实例)
        XmlConfigBuilder builder = new XmlConfigBuilder(config);
        builder.builderConfig();
        */



        /*使用自定义的DbTableHandler实例*/
        Configuration config = new Configuration();
        config.setJarPath("D:\\maven\\repo\\mysql\\mysql-connector-java\\5.1.40\\mysql-connector-java-5.1.40.jar");
        config.setDriverClass("com.mysql.jdbc.Driver");
        config.setConnectionURL("jdbc:mysql://localhost:3306/db_shiro");
        config.setUserId("root");
        config.setPassword("5904395");
        config.setProjectPath("mybatis-utils-mgb\\src\\main\\java");//相对路径
        config.setModelPackage("com.mgb.model");
        config.setMapperPackage("com.mgb.mapper");
        config.setDaoPackage("com.mgb.dao");

        DbTableHandler handler = new ManualTableNamesHandler(config);
        XmlConfigBuilder builder = new XmlConfigBuilder(handler);
        builder.builderConfig();

    }
}
