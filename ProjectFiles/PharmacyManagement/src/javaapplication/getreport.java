/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Manthan
 */
public class getreport {
    public static void main(String[] args)
    {
        dbconnect obj;
            obj = new dbconnect();
            obj.createConnection();
            CallableStatement mystmt = null;
            
            try
            {
                String name="crocin";
                System.out.println("Medicine name is"+name);
                mystmt=obj.con.prepareCall("{call new_procedure(?,?)}");
                mystmt.setString(1,name);
                System.out.println("Calling the procedure");
                mystmt.execute();
                System.out.println("Finish calling procedure");
                obj.closeConnection();
                mystmt.close();
                
                
            }
            
            catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.closeConnection();
    }
    
}
