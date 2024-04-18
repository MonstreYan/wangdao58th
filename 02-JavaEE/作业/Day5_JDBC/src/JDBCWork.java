import util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCWork {

    public static void main(String[] args) {
        //select m.name,group_concat(s.name) from mentor m,student s where m.id=s.mid group by m.name;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select m.name as mname,group_concat(s.name) as sname from mentor m,student s where m.id=s.mid group by m.name");
            resultSet.next();
            String mname = resultSet.getString("mname");
            String sname = resultSet.getString("sname");
            System.out.println(mname + ":" + sname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                JdbcUtil.close(connection, statement, resultSet);
            }catch (Exception e){}
        }

    }
}
