package Portfolio.Control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tatsuki on 2017/06/08.
 */
public class ConnectDB {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static ResultSet createSQL(String sql)throws Exception{
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/register","postgres","6341");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static void main(String[] args) {
        try {
            createSQL("select * from user1");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            List<String> fields = new ArrayList<String>();
//            System.out.println(resultSetMetaData.getColumnCount());
//            System.out.println(resultSetMetaData.getColumnName(1));
//            System.out.println(resultSetMetaData.getSchemaName(1));
//            System.out.println(resultSetMetaData.getCatalogName(1));
//            System.out.println(resultSetMetaData.getColumnType(1));
//            System.out.println(resultSetMetaData.getColumnTypeName(1));
//            System.out.println(resultSetMetaData.getColumnClassName(1));
//            System.out.println(resultSet.getFetchSize());
            for(int i = 1; i < resultSetMetaData.getColumnCount(); i++){
                fields.add(resultSetMetaData.getColumnName(i));
            }
            System.out.println(resultSetMetaData.getTableName(1));
            while (resultSet.next()){
                try {
                    for(String field : fields){
                        System.out.println("a");
                        System.out.println(resultSet.getRow());
                        System.out.println(field + ":" + resultSet.getString(field));
                    }
                    System.out.println(resultSet.getString(1));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
