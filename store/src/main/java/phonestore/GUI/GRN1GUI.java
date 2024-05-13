/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package phonestore.GUI;

import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import phonestore.BUS.GRNBUS;
import phonestore.BUS.SuplierBUS;
import phonestore.BUS.UserBUS;
import phonestore.DTO.GRNDTO;

/**
 *
 * @author congh
 */
public class GRN1GUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form GRN1GUI
     */
        GRNBUS grnbus=new GRNBUS();
    DefaultTableModel defaultTableModel = new DefaultTableModel();
    SuplierBUS suplierBUS=new SuplierBUS();
    UserBUS userBUS = new UserBUS();
    
    
    TableRowSorter<DefaultTableModel> sorter;

    public GRN1GUI() {
        initComponents();
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui =(BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        defaultTableModel= (DefaultTableModel) jTableGRN.getModel();
        jTableGRN.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        showAllData();
    }
    public void showAllData() {
        defaultTableModel.setRowCount(0);
        for (GRNDTO grndto: grnbus.getAllGRN()) {
            Object[] objects = new Object[] { 
                grndto.getGRN_id(),suplierBUS.getSuplierDTOByID(grndto.getSupplier_id()).getSuplierName(),grndto.getInput_day(),
                userBUS.getUserNameByID(grndto.getUser_id()),grndto.getTotal_amount()
            };
            defaultTableModel.addRow(objects);
        }
    }
        public void showSearchData(String stringSearch) {
        defaultTableModel.setRowCount(0);
        for (GRNDTO grndto: grnbus.searchGRN(stringSearch)) {
            Object[] objects = new Object[] { 
                grndto.getGRN_id(),suplierBUS.getSuplierDTOByID(grndto.getSupplier_id()).getSuplierName(),grndto.getInput_day(),
                userBUS.getUserNameByID(grndto.getUser_id()),grndto.getTotal_amount()
            };
            defaultTableModel.addRow(objects);
        }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabeId = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelEmal = new javax.swing.JLabel();
        jLabelPhone1 = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        jButtonAdd = new javax.swing.JButton();
        jButtonInfor = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jbuttonExport = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableGRN = new javax.swing.JTable();
        jLabelGRNID = new javax.swing.JLabel();
        jLabelSupplier = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelTotalAmount = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1010, 614));

        jLabeId.setBackground(new java.awt.Color(255, 255, 255));
        jLabeId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabeId.setText("GRN ID");

        jLabelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelName.setText("Supplier");

        jLabelEmal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelEmal.setText("Date");

        jLabelPhone1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPhone1.setText("User");

        jLabelPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPhone.setText("totalAmount");

        jButtonAdd.setBackground(new java.awt.Color(0, 102, 102));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonInfor.setBackground(new java.awt.Color(0, 102, 102));
        jButtonInfor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInfor.setText("Infor");
        jButtonInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInforActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 102, 102));
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jbuttonExport.setBackground(new java.awt.Color(0, 102, 102));
        jbuttonExport.setForeground(new java.awt.Color(255, 255, 255));
        jbuttonExport.setText("Export PDF");
        jbuttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonExportActionPerformed(evt);
            }
        });

        textFieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonSearch.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonRefresh.setBackground(new java.awt.Color(0, 102, 102));
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jTableGRN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "GRN Id", "Supplier", "Date", "User ", "Total amount"
            }
        ));
        jTableGRN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGRNMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableGRN);
        if (jTableGRN.getColumnModel().getColumnCount() > 0) {
            jTableGRN.getColumnModel().getColumn(4).setHeaderValue("Total amount");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 986, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelGRNID, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addComponent(jLabelDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(114, 114, 114)
                            .addComponent(textFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 311, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelGRNID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelUser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(438, 438, 438)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        GRNAddGUI grnagui=new GRNAddGUI((DashBoard) SwingUtilities.getWindowAncestor(this), true);
        grnagui.setLocationRelativeTo(null);
        grnagui.setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonInforActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInforActionPerformed
        // TODO add your handling code here:
        GRNInformationGUI gRNInformationGUI=new GRNInformationGUI((DashBoard) SwingUtilities.getWindowAncestor(this), true, Integer.parseInt(jLabelGRNID.getText()));
        gRNInformationGUI.setVisible(true);
    }//GEN-LAST:event_jButtonInforActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int result =JOptionPane.showConfirmDialog(this, "do you want to delete");
        if(result == JOptionPane.YES_OPTION){
            grnbus.deleteGRNBUS(grnbus.getGRNByID(Integer.parseInt(jLabelGRNID.getText())));
            showAllData();
            JOptionPane.showMessageDialog(rootPane, "delete success");
        }

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jbuttonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonExportActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser=new JFileChooser();
        FileNameExtensionFilter filter=new FileNameExtensionFilter("PDF Files", "pdf");
        fileChooser.setFileFilter(filter);
        int result= fileChooser.showSaveDialog(this);
        if(result==JFileChooser.APPROVE_OPTION){
            String path =fileChooser.getSelectedFile().getPath()+".pdf";
            
            try {
                grnbus.exportPdf(path, Integer.parseInt(jLabelGRNID.getText()));
                JOptionPane.showMessageDialog(rootPane, "export Excel success");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "error:"+e.getMessage(),"error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbuttonExportActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        showSearchData(textFieldSearch.getText());
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        textFieldSearch.setText("");
        showAllData();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jTableGRNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGRNMouseClicked
        // TODO add your handling code here:
        int row=jTableGRN.getSelectedRow();
        jLabelGRNID.setText(defaultTableModel.getValueAt(row, 0).toString());
        jLabelSupplier.setText(defaultTableModel.getValueAt(row, 1).toString());
        jLabelDate.setText(defaultTableModel.getValueAt(row, 2).toString());
        jLabelUser.setText(defaultTableModel.getValueAt(row, 3).toString());
        jLabelTotalAmount.setText(defaultTableModel.getValueAt(row, 4).toString());
        
    }//GEN-LAST:event_jTableGRNMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInfor;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JLabel jLabeId;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEmal;
    private javax.swing.JLabel jLabelGRNID;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelPhone1;
    private javax.swing.JLabel jLabelSupplier;
    private javax.swing.JLabel jLabelTotalAmount;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableGRN;
    private javax.swing.JButton jbuttonExport;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
