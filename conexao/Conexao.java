package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexao {
  private Connection con = null;
  private String hostName = null;
  private String userName = null;
  private String password = null;
  private String url = null;
  private String jdbcDriver = null;
  private String dataBaseName = null;
  private String dataBasePrefix = null;
  private String dataBasePort = null;

    public Conexao() {
        hostName = "localhost";
        userName = "root";
        password = "BASH$634pcpv!!";
        jdbcDriver = "org.mariadb.jdbc.Driver";//"com.mysql.jdbc.Driver";
        dataBaseName = "db_construfeira";
        dataBasePrefix = "jdbc:mariadb://";
        dataBasePort = "3307";
        url = dataBasePrefix + hostName + ":"+dataBasePort+"/" + dataBaseName;
    }
  
    
    public Connection getConnection() {
        try {
            if (con == null) {
                Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, userName, password);
            } else if (con.isClosed()) {
                con = null;      
                return getConnection();
            }            
        } catch (ClassNotFoundException | SQLException e) {
        }
      // e.printStackTrace();
        return con;
    }
    
    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }
   
    }
}
