/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package phonestore.GUI;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import phonestore.BUS.CustomerBLL;

import phonestore.BUS.InvoiceBUS;
import phonestore.BUS.UserBUS;
import phonestore.DTO.InvoiceDTO;

/**
 *
 * @author congh
 */
public class InvoiceGUI extends javax.swing.JFrame {
        InvoiceBUS invoiceBUS = new InvoiceBUS();
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        CustomerBLL customerBLL = new CustomerBLL();
        UserBUS userBUS = new UserBUS();

        /**
         * Creates new form InvoiceGUI
         */
        public InvoiceGUI() {
                initComponents();
                setLocationRelativeTo(null);
                defaultTableModel = (DefaultTableModel) jTableInvoice.getModel();
                showAllData();
                textFieldInvoiceId.setEditable(false);
        }

        public void showAllData() {
                defaultTableModel.setRowCount(0);
                ArrayList<InvoiceDTO> arr = invoiceBUS.getAllInvoice();
                for (InvoiceDTO invoiceDTO : arr) {
                        Object[] objects = new Object[] { invoiceDTO.getInvoiceId(),
                                        customerBLL.getCustomerNameById(invoiceDTO.getCustomer_id()),
                                        userBUS.getUserNameByID(invoiceDTO.getUserId()), invoiceDTO.getDateOfInvoice(),
                                        invoiceDTO.getTotalAmount() };
                        defaultTableModel.addRow(objects);
                }
        }

        public void showSearchData(String stringSearch) {
                defaultTableModel.setRowCount(0);
                ArrayList<InvoiceDTO> arrayList = invoiceBUS.arrSearch(stringSearch);
                for (InvoiceDTO invoiceDTO : arrayList) {
                        Object[] objects = new Object[] { invoiceDTO.getInvoiceId(),
                                        customerBLL.getCustomerNameById(invoiceDTO.getCustomer_id()),
                                        userBUS.getUserNameByID(invoiceDTO.getUserId()), invoiceDTO.getDateOfInvoice(),
                                        invoiceDTO.getTotalAmount() };
                        defaultTableModel.addRow(objects);
                }
        }

        public int createNewID() {
                return invoiceBUS.getLastInvoiceID();
        }

        public int getId() {
                return Integer.parseInt(textFieldInvoiceId.getText());
        }

        public String getCustomer() {
                return TextFieldCustomer.getText();
        }

