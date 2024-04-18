package jdbc;

public interface ResultSet {

    boolean next();


    String getString(String columnName);
}
