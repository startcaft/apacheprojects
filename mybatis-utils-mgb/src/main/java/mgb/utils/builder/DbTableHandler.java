package mgb.utils.builder;

import javax.sql.DataSource;
import java.util.List;

/**
 * 指定数据库真实存在的表明
 */
public abstract class DbTableHandler {

    protected Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public DbTableHandler(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * 执行指定SQL语句，获取所有表名
     */
    public abstract List<String> getTables();
}