        public String getTotalAmount() {
                return textFieldTotalAmount.getText();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textFieldUser = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jLabeId = new javax.swing.JLabel();
        jbuttonExport = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jLabelEmal = new javax.swing.JLabel();
        textFieldSearch = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButtonProduct = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonCustomer = new javax.swing.JButton();
        jButtonSupplier = new javax.swing.JButton();
        jButtonGRN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jButtonInvoice = new javax.swing.JButton();
        jButtonInfor = new javax.swing.JButton();
        textFieldInvoiceId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInvoice = new javax.swing.JTable();
        TextFieldCustomer = new javax.swing.JTextField();
        textFieldDate = new javax.swing.JTextField();
        textFieldTotalAmount = new javax.swing.JTextField();
        jLabelPhone1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INVOICE");

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

        textFieldUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
        jLabeId.setText("Invoice ID");

        jbuttonExport.setBackground(new java.awt.Color(102, 204, 255));
        jbuttonExport.setText("Export Excel");
        jbuttonExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonExportActionPerformed(evt);
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
        jLabelName.setText("Customer");

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

        jLabelEmal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelEmal.setText("User");

        textFieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPhone.setText("totalAmount");

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
                    .addComponent(jButtonInvoice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButtonUser, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButtonCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButtonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonGRN, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButtonInfor.setBackground(new java.awt.Color(102, 204, 255));
        jButtonInfor.setText("Infor");
        jButtonInfor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInforActionPerformed(evt);
            }
        });

        textFieldInvoiceId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTableInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Customer", "User", "date Of Invoice", "Total amount"
            }
        ));
        jTableInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInvoiceMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableInvoice);

        TextFieldCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelPhone1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPhone1.setText("Date");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextFieldCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldInvoiceId, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114)
                        .addComponent(textFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldInvoiceId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextFieldCustomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldUser))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInfor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void jbuttonExportActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jbuttonExportActionPerformed
                // TODO add your handling code here:
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
                fileChooser.setDialogTitle("save file");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                        String path = fileChooser.getSelectedFile().getPath() + ".pdf";
                        invoiceBUS.exportExcel(path, Integer.parseInt(textFieldInvoiceId.getText()));
                }

        }// GEN-LAST:event_jbuttonExportActionPerformed

        private void jButtonProductActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonProductActionPerformed
                // TODO add your handling code here:
                this.dispose();
                new ProductGUI().setVisible(true);
        }// GEN-LAST:event_jButtonProductActionPerformed

        private void jButtonUserActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUserActionPerformed
                // TODO add your handling code here:
                this.dispose();
                new UserGUI().setVisible(true);
        }// GEN-LAST:event_jButtonUserActionPerformed

        private void jButtonSupplierActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSupplierActionPerformed
                // TODO add your handling code here:
                this.dispose();
                new SupplierGUI1().setVisible(true);

        }// GEN-LAST:event_jButtonSupplierActionPerformed

        private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddActionPerformed
                // TODO add your handling code here:
                InvoicDetailGUI invoicDetailGUI = new InvoicDetailGUI(this, true);
                invoicDetailGUI.setLocationRelativeTo(null);
                invoicDetailGUI.setVisible(true);

        }// GEN-LAST:event_jButtonAddActionPerformed

        private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDeleteActionPerformed
                // TODO add your handling code here:
                invoiceBUS.deleteInvoice(Integer.parseInt(textFieldInvoiceId.getText()));
                showAllData();

        }// GEN-LAST:event_jButtonDeleteActionPerformed

        private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
                // TODO add your handling code here:
                showSearchData(textFieldSearch.getText());
        }// GEN-LAST:event_jButtonSearchActionPerformed

        private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonRefreshActionPerformed
                // TODO add your handling code here:
                textFieldSearch.setText("");
                showAllData();
        }// GEN-LAST:event_jButtonRefreshActionPerformed

        private void jButtonInforActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUpdateActionPerformed
                // TODO add your handling code here:
                InvoiceDetailInformationGUI informationGUI = new InvoiceDetailInformationGUI(this, true);
                informationGUI.setVisible(true);

        }// GEN-LAST:event_jButtonUpdateActionPerformed

        private void jTableInvoiceMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableInvoiceMouseClicked
                // TODO add your handling code here:
                int row = jTableInvoice.getSelectedRow();
                if (row != -1) {
                        textFieldInvoiceId.setText(defaultTableModel.getValueAt(row, 0).toString());
                        TextFieldCustomer.setText(defaultTableModel.getValueAt(row, 1).toString());
                        textFieldUser.setText(defaultTableModel.getValueAt(row, 2).toString());
                        textFieldDate.setText(defaultTableModel.getValueAt(row, 3).toString());
                        textFieldTotalAmount.setText(defaultTableModel.getValueAt(row, 4).toString());

                }
        }// GEN-LAST:event_jTableInvoiceMouseClicked

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
                        java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(InvoiceGUI.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new InvoiceGUI().setVisible(true);
                        }
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldCustomer;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCustomer;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGRN;
    private javax.swing.JButton jButtonInfor;
    private javax.swing.JButton jButtonInvoice;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonProduct;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSupplier;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JLabel jLabeId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEmal;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JLabel jLabelPhone1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInvoice;
    private javax.swing.JButton jbuttonExport;
    private javax.swing.JTextField textFieldDate;
    private javax.swing.JTextField textFieldInvoiceId;
    private javax.swing.JTextField textFieldSearch;
    private javax.swing.JTextField textFieldTotalAmount;
    private javax.swing.JTextField textFieldUser;
    // End of variables declaration//GEN-END:variables

}
