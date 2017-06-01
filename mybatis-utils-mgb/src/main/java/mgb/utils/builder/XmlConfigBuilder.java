package mgb.utils.builder;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MGB配置文件解析器
 */
        public class XmlConfigBuilder {

            private final static Logger LOGGER = LoggerFactory.getLogger(XmlConfigBuilder.class);

            private Configuration config;

            private DbAccess dbAccess;

            private DataSource dataSource;

            public Configuration getConfig() {
                return config;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    //构造自定义的DbAccess组件
    public XmlConfigBuilder(Configuration config,DbAccess dbAccess,DataSource dataSource) {
        this.config = config;
        this.dbAccess = dbAccess;
        this.dataSource = dataSource;
    }

    //默认构造DefaultDbAccess实例
    public XmlConfigBuilder(Configuration config,DataSource dataSource) {
        this.config = config;
        this.dataSource = dataSource;
        this.dbAccess = new DefaultDbAccess(dataSource);
    }

    public void builderConfig() throws Exception {

        long startTime = System.currentTimeMillis();

        //验证指定的jatPath是否存在
        File file = FileUtils.getFile(config.getJarPath());
        String errorMsg = "找不到指定的JDBC驱动包文件";

        if (file == null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(errorMsg);
            }
            throw new Exception(errorMsg);
        }

        //验证指定的projectPath是否存在
        errorMsg = "找不到指定的项目路径";
        file = FileUtils.getFile(config.getProjectPath());
        if (file == null) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug(errorMsg);
            }
            throw new Exception(errorMsg);
        }


            List<String> tables = this.dbAccess.getTables();
            for (String name : tables) {
                if (LOGGER.isDebugEnabled()){
                    LOGGER.debug(name);
                }
            String className = name.substring(0, 1).toUpperCase()+name.substring(1);

            Element root = DocumentHelper.createElement("generatorConfiguration");
            Document document = DocumentHelper.createDocument(root);
            //添加<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN" "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >
            document.addDocType("generatorConfiguration","-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN","http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd");

            //构建classPathEntry节点
            Element classPathEntryNode = root.addElement("classPathEntry");
            classPathEntryNode.addAttribute("location",config.getJarPath());

            //构建context节点
            Element contextNode = root.addElement("context");
            contextNode.addAttribute("id","context1");
            contextNode.addAttribute("targetRuntime","MyBatis3");

            Element commentGeneratorNode = contextNode.addElement("commentGenerator");
            commentGeneratorNode.addElement("property").addAttribute("name","suppressAllComments")
                    .addAttribute("value","true");

            //构建jdbcConnection节点
            Element jdbcConnectionNode = contextNode.addElement("jdbcConnection");
            jdbcConnectionNode.addAttribute("driverClass",config.getDriverClass())
                    .addAttribute("connectionURL",config.getConnectionURL())
                    .addAttribute("userId",config.getUserId())
                    .addAttribute("password",config.getPassword());

            //构建javaModelGenerator节点
            Element javaModelGeneratorNode = contextNode.addElement("javaModelGenerator");
            javaModelGeneratorNode.addAttribute("targetProject",config.getProjectPath())
                    .addAttribute("targetPackage",config.getModelPackage());

            //构建javaModelGenerator节点
            Element sqlMapGeneratorNode = contextNode.addElement("sqlMapGenerator");
            sqlMapGeneratorNode.addAttribute("targetProject",config.getProjectPath())
                    .addAttribute("targetPackage",config.getMapperPackage());

            //构建javaClientGenerator节点
            Element javaClientGeneratorNode = contextNode.addElement("javaClientGenerator");
            javaClientGeneratorNode.addAttribute("targetProject",config.getProjectPath())
                    .addAttribute("targetPackage",config.getDaoPackage())
                    .addAttribute("type","XMLMAPPER");

            //构建table节点
            Element tableNode = contextNode.addElement("table");
            //动态赋值表名和类名
            tableNode.addAttribute("tableName",name)
                    .addAttribute("domainObjectName",className)
                    .addAttribute("enableCountByExample","false")
                    .addAttribute("enableUpdateByExample","false")
                    .addAttribute("enableDeleteByExample","false")
                    .addAttribute("enableSelectByExample","false")
                    .addAttribute("selectByExampleQueryId","false");
            tableNode.addElement("property").addAttribute("name","useActualColumnNames")
                    .addAttribute("value","true");

            //MGB代码生成
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            InputStream configIs = new ByteArrayInputStream(document.asXML().getBytes("utf-8"));
            ConfigurationParser cp = new ConfigurationParser(warnings);
            org.mybatis.generator.config.Configuration configuration = cp.parseConfiguration(configIs);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);
            myBatisGenerator.generate(null);

            if (LOGGER.isDebugEnabled()){
                LOGGER.debug("db_table:" + name + "------java_bean:" + className);
            }

            configIs.close();
            configIs = null;
            document = null;
        }

        long endTime = System.currentTimeMillis();

        if (LOGGER.isDebugEnabled()){
            LOGGER.debug(endTime - startTime + "ms used!");
        }
    }
}
