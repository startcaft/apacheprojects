package mgb.utils.builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by startcaft on 2017/6/2.
 */
public class SqlUtil {

    /***
     * 返回一个数据库连接
     *
     * @return
     */
    public static Connection getConnection(Configuration config) {
        Connection conn = null;
        try {
            // 5.获取连接
            conn = DriverManager.getConnection(config.getConnectionURL(), config.getUserId(), config.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回连接对象
        return conn;
    }

    /***
     * 关闭SQL的连接资源
     *
     * @param statement
     * @param connection
     */
    public static void close(Statement statement, Connection connection) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
