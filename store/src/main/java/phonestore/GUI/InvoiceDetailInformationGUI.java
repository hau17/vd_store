/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package phonestore.GUI;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import phonestore.BUS.InvoiceDetailBUS;
import phonestore.BUS.ProductBLL;
import phonestore.DTO.invoiceDetailDTO;

/**
 *
 * @author congh
 */
public class InvoiceDetailInformationGUI extends javax.swing.JDialog {
    ProductBLL productBLL=new ProductBLL();
    DefaultTableModel defaultTableModel;
    InvoiceDetailBUS invoiceDetailBUS;
    InvoiceGUI invoiceGUI;

    /**
     * Creates new form InvoiceDetailInformationGUI
     */
    public InvoiceDetailInformationGUI(java.awt.Frame parent, boolean modal, int invoiceID) {
        super(parent, modal);
//        this.invoiceGUI = (InvoiceGUI) parent;
        initComponents();
        setInvoiceId(invoiceID);
//        setCustomer();
//        setTotalAmount();
        defaultTableModel = (DefaultTableModel) jTableProduct.getModel();
        invoiceDetailBUS = new InvoiceDetailBUS();
        showAllData();
    }
    
    public void setInvoiceId(int id) {
        
        jTextFieldInvoiceId.setText(Integer.toString(id));
    }

    public void showAllData() {
        defaultTableModel.setRowCount(0);
        ArrayList<invoiceDetailDTO> arrayList = invoiceDetailBUS
                .arrShowDetailDTOByID(Integer.parseInt(jTextFieldInvoiceId.getText()));
        for (invoiceDetailDTO invoiceDetailDTO : arrayList) {
            Object[] objects = new Object[] { invoiceDetailDTO.getProductId(),productBLL.getProductDTO(invoiceDetailDTO.getProductId()).getProduct_name(),
                    invoiceDetailDTO.getQuantity(),
                    invoiceDetailDTO.getPrice() };
            defaultTableModel.addRow(objects);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldInvoiceId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ProductID", "Product Name", "Quantity", "Price"
            }
        ));
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProduct);

        jLabel2.setText("Invoice ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldInvoiceId, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addGap(511, 549, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldInvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
        
    }// GEN-LAST:event_jTableProductMouseClicked

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InvoiceDetailInformationGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoiceDetailInformationGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoiceDetailInformationGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoiceDetailInformationGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                InvoiceDetailInformationGUI dialog = new InvoiceDetailInformationGUI(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JLabel jTextFieldInvoiceId;
    // End of variables declaration//GEN-END:variables
}
