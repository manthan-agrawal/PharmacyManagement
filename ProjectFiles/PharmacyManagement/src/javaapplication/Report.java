package javaapplication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class Report extends javax.swing.JFrame {

    public Report() {
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        txt1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txt2 = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txt1.setText("2019-11-29");
        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill No.", "Username", "total", "tax", "discount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt2.setText("2019-12-01");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed

    }//GEN-LAST:event_txt1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
DefaultTableModel model;
       model = (DefaultTableModel) jTable1.getModel();
       dbconnect obj;
       obj = new dbconnect();
       obj.createConnection();
       String sql= ("SELECT  distinct `bill no.`,total,tax,discount,user_name FROM bill \n" +
            "full join user_has_medicine on `bill no.` =user_has_medicine.`Bill_bill no.`\n" +
            "WHERE timestamp BETWEEN \n" +
            "CAST('"+txt1.getText()+"' AS DATE) AND \n" +
            "CAST('"+txt2.getText()+"' AS DATE);");
        System.out.println(sql);
        Statement ps;
        try {
            ps = obj.con.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            model.setRowCount(0);
            while(rs.next()){
            String Username = rs.getString("user_name");
            
            String Bill_no = rs.getString("bill no.");
            
            
            String total = rs.getString("total");
            String tax = rs.getString("tax");
            String discount = rs.getString("discount");
            
            model.insertRow(jTable1.getRowCount(),new Object[]{
            Bill_no,Username,total,tax,discount
            });
            }
            rs.close();
            ps.close();
            obj.closeConnection();
        }catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.closeConnection();
}
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
        
    }//GEN-LAST:event_jButton1ActionPerformed


    void tableinsert()
        {
       DefaultTableModel model;
       model = (DefaultTableModel) jTable1.getModel();
       dbconnect obj;
       obj = new dbconnect();
       obj.createConnection();
       String sql= ("SELECT  distinct `bill no.`,total,tax,discount,user_name FROM bill \n" +
            "full join user_has_medicine on `bill no.` =user_has_medicine.`Bill_bill no.`\n" +
            "WHERE timestamp BETWEEN \n" +
            "CAST('"+txt1.getText()+"' AS DATE) AND \n" +
            "CAST('"+txt2.getText()+"' AS DATE);");
        System.out.println(sql);
        Statement ps;
        try {
            ps = obj.con.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            model.setRowCount(0);
            while(rs.next()){
            String Username = rs.getString("user_name");
            
            String Bill_no = rs.getString("bill no.");
            
            
            String total = rs.getString("total");
            String tax = rs.getString("tax");
            String discount = rs.getString("discount");
            
            model.insertRow(jTable1.getRowCount(),new Object[]{
            Bill_no,Username,total,tax,discount
            });
            }
            rs.close();
            ps.close();
            obj.closeConnection();
        }catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        obj.closeConnection();
        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    // End of variables declaration//GEN-END:variables
}
