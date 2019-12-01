package javaapplication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.Date;


public class home extends javax.swing.JFrame {
    String user;
    String bill_no;
    DefaultTableModel model;
    
    public home(String username, String bill_number  ) {
        initComponents(); 
        model = (DefaultTableModel) tbldata.getModel();
        user =username;
        bill_no = bill_number;
        
        if(bill_no.equals("-1")){
            dbconnect obj;
            obj = new dbconnect();
            obj.createConnection();
            String sql= ("SELECT MAX(`bill no.`) FROM mydb.bill;");
            Statement ps;
            try {
                ps = obj.con.createStatement();
                ResultSet rs= ps.executeQuery(sql);            
                rs.next();
                bill_no = rs.getString("MAX(`bill no.`)");
                bill_no = String.valueOf(Integer.parseInt(bill_no)+1);
                rs.close();
                ps.close();                
            }catch (SQLException ex) {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
            obj.closeConnection();
        }
    }

    private home() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void tableInsert(String searchName){
        String sql;
        dbconnect obj;
        obj = new dbconnect();
        obj.createConnection();
        if(searchName.isEmpty())
            sql= "SELECT * FROM medicine LIMIT 20;";
        else{ 
            sql= ("SELECT * FROM medicine where name LIKE '"+searchName+"%' LIMIT 20;");
        }
        Statement ps;
        try {
            ps = obj.con.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            model.setRowCount(0);
            while(rs.next()){
            String name = rs.getString("name");
            String price = rs.getString("price");
            String quantity_available = rs.getString("quantity_available");
            String type = rs.getString("type");
            String category = rs.getString("category");
            String description = rs.getString("description");            
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

        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldata = new javax.swing.JTable();
        btnsearch = new javax.swing.JButton();
        txtsearch = new javax.swing.JTextField();
        btnAddMeicine = new javax.swing.JButton();
        AddDoctor = new javax.swing.JButton();
        AddCompany = new javax.swing.JButton();
        btnGenerateBill = new javax.swing.JButton();
        btnCart = new javax.swing.JButton();
        txtQunatity = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnReport = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");

        tbldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Category ", "Type", "Quantity Available", "Price", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldata.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(tbldata);

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        txtsearch.setText("Enter medicine name");
        txtsearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtsearchMouseClicked(evt);
            }
        });
        txtsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsearchActionPerformed(evt);
            }
        });

        btnAddMeicine.setText("Add Medicine");
        btnAddMeicine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddMeicineActionPerformed(evt);
            }
        });

        AddDoctor.setText("Add Doctor");
        AddDoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDoctorActionPerformed(evt);
            }
        });

        AddCompany.setText("Add Company");
        AddCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCompanyActionPerformed(evt);
            }
        });

        btnGenerateBill.setText("Generate Bill");
        btnGenerateBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateBillActionPerformed(evt);
            }
        });

        btnCart.setText("Add To Cart");
        btnCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartActionPerformed(evt);
            }
        });

        txtQunatity.setText("Quantity");
        txtQunatity.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtQunatityMouseClicked(evt);
            }
        });
        txtQunatity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQunatityActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("MODIY DATABSE:");

        btnReport.setText("Report");
        btnReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("REPORT:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtQunatity, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnCart)
                        .addGap(201, 201, 201)
                        .addComponent(btnGenerateBill, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnReport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddMeicine, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AddCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnsearch))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtQunatity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCart)
                    .addComponent(btnGenerateBill))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReport)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AddDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddMeicine, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddCompany, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(506, 508));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsearchActionPerformed
        // TODO add your handling code here:
        txtsearch.setText("");
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

    private void btnGenerateBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateBillActionPerformed
        // TODO add your handling code here:
        bill bill = new bill(bill_no,user);
        bill.createTable("");
        bill.setVisible(true);
        dispose();
       
    }//GEN-LAST:event_btnGenerateBillActionPerformed

    private void AddDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDoctorActionPerformed
        // TODO add your handling code here:
        AddDoctor addDoctor = new AddDoctor();
        addDoctor.setVisible(true);
    }//GEN-LAST:event_AddDoctorActionPerformed

    private void AddCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCompanyActionPerformed
        // TODO add your handling code here:
        AddCompany addCompany = new AddCompany();
        addCompany.setVisible(true);
    }//GEN-LAST:event_AddCompanyActionPerformed

    private void btnCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartActionPerformed

        int row;
        String billNumberCheck;
        row = tbldata.getSelectedRow();
        String med_name = tbldata.getModel().getValueAt(row, 0).toString();

        dbconnect obj;
        obj = new dbconnect();
        obj.createConnection();
                     
        try{
            
            String sql2= ("SELECT MAX(`bill no.`) FROM mydb.bill;");
            Statement ps;
            ps = obj.con.createStatement();
            ResultSet rs= ps.executeQuery(sql2);            
            rs.next();
            billNumberCheck = rs.getString("MAX(`bill no.`)");
            rs.close();
            ps.close();                    
            System.out.println(billNumberCheck);
            System.out.println(bill_no);
            
            
            if(!billNumberCheck.equals(bill_no)){
                String sql1= ("insert into bill values (?, ?, ?, ?, ?)");
                PreparedStatement pstmt1  = obj.con.prepareStatement(sql1);
                pstmt1.setString(1, bill_no);
                pstmt1.setInt(2, 0);
                pstmt1.setInt(3, 0);
                pstmt1.setInt(4, 0);  
                Date date= new Date();
                long time = date.getTime();
                Timestamp ts = new Timestamp(time);
                pstmt1.setString(5,String.valueOf(ts));
                pstmt1.executeUpdate();
            }       
            
            
            String sql= ("insert into user_has_medicine values (?, ?, ?, ?)");
            PreparedStatement pstmt  = obj.con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, med_name);
            pstmt.setString(3, bill_no);
            pstmt.setInt(4, Integer.parseInt(txtQunatity.getText()));          
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Insertion Successful");
            txtQunatity.setText("");            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }        
        obj.closeConnection();
        
    }//GEN-LAST:event_btnCartActionPerformed

    private void txtQunatityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQunatityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQunatityActionPerformed

    private void txtQunatityMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtQunatityMouseClicked
        // TODO add your handling code here:
        
        txtQunatity.setText("");
    }//GEN-LAST:event_txtQunatityMouseClicked

    private void txtsearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtsearchMouseClicked
        // TODO add your handling code here:
        txtsearch.setText("");
    }//GEN-LAST:event_txtsearchMouseClicked

    private void btnReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportActionPerformed
        // TODO add your handling code here:
        Report reportobj = new Report();
        reportobj.tableinsert();
        reportobj.setVisible(true);
    }//GEN-LAST:event_btnReportActionPerformed

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

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new home().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCompany;
    private javax.swing.JButton AddDoctor;
    private javax.swing.JButton btnAddMeicine;
    private javax.swing.JButton btnCart;
    private javax.swing.JButton btnGenerateBill;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldata;
    private javax.swing.JTextField txtQunatity;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables
}
