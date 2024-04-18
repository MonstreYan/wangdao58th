package impl;

import jdbc.Connection;
import jdbc.Statement;

public class ConnectionImpl implements Connection {
    @Override
    public Statement createStatement() {
        System.out.println(" ConnectionImpl createStatement");
        return new StatementImpl();
    }
}
