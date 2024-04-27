/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package phonestore.GUI;

import java.io.BufferedReader;
import java.io.File;
import java.util.Vector;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import phonestore.BUS.ProductBLL;
import phonestore.DTO.ProductDTO;

/**
 *
 * @author congh
 */
public class ProductGUI extends javax.swing.JFrame {
    ProductBLL productBLL = new ProductBLL();
    DefaultTableModel defaultTableModel;

    /**
     * Creates new form ProductGUI
     */
    public ProductGUI() {
        initComponents();
        defaultTableModel = (DefaultTableModel) jTableProduct.getModel();
        setLocationRelativeTo(null);
        showAllData();
    }

    public void showAllData() {
        defaultTableModel.setRowCount(0);
        Vector<ProductDTO> arr = productBLL.getAllProducts();
        for (ProductDTO productDTO : arr) {
            Object[] objects = new Object[] { productDTO.getProduct_id(), productDTO.getProduct_name(),
                    productDTO.getRam(), productDTO.getRom(), productDTO.getBattery_capacity(),
                    productDTO.getChip(), productDTO.getBrand_id(), productDTO.getOrigin_id(),
                    productDTO.getImage_path() };
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonAddImg = new javax.swing.JButton();
        jLabelAddress = new javax.swing.JLabel();
        jButtonRefresh = new javax.swing.JButton();
        jLabelEmal = new javax.swing.JLabel();
        textfieldSearch = new javax.swing.JTextField();
        jLabelPhone = new javax.swing.JLabel();
        jButtonUpdate = new javax.swing.JButton();
        textFieldName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        textFieldRam = new javax.swing.JTextField();
        textFieldChip = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButtonProduct = new javax.swing.JButton();
        jButtonUser = new javax.swing.JButton();
        jButtonCustomer = new javax.swing.JButton();
        jButtonSupplier = new javax.swing.JButton();
        jButtonGRN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();
        jButtonInvoice = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textFieldRom = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jLabeId = new javax.swing.JLabel();
        jbuttonExport = new javax.swing.JButton();
        textFieldId = new javax.swing.JTextField();
        jButtonDelete = new javax.swing.JButton();
        jLabelName = new javax.swing.JLabel();
        jLabelAddress1 = new javax.swing.JLabel();
        jLabelAddress2 = new javax.swing.JLabel();
        jLabelAddress3 = new javax.swing.JLabel();
        textFieldBattery = new javax.swing.JTextField();
        textFieldBrand = new javax.swing.JTextField();
        textFieldOrigin = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabelImg = new javax.swing.JLabel();
        textFieldLink = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAddImg.setBackground(new java.awt.Color(102, 204, 255));
        jButtonAddImg.setText("Choose Image");
        jButtonAddImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddImgActionPerformed(evt);
            }
        });

        jLabelAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddress.setText("Battery capacity");

        jButtonRefresh.setBackground(new java.awt.Color(102, 204, 255));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jLabelEmal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEmal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelEmal.setText("Ram");

        textfieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabelPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPhone.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPhone.setText("Rom");

        jButtonUpdate.setBackground(new java.awt.Color(102, 204, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        textFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Ram", "Rom", "Battery capacity", "Chip", "Brand ID", "Origin ID", "Image"
            }
        ));
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProduct);
        if (jTableProduct.getColumnModel().getColumnCount() > 0) {
            jTableProduct.getColumnModel().getColumn(7).setResizable(false);
        }

        textFieldRam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldChip.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Product");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        textFieldRom.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

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
        jLabeId.setText("Id");

        jbuttonExport.setBackground(new java.awt.Color(102, 204, 255));
        jbuttonExport.setText("Export Excel");

        textFieldId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonDelete.setBackground(new java.awt.Color(102, 204, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jLabelName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelName.setText("Name");

        jLabelAddress1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAddress1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddress1.setText("Chip");

        jLabelAddress2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAddress2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddress2.setText("Brand ID");

        jLabelAddress3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAddress3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAddress3.setText("Origin ID");

        textFieldBattery.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldBrand.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        textFieldOrigin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButtonSearch.setBackground(new java.awt.Color(102, 204, 255));
        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabelImg.setBackground(new java.awt.Color(255, 255, 255));
        jLabelImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        textFieldLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldLinkActionPerformed(evt);
            }
        });

        jLabel2.setText("LINK");

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
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldOrigin, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96)
                        .addComponent(textfieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldChip, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldId, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldName))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldBattery))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldRom))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textFieldRam)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelImg, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(textFieldLink))
                        .addGap(167, 167, 167)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabeId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelEmal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldRam))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldRom))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldBattery))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldChip))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelAddress2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldBrand))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelAddress3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textFieldOrigin))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textFieldLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbuttonExport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textfieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textFieldLinkActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldLinkActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldLinkActionPerformed

    private void jButtonAddImgActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddImgActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            textFieldLink.setText(file.getAbsolutePath());
            BufferedImage bufferedImage;
            try {
                bufferedImage = ImageIO.read(file);
                Image image = bufferedImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                jLabelImg.setIcon(new ImageIcon(image));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "please choose file again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }// GEN-LAST:event_jButtonAddImgActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        defaultTableModel.setRowCount(0);
        showAllData();
    }// GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(Integer.parseInt(textFieldId.getText()));
        productDTO.setProduct_name(textFieldName.getText());
        productDTO.setRam(textFieldRam.getText());
        productDTO.setRom(textFieldRom.getText());
        productDTO.setBattery_capacity(textFieldBattery.getText());
        productDTO.setChip(textFieldChip.getText());
        productDTO.setBrand_id(Integer.parseInt(textFieldBrand.getText()));
        productDTO.setOrigin_id(Integer.parseInt(textFieldOrigin.getText()));
        productDTO.setStatus("active");
        productDTO.setImage_path(textFieldLink.getText());
        productBLL.updateProduct(productDTO);
        showAllData();

    }// GEN-LAST:event_jButtonUpdateActionPerformed

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableSuplierMouseClicked
        // TODO add your handling code here:
        int row = jTableProduct.getSelectedRow();
        textFieldId.setText(defaultTableModel.getValueAt(row, 0).toString());
        textFieldName.setText(defaultTableModel.getValueAt(row, 1).toString());
        textFieldRam.setText(defaultTableModel.getValueAt(row, 2).toString());
        textFieldRom.setText(defaultTableModel.getValueAt(row, 3).toString());
        textFieldBattery.setText(defaultTableModel.getValueAt(row, 4).toString());
        textFieldChip.setText(defaultTableModel.getValueAt(row, 5).toString());
        textFieldBrand.setText(defaultTableModel.getValueAt(row, 6).toString());
        textFieldOrigin.setText(defaultTableModel.getValueAt(row, 7).toString());
        textFieldLink.setText(defaultTableModel.getValueAt(row, 8).toString());
        File file = new File(textFieldLink.getText());
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = bufferedImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            jLabelImg.setIcon(new ImageIcon(image));
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(this, "loi ne", "Error",
            // JOptionPane.ERROR_MESSAGE);
        }
    }// GEN-LAST:event_jTableSuplierMouseClicked

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProduct_id(Integer.parseInt(textFieldId.getText()));
        productDTO.setProduct_name(textFieldName.getText());
        productDTO.setRam(textFieldRam.getText());
        productDTO.setRom(textFieldRom.getText());
        productDTO.setBattery_capacity(textFieldBattery.getText());
        productDTO.setChip(textFieldChip.getText());
        productDTO.setBrand_id(Integer.parseInt(textFieldBrand.getText()));
        productDTO.setOrigin_id(Integer.parseInt(textFieldOrigin.getText()));
        productDTO.setStatus("active");
        productDTO.setImage_path(textFieldLink.getText());
        productBLL.addProduct(productDTO);
        showAllData();
    }// GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonSearchActionPerformed

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
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductGUI.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAddImg;
    private javax.swing.JButton jButtonCustomer;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGRN;
    private javax.swing.JButton jButtonInvoice;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelAddress1;
    private javax.swing.JLabel jLabelAddress2;
    private javax.swing.JLabel jLabelAddress3;
    private javax.swing.JLabel jLabelEmal;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelPhone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JButton jbuttonExport;
    private javax.swing.JTextField textFieldBattery;
    private javax.swing.JTextField textFieldBrand;
    private javax.swing.JTextField textFieldChip;
    private javax.swing.JTextField textFieldId;
    private javax.swing.JTextField textFieldLink;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldOrigin;
    private javax.swing.JTextField textFieldRam;
    private javax.swing.JTextField textFieldRom;
    private javax.swing.JTextField textfieldSearch;
    // End of variables declaration//GEN-END:variables
}
