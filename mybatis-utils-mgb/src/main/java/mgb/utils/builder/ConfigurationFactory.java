package mgb.utils.builder;

/**
 * Configuration配置对象的生产工厂，
 * 生成的配置对象是全局唯一的。
 */
public class ConfigurationFactory {

    private boolean singleton;
    private DbAccess dbAccess;
    private Configuration singletonInstance;

    public ConfigurationFactory() {
        this.singleton = true;
        this.dbAccess = new DefaultDbAccess();
    }

    public boolean isSingleton() {
        return singleton;
    }

    public Configuration getInstance() {
        Configuration instance;
        if (isSingleton()) {
            if (this.singletonInstance == null) {
                this.singletonInstance = createInstance();
            }
            instance = this.singletonInstance;
        } else {
            instance = createInstance();
        }
        if (instance == null) {
            String msg = "Factory 'createInstance' implementation returned a null object.";
            throw new IllegalStateException(msg);
        }
        return instance;
    }

    public final Configuration createInstance() {
        Configuration config = new Configuration();
        config.setJarPath("D:\\DevelopRepository\\maven\\repo\\mysql\\mysql-connector-java\\5.1.40\\mysql-connector-java-5.1.40.jar");
        config.setDriverClass("com.mysql.jdbc.Driver");
        config.setConnectionURL("jdbc:mysql://localhost:3306/test");
        config.setUserId("root");
        config.setPassword("5904395");
        config.setProjectPath("D:\\DevelopRepository\\git\\apache_projects_git\\mybatis-utils-mgb\\src\\main\\java");
        config.setModelPackage("com.mgb.model");
        config.setMapperPackage("com.mgb.mapper");
        config.setDaoPackage("com.mgb.dao");
        return config;
    }
}
