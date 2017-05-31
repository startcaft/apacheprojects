package mgb.utils.builder;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;

/**
 * MGB配置文件解析器
 */
public class XmlConfigBuilder {

    private final static Logger LOGGER = LoggerFactory.getLogger(XmlConfigBuilder.class);

    private Element root;

    public XmlConfigBuilder(InputStream is) {
        Document document = this.init(is);
        this.root = document.getRootElement();
    }

    //加载配置文件输入流
    private Document init(InputStream is) {
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
            doc = reader.read(is);
        } catch (DocumentException e) {
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("generatorConfig.xml配置文件", e);
            }
        }
        return doc;
    }

    public Document builderConfig(Configuration config) throws Exception {
        Element root = DocumentHelper.createElement("generatorConfiguration");
        Document document = DocumentHelper.createDocument(root);

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
        tableNode.addAttribute("tableName","")
                .addAttribute("domainObjectName","")
                .addAttribute("type","XMLMAPPER")
                .addAttribute("enableCountByExample","false")
                .addAttribute("enableUpdateByExample","false")
                .addAttribute("enableDeleteByExample","false")
                .addAttribute("enableSelectByExample","false")
                .addAttribute("selectByExampleQueryId","false");
        tableNode.addElement("property").addAttribute("name","useActualColumnNames")
                .addAttribute("value","true");

        return document;
    }

//    public void builder(Configuration config) throws Exception {
//        //验证指定的jatPath是否存在
//        File file = FileUtils.getFile(config.getJarPath());
//        String errorMsg = "找不到指定的JDBC驱动包文件";
//
//        if (file == null) {
//            if (LOGGER.isDebugEnabled()) {
//                LOGGER.debug(errorMsg);
//            }
//            throw new Exception(errorMsg);
//        }
//
//        //验证指定的projectPath是否存在
//        errorMsg = "找不到指定的项目路径";
//        file = FileUtils.getFile(config.getProjectPath());
//        if (file == null) {
//            if (LOGGER.isDebugEnabled()) {
//                LOGGER.debug(errorMsg);
//            }
//            throw new Exception(errorMsg);
//        }
//
//        Element node = this.getNode(root, "classPathEntry");
//        //设置MGB配置文件的配置数据
//        node.attribute("location").setValue(config.getJarPath());
//
//        //以下内容是子节点context下的内容，contetx子节点需要设置id和targetRuntime属性
//        Element contextNode = this.getNode(root,"context");
//        contextNode.attribute("id").setValue("context1");
//        contextNode.attribute("targetRuntime").setValue("MyBatis3");
//
//        node = contextNode.element("jdbcConnection");
//        //设置MGB配置文件的JDBC连接信息
//        node.attribute("driverClass").setValue(config.getDriverClass());
//        node.attribute("connectionURL").setValue(config.getConnectionURL());
//        node.attribute("userId").setValue(config.getUserId());
//        node.attribute("password").setValue(config.getPassword());
//
//        node = contextNode.element("sqlMapGenerator");
//        //设置MGB配置文件的Mapper映射文件生成位置
//        node.attribute("targetProject").setValue(config.getProjectPath());
//        node.attribute("targetPackage").setValue(config.getMapperPackage());
//
//        node = contextNode.element("javaModelGenerator");
//        //设置MGB配置文件的数据库JavaBean文件生成位置
//        node.attribute("targetProject").setValue(config.getProjectPath());
//        node.attribute("targetPackage").setValue(config.getMapperPackage());
//
//        node = contextNode.element("javaClientGenerator");
//        //设置MGB配置文件的数据库JavaBean文件生成位置
//        node.attribute("targetProject").setValue(config.getProjectPath());
//        node.attribute("targetPackage").setValue(config.getMapperPackage());
//        node.attribute("type").setValue("XMLMAPPER");
//
//
//        node = contextNode.element("table");
//        //设置MGB配置文件的表名和类名
//        node.attribute("enableCountByExample").setValue("false");
//        node.attribute("enableUpdateByExample").setValue("false");
//        node.attribute("enableDeleteByExample").setValue("false");
//        node.attribute("enableSelectByExample").setValue("false");
//        node.attribute("selectByExampleQueryId").setValue("false");
//    }

    //获取MGB配置文件下的根节点下的指定子节点
    private Element getNode(Element MGBRoot, String nodeName) {
        Element child = null;
        if (MGBRoot != null) {
            child = MGBRoot.element(nodeName);
        }
        return child;
    }
}
