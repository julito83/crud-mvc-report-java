package Config;
import java.sql.*;

public class Conexion {
    
    Connection con;
    public Conexion(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ied", "root", "");
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.err.println("Error: "+ex);
        }
    }
    
    public Connection getConnection(){
        return con;
    }
    
}