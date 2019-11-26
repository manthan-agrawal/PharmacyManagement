package javaapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class dbconnect {
        Connection con;
        
        @SuppressWarnings("empty-statement")
        void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            //Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/test","root","root");
            con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false","root","12345678");                                
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(JAvaapplication.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection cannot be established");
        }
        }
        
        void closeConnection(){
        
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(dbconnect.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
}
