package com.startcaft.www;

import mgb.utils.builder.Configuration;
import mgb.utils.builder.ConfigurationFactory;
import mgb.utils.builder.XmlConfigBuilder;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.InputStream;
import java.io.StringWriter;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {

        InputStream is = App.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
        Configuration config = new ConfigurationFactory().createInstance();

        XmlConfigBuilder builder = new XmlConfigBuilder(is);

        Document document = builder.builderConfig(config);

        //创建字符串缓冲区
        StringWriter fileWriter = new StringWriter();
        //设置文件编码
        OutputFormat xmlFormat = new OutputFormat();
        xmlFormat.setEncoding("UTF-8");
        // 设置换行
        xmlFormat.setNewlines(true);
        // 生成缩进
        xmlFormat.setIndent(true);
        // 使用4个空格进行缩进, 可以兼容文本编辑器
        xmlFormat.setIndent("    ");

        //创建写文件方法
        XMLWriter xmlWriter = new XMLWriter(fileWriter,xmlFormat);
        //写入文件
        xmlWriter.write(document);
        //关闭
        xmlWriter.close();
        // 输出xml
        System.out.println(fileWriter.toString());
    }
}
