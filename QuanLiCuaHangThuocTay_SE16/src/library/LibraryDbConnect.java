
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import javax.swing.JOptionPane;

public class LibraryDbConnect {
    private Connection conn = null;
    private String user;
    private String password;
    private String url;
    
    public LibraryDbConnect(){
        Properties prop = LibraryPropertiesFile.readFileConfig();
       this.user = prop.getProperty("user");
       this.password = prop.getProperty("password");
       this.url = prop.getProperty("url");
    }
    
    public Connection getConnectMySQL(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Không thể kết nối Database!");
        }
        return conn;
    }
}
