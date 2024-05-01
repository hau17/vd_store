/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package phonestore.GUI;
import java.math.BigDecimal;
import phonestore.DTO.WareHouseDTO;
import phonestore.BUS.WarehouseBUS;
import java.util.ArrayList;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author congh
 */
public class WarehouseGUI extends javax.swing.JFrame {
    WarehouseBUS warehouseBUS= new WarehouseBUS();
    DefaultTableModel defaultTableModel;
    TableRowSorter<DefaultTableModel> sorter;
    /**
     * Creates new form WarehouseGUI
     */
    public WarehouseGUI() {
        initComponents();
        this.setVisible(true);
        defaultTableModel= (DefaultTableModel) jTableWarehouse.getModel();
        showAllData();
        sorter =new TableRowSorter<>(defaultTableModel);
        jTableWarehouse.setRowSorter(sorter);
        jTableWarehouse.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
    }
    public void showAllData(){
        defaultTableModel.setRowCount(0);
        ArrayList<WareHouseDTO> arrayList= warehouseBUS.getAllWareHouseDTOs();
        for(WareHouseDTO wareHouseDTO : arrayList){
            Object[] objects=new Object[]{wareHouseDTO.getProductId(),wareHouseDTO.getQuantity(),
                wareHouseDTO.getPrice()};
                defaultTableModel.addRow(objects);
        }
    }
    public void showDataSearch(ArrayList<WareHouseDTO> arr){
        defaultTableModel.setRowCount(0);
        for(WareHouseDTO wareHouseDTO : arr){
            Object[] objects = new Object[]{wareHouseDTO.getProductId(),wareHouseDTO.getQuantity(),
                wareHouseDTO.getPrice()     
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

        TextFieldQuantity = new javax.swing.JTextField();
        jLabelEmal = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textFieldSearch = new javax.swing.JTextField();
        textFieldPrice = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonProduct = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonCustomer = new javax.swing.JButton();
        jButtonSupplier = new javax.swing.JButton();
        jButtonGRN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jButtonInvoice = new javax.swing.JButton();
        jButtonInvoice1 = new javax.swing.JButton();
        jButtonInvoice2 = new javax.swing.JButton();
        jButtonInvoice3 = new javax.swing.JButton();
        jButtonInvoice4 = new javax.swing.JButton();
        jButtonInvoice5 = new javax.swing.JButton();
        jButtonAdd = new javax.swing.JButton();
        jLabeId = new javax.swing.JLabel();
        jbuttonExport = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableWarehouse = new javax.swing.JTable();
        jButtonSearch = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        textFieldProductID = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextFieldQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelEmal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelEmal.setText("Price");

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WAREHOUSE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        textFieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));

        jButtonProduct.setBackground(new java.awt.Color(102, 204, 255));
        jButtonProduct.setText("Product");
        jButtonProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductActionPerformed(evt);
            }
        });

        jButtonUser.setBackground(new java.awt.Color(102, 204, 255));
        jButtonUser.setText("User");
        jButtonUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUserActionPerformed(evt);
            }
        });

        jButtonCustomer.setBackground(new java.awt.Color(102, 204, 255));
        jButtonCustomer.setText("Customer");

        jButtonSupplier.setBackground(new java.awt.Color(102, 204, 255));
        jButtonSupplier.setText("Supplier");
        jButtonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupplierActionPerformed(evt);
            }
        });

        jButtonGRN.setBackground(new java.awt.Color(102, 204, 255));
        jButtonGRN.setText("GRN");

        jLabel1.setBackground(new java.awt.Color(51, 204, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/phonestore/GUI/Png/Icon.png"))); // NOI18N

        jButtonLogout.setBackground(new java.awt.Color(102, 204, 255));
        jButtonLogout.setText("Logout");

        jButtonInvoice.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInvoice.setText("Invoice");

        jButtonInvoice1.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInvoice1.setText("Brand");

        jButtonInvoice2.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInvoice2.setText("Origin");

        jButtonInvoice3.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInvoice3.setText("Warehouse");

        jButtonInvoice4.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInvoice4.setText("Warranty");

        jButtonInvoice5.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInvoice5.setText("Role");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonUser, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jButtonCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonGRN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInvoice1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInvoice2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInvoice3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInvoice4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonInvoice5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonGRN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInvoice1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInvoice2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInvoice3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInvoice4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonInvoice5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonAdd.setBackground(new java.awt.Color(102, 204, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jLabeId.setBackground(new java.awt.Color(255, 255, 255));
        jLabeId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabeId.setText("Product ID");

        jbuttonExport.setBackground(new java.awt.Color(102, 204, 255));
        jbuttonExport.setText("Export Excel");
        jbuttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonExportActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(102, 204, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(102, 204, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelName.setText("Quantity");

        jTableWarehouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Quantity", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableWarehouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableWarehouseMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableWarehouse);

        jButtonSearch.setBackground(new java.awt.Color(102, 204, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jButtonRefresh.setBackground(new java.awt.Color(102, 204, 255));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldProductID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabeId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(textFieldProductID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPrice))
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonProductActionPerformed

    private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonUserActionPerformed

    private void jButtonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSupplierActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        new WarehouseAddGUI(this, true).setVisible(true);
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jbuttonExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonExportActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jbuttonExportActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(textFieldProductID.getText());
        int quantity = Integer.parseInt(TextFieldQuantity.getText());
        BigDecimal price = new BigDecimal(textFieldPrice.getText());
        WareHouseDTO wareHouseDTO= new WareHouseDTO(id, quantity, price, 1);
        warehouseBUS.update(wareHouseDTO);
        showAllData();
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(textFieldProductID.getText());
        int quantity = Integer.parseInt(TextFieldQuantity.getText());
        BigDecimal price = new BigDecimal(textFieldPrice.getText());
        WareHouseDTO wareHouseDTO= new WareHouseDTO(id, quantity, price, 1);
        warehouseBUS.delete(wareHouseDTO);
        showAllData();

    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableWarehouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableWarehouseMouseClicked
        // TODO add your handling code here:
        int row = jTableWarehouse.getSelectedRow();
        textFieldProductID.setText(defaultTableModel.getValueAt(sorter.convertRowIndexToModel(row),0).toString());
        TextFieldQuantity.setText(defaultTableModel.getValueAt(sorter.convertRowIndexToModel(row),1).toString());
        textFieldPrice.setText(defaultTableModel.getValueAt(sorter.convertRowIndexToModel(row), 2).toString());
        
        
    }//GEN-LAST:event_jTableWarehouseMouseClicked

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        showDataSearch(warehouseBUS.search(textFieldSearch.getText()));
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        textFieldSearch.setText("");
        showAllData();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(WarehouseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WarehouseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WarehouseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WarehouseGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WarehouseGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldQuantity;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCustomer;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGRN;
    private javax.swing.JButton jButtonInvoice;
    private javax.swing.JButton jButtonInvoice1;
    private javax.swing.JButton jButtonInvoice2;
    private javax.swing.JButton jButtonInvoice3;
    private javax.swing.JButton jButtonInvoice4;
    private javax.swing.JButton jButtonInvoice5;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonProduct;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSupplier;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JLabel jLabeId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEmal;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableWarehouse;
    private javax.swing.JButton jbuttonExport;
    private javax.swing.JTextField textFieldPrice;
    private javax.swing.JLabel textFieldProductID;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
