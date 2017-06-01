package mgb.utils.builder;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by startcaft on 2017/5/28.
 */
public abstract class DbAccess {

    protected DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DbAccess(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 执行指定SQL语句，获取所有表名
     */
    public abstract List<String> getTables();
}
