package mgb.utils.builder;

import java.util.List;

/**
 * 配置对象，主要讲配置对象的数据设置到MGB配置文件中
 */
public class Configuration {

    private String jarPath;//JDBC驱动jar包路径
    private String driverClass;//JDBC连接类全类名
    private String connectionURL;//JDBC连接字符串
    private String userId;//数据库用户名
    private String password;//密码

    private String projectPath;//目标项目路径
    private String modelPackage;//模型类所在包名
    private String daoPackage;//dao接口所在包名
    private String mapperPackage;//mapper映射文件所在包名

    public String getJarPath() {
        return jarPath;
    }

    public void setJarPath(String jarPath) {
        this.jarPath = jarPath;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String connectionURL) {
        this.connectionURL = connectionURL;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProjectPath() {
        return projectPath;
    }

    public void setProjectPath(String projectPath) {
        this.projectPath = projectPath;
    }

    public String getModelPackage() {
        return modelPackage;
    }

    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }

    public String getDaoPackage() {
        return daoPackage;
    }

    public void setDaoPackage(String daoPackage) {
        this.daoPackage = daoPackage;
    }

    public String getMapperPackage() {
        return mapperPackage;
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

}
