package by.util;
import java.sql.*;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;




public class ConnectorDB {
    private static final Logger LOGGER = Logger.getLogger(ConnectorDB.class.getName());
    public static Connection getConnection() throws SQLException {
       try {
           Class.forName("com.mysql.jdbc.Driver");
       }
        catch (ClassNotFoundException e){
           e.printStackTrace();
        }
        ResourceBundle resource = ResourceBundle.getBundle("db", Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        LOGGER.info("connection establish");
        return DriverManager.getConnection(url, user, pass);
    }
}
