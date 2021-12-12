import obj.DbConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class MsqlTest {

    public static void main(String[] args) {
        try {
            Connection connection = DbConnection.getConnection();
            System.out.println(connection.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}