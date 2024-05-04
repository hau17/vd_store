/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package phonestore.GUI;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import phonestore.BUS.SuplierBUS;
import phonestore.DTO.SuplierDTO;

/**
 *
 * @author congh
 */
// vidu
public class SupplierGUI1 extends javax.swing.JFrame {
    public ArrayList<SuplierDTO> arr;
    public SuplierBUS suplierBUS = new SuplierBUS();
    DefaultTableModel defaultTableModel;
//    TableRowSorter<DefaultTableModel> sorter;

    /**
     * Creates new form SupplierGUI1
     */
    public SupplierGUI1() {
        initComponents();
        arr = new ArrayList<>();
        defaultTableModel = (DefaultTableModel) jTableSuplier.getModel();
        showAllData();
        jTableSuplier.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        setLocationRelativeTo(null);
    }

    public void showAllData() {
        defaultTableModel.setRowCount(0);
        arr = suplierBUS.getAllSuplier();
        for (SuplierDTO suplierDTO : arr) {
            Object[] object = new Object[] {
                    suplierDTO.getSuplierId(), suplierDTO.getSuplierName(),
                    suplierDTO.getEmailAddress(), suplierDTO.getPhoneNumber(),
                    suplierDTO.getAddress()
            };
            defaultTableModel.addRow(object);
        }
    }

    // public void showDataSuplier(int row) {
    // ArrayList<SuplierDTO> arrSearch = ArrObjectInTable();
    // SuplierDTO suplierDTO = arrSearch.get(row);
    // textFieldId.setText(Integer.toString(suplierDTO.getSuplierId()));
    // textFieldName.setText(suplierDTO.getSuplierName());
    // textFieldPhone.setText(suplierDTO.getPhoneNumber());
    // textFieldEmail.setText(suplierDTO.getEmailAddress());
    // textFieldAddress.setText(suplierDTO.getAddress());
    // }

    public void showDataSearch(ArrayList<SuplierDTO> suplierDTOs) {
        defaultTableModel.setRowCount(0);
        ArrayList<SuplierDTO> arrSearch = suplierDTOs;
        for (SuplierDTO suplierDTO : arrSearch) {
            Object[] object = new Object[] {
                    suplierDTO.getSuplierId(), suplierDTO.getSuplierName(),
                    suplierDTO.getEmailAddress(), suplierDTO.getPhoneNumber(),
                    suplierDTO.getAddress()
            };
            defaultTableModel.addRow(object);
        }
    }

