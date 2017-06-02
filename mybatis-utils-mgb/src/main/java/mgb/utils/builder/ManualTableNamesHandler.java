package mgb.utils.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by startcaft on 2017/6/2.
 */
public class ManualTableNamesHandler extends DbTableHandler {


    public ManualTableNamesHandler(Configuration configuration) {
        super(configuration);
    }

    @Override
    public List<String> getTables() {
        List<String> tables = new ArrayList<>(1);
        tables.add("users");
        return tables;
    }
}
