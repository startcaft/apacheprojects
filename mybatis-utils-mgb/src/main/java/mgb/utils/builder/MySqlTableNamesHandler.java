package mgb.utils.builder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 默认的DbTableHandler实现，获取mysql指定数据库中的所有表明。
 */
public class MySqlTableNamesHandler extends DbTableHandler {

    public MySqlTableNamesHandler(Configuration configuration) {
        super(configuration);
    }

    @Override
    public List<String> getTables() {

        Connection conn = null;
        List<String> tables = new ArrayList<String>();

        try {
            conn = SqlUtil.getConnection(configuration);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SHOW TABLES");
            while (rs.next()){
                tables.add(rs.getString(1));
            }
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
