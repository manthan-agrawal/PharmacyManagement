package javaapplication;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class home extends javax.swing.JFrame {

    DefaultTableModel model;
    public home() {
        initComponents(); 
        model = (DefaultTableModel) tbldata.getModel();
    }
    
    void tableInsert(String searchName){
        dbconnect obj;
        String sql = "";
        obj = new dbconnect();
        obj.createConnection();
        if(searchName.isEmpty())
            sql= "SELECT * FROM medicine LIMIT 0;";
        else{ 
            sql= ("SELECT * FROM medicine where name = '"+searchName+"' LIMIT 15;");
            System.out.println(sql);
        }
        Statement ps;
        try {
            ps = obj.con.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            while(rs.next()){
            String name = rs.getString("name");
            System.out.println(name);
            String price = rs.getString("price");
            String quantity_available = rs.getString("quantity_available");
            String type = rs.getString("type");
            String category = rs.getString("category");
            String description = rs.getString("description");     
            model.setRowCount(0);
            model.insertRow(tbldata.getRowCount(),new Object[]{
            name,category,type,quantity_available,price,description 
            }); // altenative for insert  model.setValueAt(name,i,0);
            }
            rs.close();
            ps.close();
            obj.closeConnection(); 
        }catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        obj.closeConnection();                              
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btnAddMeicine = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Category ", "Type", "Quantity Available", "Price", "Description"
            }
        ));
        jScrollPane1.setViewportView(tbldata);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 0, 570, 260));

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 86, -1));

        txtsearch.setText("Enter medicine name");
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });
        getContentPane().add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, -1));

        btnAddMeicine.setText("Add Medicine");
        btnAddMeicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMeicineActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddMeicine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        setSize(new java.awt.Dimension(788, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsearchActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
                String searchName = txtsearch.getText().trim();
                tableInsert(searchName);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnAddMeicineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddMeicineActionPerformed
        // TODO add your handling code here:
        AddMedicine AddMedicine = new AddMedicine();
        AddMedicine.setVisible(true);
    }//GEN-LAST:event_btnAddMeicineActionPerformed

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddMeicine;
    private javax.swing.JButton btnsearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
