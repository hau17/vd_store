package phonestore.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCUtil {
    private static JDBCUtil instance = null;
    private static Connection connection = null;
    private static final String url = "jdbc:mysql://localhost:3306/phone_store";
    private static final String username = "root";
    private static final String password = "123";

    private JDBCUtil() {

    }

    public static JDBCUtil getInstance() {
        if (instance == null) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                instance = new JDBCUtil();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeconnection() {
//        if (connection != null) {
//            try{
//                connection.close();
//                connection = null;
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }
}
