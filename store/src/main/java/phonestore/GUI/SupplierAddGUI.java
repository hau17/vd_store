/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package phonestore.GUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import phonestore.BUS.SuplierBUS;
import phonestore.CHECK.Check;
import phonestore.DAO.SuplierDAO;
import phonestore.DTO.SuplierDTO;

/**
 *
 * @author congh
 */
public class SupplierAddGUI extends javax.swing.JDialog {
        SuplierBUS suplierBUS = new SuplierBUS();

        /**
         * Creates new form SupplierAddGUI
         */
        public SupplierAddGUI(java.awt.Frame parent, boolean modal) {
                super(parent, modal);
                initComponents();
//                supplierGUI1 = (SupplierGUI1) parent;
                jTextFieldID.setText(Integer.toString(suplierBUS.getLastSupplierID()));
                this.setLocationRelativeTo(null);
        }
        public boolean checkEmpty(){
            boolean check= true;
            if(jTextFieldName.getText().isEmpty() || jTextFieldPhone.getText().isEmpty() ||
                    jTextFieldEmail.getText().isEmpty() || jTextFieldAddress.getText().isEmpty()){
                JOptionPane.showMessageDialog(rootPane, "not allowed Empty");
                check = false;
            }
            return check;
        }
        public boolean checkEmail(String email){
            boolean check = true;
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern=Pattern.compile(emailRegex);
            Matcher matcher =pattern.matcher(email);
            if(!matcher.matches()){
                JOptionPane.showMessageDialog(rootPane, "invalid email");
                check=false;
            }
            return check;
        }
        public boolean checkPhoneNumer(String number){
            if (!Check.checkPhoneNumber(number)) {
                JOptionPane.showMessageDialog(rootPane, "invalid phone number");
            }
            return Check.checkPhoneNumber(number);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldPhone = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Supplier ID");

        jLabel4.setText("Supplier Name");

        jLabel5.setText("Email");
        jLabel5.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel6.setText("Phone Number");
        jLabel6.setPreferredSize(new java.awt.Dimension(80, 16));

        jLabel7.setText("Address");
        jLabel7.setPreferredSize(new java.awt.Dimension(80, 16));

        jTextFieldPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPhoneActionPerformed(evt);
            }
        });

        jButtonAdd.setBackground(new java.awt.Color(0, 102, 102));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonExit.setBackground(new java.awt.Color(0, 102, 102));
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPhone)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jTextFieldID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldName)
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextFieldAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jTextFieldPhoneActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldPhoneActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_jTextFieldPhoneActionPerformed

        private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddActionPerformed
                // TODO add your handling code here:
                int id = Integer.parseInt(jTextFieldID.getText());
                String nameString = jTextFieldName.getText();
                String phoneString = jTextFieldPhone.getText();
                String emailString = jTextFieldEmail.getText();
                String addressString = jTextFieldAddress.getText();
                    if(checkEmpty() && checkEmail(emailString) && checkPhoneNumer(phoneString)){
                        SuplierDTO suplierDTO = new SuplierDTO(id, nameString, emailString, phoneString, addressString, 1);
                    boolean check=suplierBUS.add_suplier(suplierDTO);
                    if (check) {
                        JOptionPane.showMessageDialog(rootPane, "Add success");
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Error");
                    }
                }       
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Error");
                    }
        }// GEN-LAST:event_jButtonAddActionPerformed

        private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonExitActionPerformed
                // TODO add your handling code here:
                this.dispose();
        }// GEN-LAST:event_jButtonExitActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(SupplierAddGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(SupplierAddGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(SupplierAddGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(SupplierAddGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the dialog */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                SupplierAddGUI dialog = new SupplierAddGUI(new javax.swing.JFrame(), true);
                                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                                        @Override
                                        public void windowClosing(java.awt.event.WindowEvent e) {
                                                System.exit(0);
                                        }
                                });
                                dialog.setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JLabel jTextFieldID;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPhone;
    // End of variables declaration//GEN-END:variables
}
