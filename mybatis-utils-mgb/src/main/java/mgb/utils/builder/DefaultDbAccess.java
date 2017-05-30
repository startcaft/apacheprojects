package mgb.utils.builder;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * 默认的DbAccess实现。
 */
public class DefaultDbAccess implements DbAccess {

    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultDbAccess.class);

    private String url;
    private String driverClass;
    private String password;
    private String user;

    public DefaultDbAccess(String url, String driverClass, String password, String user) {
        this.url = url;
        this.driverClass = driverClass;
        this.password = password;
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public String getDriverClass() {
        return driverClass;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    @Override
    public List<String> getTables(String sql) {

        Connection conn = getConnection();
        QueryRunner query = new QueryRunner();
        try {
            query.query(conn, sql, new BeanHandler<String>(String.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(this.driverClass);
            conn = DriverManager.getConnection(this.url,
                    this.user,
                    this.password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
