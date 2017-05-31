package mgb.utils.builder;

import org.apache.commons.collections.functors.NullIsFalsePredicate;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认的DbAccess实现。
 */
public class DefaultDbAccess extends DbAccess {

    private final static Logger LOGGER = LoggerFactory.getLogger(DefaultDbAccess.class);

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<String> getTables(String sql) {

        Connection conn = null;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        List<String> tables = null;

        try {
            conn = dataSource.getConnection();
            tables = (List<String>) jdbcTemplate.query(sql, new ResultSetExtractor<Object>() {
                @Override
                public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                    List<String> temps = new ArrayList<>();
                    while (resultSet.next()){
                        temps.add(resultSet.getString(0));
                    }
                    return temps;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return tables;
    }
}
