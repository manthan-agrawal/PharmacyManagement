package javaapplication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.eclipse.persistence.platform.database.oracle.plsql.OraclePLSQLTypes.Int;

public class login extends javax.swing.JFrame {

    public login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtflname = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        pflpass = new javax.swing.JPasswordField();
        loginAsbox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login and Sign up");

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jButton1.setText("Log in");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sign up");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        pflpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pflpassActionPerformed(evt);
            }
        });

        loginAsbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[--select--]", "pharmacist", "admin" }));
        loginAsbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginAsboxActionPerformed(evt);
            }
        });

        jLabel3.setText("Login as:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pflpass, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtflname, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(loginAsbox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtflname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pflpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(loginAsbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String enteredUsername = txtflname.getText().trim();
        String enteredPassword = pflpass.getText().trim();
        int loginAs =  loginAsbox.getSelectedIndex();
        
        if (enteredUsername.isEmpty())
        {
            if (enteredPassword.isEmpty())
            {
                JOptionPane.showMessageDialog(login.this, "enter the username and password");
                txtflname.grabFocus();
                pflpass.grabFocus();
                return;
            }
            JOptionPane.showMessageDialog(login.this, "enter the username");
            txtflname.grabFocus();
            return;
        }
        if (enteredPassword.isEmpty())
        {
            JOptionPane.showMessageDialog(login.this, "enter the password");
            pflpass.grabFocus();
            return;
        }
         if(loginAs ==0)
        {
            JOptionPane.showMessageDialog(login.this, "please select any option from drop menu!");

        }
         
        
        dbconnect obj;
        obj = new dbconnect();
        obj.createConnection();
        String sql= ("select * from user where name ='"+enteredUsername+"';");
        Statement ps;
        try {
            ps = obj.con.createStatement();
            ResultSet rs= ps.executeQuery(sql);            
            rs.next();
            String username = rs.getString("name");     
            String password = rs.getString("password");     
            int role  = rs.getInt("role");
            if(username.equals(enteredUsername) && password.equals(enteredPassword) && role==loginAs){
                home home = new home(username,"-1");
                home.tableInsert("");
                home.setVisible(true);
                setVisible(false);
                rs.close();
                ps.close();
                obj.closeConnection();                
                return;}
            else{
                JOptionPane.showMessageDialog(login.this, "Enter the correct username and password and select appropriate role");
                txtflname.grabFocus();
                rs.close();
                ps.close();
                obj.closeConnection();                
                return;
            }
        }catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.closeConnection();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        Signup main_obj=new Signup();
        main_obj.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pflpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pflpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pflpassActionPerformed

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseExited

    private void loginAsboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginAsboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginAsboxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox loginAsbox;
    private javax.swing.JPasswordField pflpass;
    private javax.swing.JTextField txtflname;
    // End of variables declaration//GEN-END:variables
}
