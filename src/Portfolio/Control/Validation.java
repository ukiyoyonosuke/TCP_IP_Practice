package Portfolio.Control;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * Created by tatsuki on 2017/06/08.
 */
public class Validation {
    ResultSetMetaData resultSetMetaData;
    public static Boolean checkID(String user,String pass){
        if(user != null && pass!=null){
            try {
                ResultSet resultSet = ConnectDB.createSQL("select * from USER1 where name = " + user + " and pass = " + pass );
                System.out.println(resultSet.getMetaData().getColumnCount());
                if (resultSet.getMetaData().getColumnCount() == 1){
                    return true;
                }else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        checkID("user1","bbbb");
    }
}
