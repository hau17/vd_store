/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package phonestore.GUI;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import phonestore.BUS.GRNBUS;
import phonestore.DTO.ProductDTO;
import phonestore.BUS.ProductBLL;
import phonestore.BUS.SuplierBUS;
import phonestore.DTO.SuplierDTO;
import phonestore.DTO.GRNDetailDTO;
import phonestore.DTO.GRNDTO;
import phonestore.BUS.GRNBUS;
import phonestore.BUS.GRNDetailBUS;
import phonestore.BUS.UserBUS;
import phonestore.DTO.WareHouseDTO;
import phonestore.BUS.WarehouseBUS;
import phonestore.InformationLogin.InformationLogin;
/**
 *
 * @author congh
 */
public class GRNAddGUI extends javax.swing.JDialog {

    /**
     * Creates new form GRNAddGUI
     */
    ProductBLL productBLL=new ProductBLL();
    GRNBUS grnbus=new GRNBUS();
    DefaultTableModel productDefaultTableModel, grnDefaultTableModel;
    SuplierBUS suplierBUS=new SuplierBUS();
    ArrayList<GRNDetailDTO> gRNDetailDTOArr = new ArrayList<>();
    ArrayList<WareHouseDTO> wareHouseDTOArr =new ArrayList<>();
    WarehouseBUS warehouseBUS=new WarehouseBUS();
    GRNDetailBUS gRNDetailBUS=new GRNDetailBUS();
    UserBUS userBUS=new UserBUS();
    public GRNAddGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        productDefaultTableModel=(DefaultTableModel) jTableSearchProduct.getModel();
        grnDefaultTableModel=(DefaultTableModel) jTableGrn.getModel();
        jLabelInvoiceID.setText(Integer.toString(grnbus.getLastGRNID()));
        showAllDataProduct();
        showDataSupplier();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        jTextFieldDate.setText(simpleDateFormat.format(new Date()));
        jTextFieldUser.setText(InformationLogin.getInstance().getUserName());
    }
    public void showAllDataProduct(){
        productDefaultTableModel.setRowCount(0);
        for(ProductDTO productDTO: productBLL.getAllProducts()){
            Object[] objects=new Object[]{
                productDTO.getProduct_id(),productDTO.getProduct_name(),productDTO.getRam(),
                productDTO.getRom(),productDTO.getBattery_capacity(),productDTO.getChip(),
                productDTO.getBrand_id(),productDTO.getOrigin_id()
            };
            productDefaultTableModel.addRow(objects);
        }
    }
    public void showAllDataSearchProduct(String search){
        productDefaultTableModel.setRowCount(0);
        for(ProductDTO productDTO: productBLL.searchProduct(search)){
            Object[] objects=new Object[]{
                productDTO.getProduct_id(),productDTO.getProduct_name(),productDTO.getRam(),
                productDTO.getRom(),productDTO.getBattery_capacity(),productDTO.getChip(),
                productDTO.getBrand_id(),productDTO.getOrigin_id()
            };
            productDefaultTableModel.addRow(objects);
        }
    }
    public void showAllGRNDetail(){
        grnDefaultTableModel.setRowCount(0);
        for(WareHouseDTO wareHouseDTO: wareHouseDTOArr){
            Object[] objects=new Object[]{
                wareHouseDTO.getProductId(), productBLL.getProductDTO(wareHouseDTO.getProductId()).getProduct_name(),
                wareHouseDTO.getQuantity(),wareHouseDTO.getPrice()
            };
            grnDefaultTableModel.addRow(objects);
        }
    }
    public void showDataSupplier(){
        for(SuplierDTO sdto: suplierBUS.getAllSuplier()){
            jComboBoxSupplier.addItem(sdto.getSuplierId()+"-"+sdto.getSuplierName());
        }
        AutoCompleteDecorator.decorate(jComboBoxSupplier);
    }
    public int getSupplierID(){
        int index= jComboBoxSupplier.getSelectedIndex();
        ArrayList<SuplierDTO> arrayList=suplierBUS.getAllSuplier();
        return arrayList.get(index).getSuplierId();
    }
    public void showTotalAmount(){
        int total=0;
        for(WareHouseDTO wareHouseDTO: wareHouseDTOArr){
            total+=wareHouseDTO.getPrice().intValue() * wareHouseDTO.getQuantity();
        }
        jTextFieldTotalAmount.setText(Integer.toString(total));
    }
    public void addGRNDetail(int productID, int quantity, int price){
        GRNDetailDTO grnddto=new GRNDetailDTO(0, Integer.parseInt(jLabelInvoiceID.getText()), quantity, productID, new BigDecimal(price));
        gRNDetailDTOArr.add(grnddto);
        WareHouseDTO wareHouseDTO=new WareHouseDTO(productID, quantity, new BigDecimal(price), 1);
        wareHouseDTOArr.add(wareHouseDTO);
    }
    public void deleteGRNDetail(int productID, int quantity, int price){
        for(int i=0;i<wareHouseDTOArr.size();i++){
            if(wareHouseDTOArr.get(i).getProductId() == productID){
                wareHouseDTOArr.remove(i);
                break;
            }
        }
        for(int i=0;i<gRNDetailDTOArr.size();i++){
            if(gRNDetailDTOArr.get(i).getProductID()==productID){
                gRNDetailDTOArr.remove(i);
                break;
            }
        }
    }
        public boolean checkInteger(String inString) {
        try {
            Integer.parseInt(inString);
            return true;
        } catch (Exception e) {
            return false;
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

        jPanelInvoiceID = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldQuantity = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPrice = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButtonGRNGeneration = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGrn = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSearchProduct = new javax.swing.JTable();
        jButtonRefresh = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldUser = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxSupplier = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabelInvoiceID = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldTotalAmount = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JLabel();
        jTextFieldProductID = new javax.swing.JLabel();
        jTextFieldPhoneName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setText("Product ID");

        jLabel4.setText("Product Name");

        jLabel5.setText("Quantity");

        jTextFieldQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQuantityActionPerformed(evt);
            }
        });

        jLabel3.setText("Price");

        jButtonAdd.setBackground(new java.awt.Color(0, 102, 102));
        jButtonAdd.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
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

        jLabel9.setText("Total amount");

        jButtonGRNGeneration.setBackground(new java.awt.Color(0, 102, 102));
        jButtonGRNGeneration.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonGRNGeneration.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGRNGeneration.setText("GRN generation");
        jButtonGRNGeneration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGRNGenerationActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Product");

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jTableGrn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phone ID", "Phone name", "Quantity", "Price"
            }
        ));
        jTableGrn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableGrnMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableGrn);

        jTableSearchProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Phone ID", "Phone Name", "Ram", "Rom", "Battery capacity", "Chip", "Brand", "Origin"
            }
        ));
        jTableSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSearchProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSearchProduct);

        jButtonRefresh.setBackground(new java.awt.Color(0, 102, 102));
        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonSearch.setBackground(new java.awt.Color(0, 102, 102));
        jButtonSearch.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSearch.setText("Search product");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel1.setText("User");

        jLabel7.setText("Supplier");

        jComboBoxSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSupplierActionPerformed(evt);
            }
        });

        jLabel8.setText("Date");

        jLabel11.setText("Invoice ID");

        javax.swing.GroupLayout jPanelInvoiceIDLayout = new javax.swing.GroupLayout(jPanelInvoiceID);
        jPanelInvoiceID.setLayout(jPanelInvoiceIDLayout);
        jPanelInvoiceIDLayout.setHorizontalGroup(
            jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInvoiceIDLayout.createSequentialGroup()
                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInvoiceIDLayout.createSequentialGroup()
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInvoiceIDLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                        .addComponent(jTextFieldPhoneName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButtonGRNGeneration, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 224, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxSupplier, 0, 156, Short.MAX_VALUE)
                            .addComponent(jTextFieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelInvoiceIDLayout.setVerticalGroup(
            jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelInvoiceIDLayout.createSequentialGroup()
                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelInvoiceID, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                                    .addComponent(jTextFieldProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelInvoiceIDLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldDate, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                            .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(jTextFieldPhoneName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jTextFieldPrice))
                        .addGap(58, 58, 58)
                        .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTotalAmount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelInvoiceIDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonGRNGeneration, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInvoiceID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelInvoiceID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        if(!checkInteger(jTextFieldQuantity.getText()) || !checkInteger(jTextFieldPrice.getText())){
            JOptionPane.showMessageDialog(rootPane, "The number of items and the price must be entered as integers");
        }else{
            addGRNDetail(Integer.parseInt(jTextFieldProductID.getText()), Integer.parseInt(jTextFieldQuantity.getText()), Integer.parseInt(jTextFieldPrice.getText()));
        }
        showAllGRNDetail();
        showTotalAmount();
    }//GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        deleteGRNDetail(Integer.parseInt(jTextFieldProductID.getText()), Integer.parseInt(jTextFieldQuantity.getText()), Integer.parseInt(jTextFieldPrice.getText()));
        showAllGRNDetail();
        showTotalAmount();
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jButtonGRNGenerationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGRNGenerationActionPerformed
        // TODO add your handling code here:
        for(WareHouseDTO wareHouseDTO: wareHouseDTOArr){
            if (!warehouseBUS.hasProductID(wareHouseDTO.getProductId())) {
                warehouseBUS.insert(wareHouseDTO);
            }else{
                warehouseBUS.increaseProduct(wareHouseDTO.getProductId(), wareHouseDTO.getQuantity(), wareHouseDTO.getPrice().intValue());
            }
        }
        for(GRNDetailDTO gRNDetailDTO: gRNDetailDTOArr){
            gRNDetailDTO.setGrnDetailID(gRNDetailBUS.getLastGRNDetailID());
            gRNDetailBUS.insertGRNDetailBUS(gRNDetailDTO);
        }
        Date utilDate=null;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        try {
            utilDate= simpleDateFormat.parse(jTextFieldDate.getText());
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        java.sql.Date inputDate=new java.sql.Date(utilDate.getTime());
        int grnID=grnbus.getLastGRNID();
        int supplierID=getSupplierID();
        int userID= userBUS.getUserDTOByUserName(jTextFieldUser.getText()).getuser_id();
        BigDecimal total= new BigDecimal(jTextFieldTotalAmount.getText());
        GRNDTO grndto=new GRNDTO(grnID,supplierID,inputDate,userID,total);
        grnbus.insertGRNBUS(grndto);
        JOptionPane.showMessageDialog(rootPane, "success");
        this.dispose();
    }//GEN-LAST:event_jButtonGRNGenerationActionPerformed

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchActionPerformed

    private void jTableGrnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableGrnMouseClicked
        // TODO add your handling code here:
        int row=jTableGrn.getSelectedRow();
        jTextFieldProductID.setText(grnDefaultTableModel.getValueAt(row, 0).toString());
        jTextFieldPhoneName.setText(grnDefaultTableModel.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jTableGrnMouseClicked

    private void jTableSearchProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSearchProductMouseClicked
        // TODO add your handling code here:
        int row=jTableSearchProduct.getSelectedRow();
        jTextFieldProductID.setText(productDefaultTableModel.getValueAt(row, 0).toString());
        jTextFieldPhoneName.setText(productDefaultTableModel.getValueAt(row, 1).toString());
    }//GEN-LAST:event_jTableSearchProductMouseClicked

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        jTextFieldSearch.setText("");
        showAllDataProduct();
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        showAllDataSearchProduct(jTextFieldSearch.getText());
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jComboBoxSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSupplierActionPerformed

    private void jTextFieldQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQuantityActionPerformed

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
            java.util.logging.Logger.getLogger(GRNAddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GRNAddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GRNAddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GRNAddGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GRNAddGUI dialog = new GRNAddGUI(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGRNGeneration;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelInvoiceID;
    private javax.swing.JPanel jPanelInvoiceID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGrn;
    private javax.swing.JTable jTableSearchProduct;
    private javax.swing.JLabel jTextFieldDate;
    private javax.swing.JLabel jTextFieldPhoneName;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JLabel jTextFieldProductID;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JLabel jTextFieldTotalAmount;
    private javax.swing.JLabel jTextFieldUser;
    // End of variables declaration//GEN-END:variables
}