    // public ArrayList<SuplierDTO> ArrObjectInTable() {
    // int rowcount = defaultTableModel.getRowCount();
    // ArrayList<SuplierDTO> arr = new ArrayList<>();
    // for (int i = 0; i < rowcount; i++) {
    // Object id = defaultTableModel.getValueAt(i, 0);
    // Object name = defaultTableModel.getValueAt(i, 1);
    // Object emai = defaultTableModel.getValueAt(i, 2);
    // Object phone = defaultTableModel.getValueAt(i, 3);
    // Object address = defaultTableModel.getValueAt(i, 4);
    // SuplierDTO suplierDTO = new SuplierDTO(Integer.parseInt(id.toString()),
    // name.toString(),
    // emai.toString(), phone.toString(), address.toString(), 1);
    // arr.add(suplierDTO);
    // }
    // return arr;
    // }

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
        jButtonProduct = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonCustomer = new javax.swing.JButton();
        jButtonSupplier = new javax.swing.JButton();
        jButtonGRN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jButtonInvoice = new javax.swing.JButton();
        jButtonBrand = new javax.swing.JButton();
        jButtonOrigin = new javax.swing.JButton();
        jButtonWarehouse = new javax.swing.JButton();
        jButtonWarranty = new javax.swing.JButton();
        jButtonRole = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSuplier = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabeId = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelEmal = new javax.swing.JLabel();
        jLabelPhone = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        textFieldEmail = new javax.swing.JTextField();
        textFieldAddress = new javax.swing.JTextField();
        textFieldPhone = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jbuttonExport = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();
        textFieldId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 204, 204));

        jButtonProduct.setBackground(new java.awt.Color(102, 204, 255));
        jButtonProduct.setText("Product");

        jButtonUser.setBackground(new java.awt.Color(102, 204, 255));
        jButtonUser.setText("User");

        jButtonCustomer.setBackground(new java.awt.Color(102, 204, 255));
        jButtonCustomer.setText("Customer");

        jButtonSupplier.setBackground(new java.awt.Color(102, 204, 255));
        jButtonSupplier.setText("Supplier");

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
        jButtonInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInvoiceActionPerformed(evt);
            }
        });

        jButtonBrand.setBackground(new java.awt.Color(102, 204, 255));
        jButtonBrand.setText("Brand");
        jButtonBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrandActionPerformed(evt);
            }
        });

        jButtonOrigin.setBackground(new java.awt.Color(102, 204, 255));
        jButtonOrigin.setText("Origin");
        jButtonOrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOriginActionPerformed(evt);
            }
        });

        jButtonWarehouse.setBackground(new java.awt.Color(102, 204, 255));
        jButtonWarehouse.setText("Warehouse");
        jButtonWarehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWarehouseActionPerformed(evt);
            }
        });

        jButtonWarranty.setBackground(new java.awt.Color(102, 204, 255));
        jButtonWarranty.setText("Warranty");
        jButtonWarranty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWarrantyActionPerformed(evt);
            }
        });

        jButtonRole.setBackground(new java.awt.Color(102, 204, 255));
        jButtonRole.setText("Role");
        jButtonRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRoleActionPerformed(evt);
            }
        });

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
                    .addComponent(jButtonBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOrigin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonWarehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonWarranty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jButtonBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonWarehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonWarranty, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRole, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTableSuplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Email", "Phone", "Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSuplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSuplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSuplier);

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SUPPLIER");

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

        jLabeId.setBackground(new java.awt.Color(255, 255, 255));
        jLabeId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabeId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabeId.setText("Id");

        jLabelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelName.setText("Name");

        jLabelAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddress.setText("Address");

        jLabelEmal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelEmal.setText("Email");

        jLabelPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPhone.setText("Phone");

        textFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonAdd.setBackground(new java.awt.Color(102, 204, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jbuttonExport.setBackground(new java.awt.Color(102, 204, 255));
        jbuttonExport.setText("Export Excel");

        jButtonDelete.setBackground(new java.awt.Color(102, 204, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

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

        jTextFieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonUpdate.setBackground(new java.awt.Color(102, 204, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldName, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldAddress))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldPhone))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldEmail)))
                        .addGap(0, 650, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jTextFieldSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabeId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(textFieldId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldPhone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldAddress))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBrandActionPerformed

    private void jButtonOriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOriginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOriginActionPerformed

    private void jButtonWarehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWarehouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonWarehouseActionPerformed

    private void jButtonWarrantyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWarrantyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonWarrantyActionPerformed

    private void jButtonRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRoleActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        jTextFieldSearch.setText("");
        showAllData();
    }// GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:

        String searString = jTextFieldSearch.getText();
        ArrayList<SuplierDTO> arrayList = suplierBUS.arr_search_suplier(searString);
        showDataSearch(arrayList);
    }// GEN-LAST:event_jButtonSearchActionPerformed

    private void jTableSuplierMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableSuplierMouseClicked
        // TODO add your handling code here:
        int row = jTableSuplier.getSelectedRow();
        if (row != -1) {
            textFieldId.setText(defaultTableModel.getValueAt(row, 0).toString());
            textFieldName.setText(defaultTableModel.getValueAt(row, 1).toString());
            textFieldEmail.setText(defaultTableModel.getValueAt(row, 2).toString());
            textFieldPhone.setText(defaultTableModel.getValueAt(row, 3).toString());
            textFieldAddress.setText(defaultTableModel.getValueAt(row, 4).toString());

        }

    }// GEN-LAST:event_jTableSuplierMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(textFieldId.getText());
        String nameString = textFieldName.getText();
        String phoneString = textFieldPhone.getText();
        String emailString = textFieldEmail.getText();
        String addressString = textFieldAddress.getText();
        SuplierDTO suplierDTO = new SuplierDTO(id, nameString, emailString, phoneString, addressString, 1);
        suplierBUS.update_suplier(suplierDTO);
        showAllData();
    }// GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        int result=JOptionPane.showConfirmDialog(this, "Are you sure you want to delete");
        if(result == JOptionPane.YES_OPTION){
            suplierBUS.delete_suplier(Integer.parseInt(textFieldId.getText()));
            showAllData();
        }
//            suplierBUS.delete_suplier(Integer.parseInt(textFieldId.getText()));
//            showAllData();
    }// GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        SupplierAddGUI supplierAddGUI=new SupplierAddGUI(this, true);
        supplierAddGUI.setVisible(true);
        supplierAddGUI.setLocationRelativeTo(null);

    }// GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonInvoiceActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonInvoiceActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new InvoiceGUI().setVisible(true);
    }// GEN-LAST:event_jButtonInvoiceActionPerformed

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
            java.util.logging.Logger.getLogger(SupplierGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierGUI1.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierGUI1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonBrand;
    private javax.swing.JButton jButtonCustomer;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGRN;
    private javax.swing.JButton jButtonInvoice;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonOrigin;
    private javax.swing.JButton jButtonProduct;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonRole;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonSupplier;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JButton jButtonUser;
    private javax.swing.JButton jButtonWarehouse;
    private javax.swing.JButton jButtonWarranty;
    private javax.swing.JLabel jLabeId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelEmal;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSuplier;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JButton jbuttonExport;
    private javax.swing.JTextField textFieldAddress;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JLabel textFieldId;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldPhone;
    // End of variables declaration//GEN-END:variables
}
