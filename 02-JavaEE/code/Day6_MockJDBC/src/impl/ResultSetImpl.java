package impl;

import jdbc.ResultSet;

public class ResultSetImpl implements ResultSet {
    @Override
    public boolean next() {
        System.out.println("ResultSetImpl next");
        return true;
    }

    @Override
    public String getString(String columnName) {
        return "";
    }
}
