package javaapplication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PharmacyManagement {
    public static void main(String[] args) {
        PharmacyManagement abc = new PharmacyManagement();
        abc.createConnection();
        login main_obj=new login();
        main_obj.setVisible(true);
    }
    
    void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            //Connection con =DriverManager.getConnection("jdbc:derby://localhost:1527/test","root","root");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false","root","12345678");
            String sql= "select * from user where name = 'manthan';";
                    Statement ps=con.createStatement();
                    ResultSet rs= ps.executeQuery(sql);
                    System.out.println(rs);
                    
            System.out.println("Connection established successfully");
        } catch (ClassNotFoundException | SQLException ex) {
            //Logger.getLogger(JAvaapplication.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
