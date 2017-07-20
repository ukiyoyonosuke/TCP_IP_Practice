package Portfolio.Control;

import java.sql.*;

/**
 * Created by tatsuki on 2017/06/08.
 */
public class ConnectDB {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static ResultSet createSQL(String sql){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql:localhost:5432/register","postgres","6341");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
