package mgb.utils.builder;

import java.util.List;

/**
 * Created by startcaft on 2017/5/28.
 */
public interface DbAccess {

    /**
     * 执行指定SQL语句，获取所有表名
     * @param sql
     * @return
     */
    public List<String> getTables(String sql);
}
