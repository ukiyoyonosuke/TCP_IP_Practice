package Portfolio.Control;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by tatsuki on 2017/06/08.
 */
public class Validation {
    ResultSetMetaData resultSetMetaData;
    public static boolean checkID(String user,String pass){
        if(user != null && pass!=null) try {
            ResultSet resultSet = ConnectDB.createSQL("select * from USER1 where name = '" + user + "' and pass = '" + pass +"' ");
//            ResultSet resultSet = ConnectDB.createSQL("select * from USER1 where name = 'a' and pass = 'a'" );
            System.out.println(resultSet.getRow());
            if (resultSet.next()) {
                System.out.println(resultSet.getRow());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        else {
            return false;
        }
    }
    public static boolean is_Admin(String user){
        try {
            ResultSet resultSet = ConnectDB.createSQL("select * from USER1 where name = '" + user + "'");
            if (resultSet.getBoolean(1))
                return true;
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String[] args) {
        System.out.println(checkID("user1","bbbb"));
    }
}
