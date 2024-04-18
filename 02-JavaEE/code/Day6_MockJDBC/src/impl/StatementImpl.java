package impl;

import jdbc.ResultSet;
import jdbc.Statement;

public class StatementImpl implements Statement {
    @Override
    public ResultSet executeQuery(String sql) {
        System.out.println("StatementImpl executeQuery");
        return new ResultSetImpl();
    }
}
