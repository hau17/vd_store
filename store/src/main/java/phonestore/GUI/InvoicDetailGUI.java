/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package phonestore.GUI;

import com.sun.tools.javac.jvm.ByteCodes;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import phonestore.BUS.BrandBLL;

import phonestore.BUS.CustomerBLL;

import phonestore.BUS.InvoiceDetailBUS;
import phonestore.BUS.OriginBLL;
import phonestore.BUS.ProductBLL;
import phonestore.DAO.GRNDetailDAO;
import phonestore.DAO.InvoiceDAO;
import phonestore.DAO.InvoiceDetailDAO;
import phonestore.DAO.OriginDAL;
import phonestore.DAO.ProductDAL;
import phonestore.DAO.WareHouseDAO;
import phonestore.DTO.CustomerDTO;
import phonestore.DTO.InvoiceDTO;
import phonestore.DTO.ProductDTO;
import phonestore.DTO.WareHouseDTO;
import phonestore.DTO.invoiceDetailDTO;

/**
 *
 * @author congh
 */
public class InvoicDetailGUI extends javax.swing.JDialog {
    InvoiceDetailBUS invoiceDetailBUS = new InvoiceDetailBUS();
    ProductBLL productBLL = new ProductBLL();
    DefaultTableModel defaultTableModelProduct, defaultTableModelProductNeedSell;
    CustomerBLL customerBLL;
    BrandBLL brandBLL = new BrandBLL();
    GRNDetailDAO grnDetailDAO = new GRNDetailDAO();
    WareHouseDAO wareHouseDAO = new WareHouseDAO();
    ArrayList<invoiceDetailDTO> arrIvoiceNeedSell = new ArrayList<>();
    ArrayList<WareHouseDTO> arrWareHouseDTONeedSell = new ArrayList<>();
    InvoiceDetailDAO invoiceDetailDAO = new InvoiceDetailDAO();
    OriginBLL originBLL = new OriginBLL();
    private InvoiceGUI parentGUI;

    /**
     * Creates new form InvoicDetailGUI
     */
    public InvoicDetailGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.parentGUI = (InvoiceGUI) parent;
        initComponents();
        defaultTableModelProduct = (DefaultTableModel) jTableSearchProduct.getModel();
        defaultTableModelProductNeedSell = (DefaultTableModel) jTableProduct.getModel();
        customerBLL = new CustomerBLL();
        showAllCustomer();
        showAllDataProduct();
        SetjTextFieldInvoiceId();
        SetjTextFieldDate();
        jTextFieldInvoiceId.setEditable(false);

    }

    public void SetjTextFieldInvoiceId() {
        int id = parentGUI.createNewID();
        jTextFieldInvoiceId.setText(Integer.toString(id));
    }

    public void SetjTextFieldDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String dateNow = simpleDateFormat.format(date);
        jTextFieldDate.setText(dateNow);
    }

    public void showAllDataProduct() {
        defaultTableModelProduct.setRowCount(0);
        Vector<ProductDTO> arrProductDTOs = productBLL.getAllProducts();
        for (ProductDTO productDTO : arrProductDTOs) {
            Object[] objects = new Object[] { productDTO.getProduct_id(), productDTO.getProduct_name(),
                    productDTO.getRam(), productDTO.getRom(), productDTO.getBattery_capacity(),
                    productDTO.getChip(),
                    brandBLL.getBrandDTOByID(productDTO.getBrand_id()).getBrand_name(),
                    originBLL.getOriginByID(productDTO.getOrigin_id()).getOrigin_name(),
                    wareHouseDAO.selectById(productDTO.getProduct_id()).getPrice(),
                    wareHouseDAO.selectById(productDTO.getProduct_id()).getQuantity()
            };
            defaultTableModelProduct.addRow(objects);
        }
    }

    public void showDataProductSearch(Vector<ProductDTO> vt) {
        defaultTableModelProduct.setRowCount(0);
        Vector<ProductDTO> vector = vt;
        for (ProductDTO productDTO : vector) {
            Object[] objects = new Object[] { productDTO.getProduct_id(), productDTO.getProduct_name(),
                    productDTO.getRam(), productDTO.getRom(), productDTO.getBattery_capacity(),
                    productDTO.getChip(),
                    brandBLL.getBrandDTOByID(productDTO.getBrand_id()).getBrand_name(),
                    originBLL.getOriginByID(productDTO.getOrigin_id()).getOrigin_name(),
                    wareHouseDAO.selectById(productDTO.getProduct_id()).getPrice(),
                    wareHouseDAO.selectById(productDTO.getProduct_id()).getQuantity()
            };
            defaultTableModelProduct.addRow(objects);
        }

    }

    public void showProductNeedSell() {
        defaultTableModelProductNeedSell.setRowCount(0);
        ArrayList<WareHouseDTO> arrayList = arrWareHouseDTONeedSell;
        for (WareHouseDTO wareHouseDTO : arrayList) {
            Object[] objects = new Object[] { wareHouseDTO.getProductId(), wareHouseDTO.getQuantity(),
                    wareHouseDTO.getPrice() };
            defaultTableModelProductNeedSell.addRow(objects);
        }
    }

    public void showAllCustomer() {
        Vector<CustomerDTO> vector = customerBLL.getAllCustomers();
        for (CustomerDTO customerDTO : vector) {
            jComboBoxCustomer.addItem(customerDTO.getCustomer_name());
        }
        AutoCompleteDecorator.decorate(jComboBoxCustomer);
    }

    public int getIDCustomer() {
        int index = jComboBoxCustomer.getSelectedIndex();
        Vector<CustomerDTO> vector = customerBLL.getAllCustomers();
        return vector.get(index).getCustomer_id();
    }

    public void addProductNeedSell(int productID, int quantity, int price) {
        WareHouseDTO wareHouseDTO = new WareHouseDTO(productID, quantity, new BigDecimal(price));
        invoiceDetailDTO invoiceDetailDTO = new invoiceDetailDTO(0,
                Integer.parseInt(jTextFieldInvoiceId.getText()), quantity, productID, price);
        arrWareHouseDTONeedSell.add(wareHouseDTO);
        arrIvoiceNeedSell.add(invoiceDetailDTO);
        showtotalAmount();
    }

    public void deleteProductNeedSell(int productID, int quantity, int price) {
        for (int i = 0; i < arrIvoiceNeedSell.size(); i++) {
            if (arrIvoiceNeedSell.get(i).getProductId() == productID) {
                arrIvoiceNeedSell.remove(i);
                break;
            }
        }
        for (int i = 0; i < arrWareHouseDTONeedSell.size(); i++) {
            if (arrWareHouseDTONeedSell.get(i).getProductId() == productID) {
                arrWareHouseDTONeedSell.remove(i);
                break;
            }
        }
        showtotalAmount();
    }

    public void updateProductNeedSell(int productID, int quantity, int price) {
        for (int i = 0; i < arrIvoiceNeedSell.size(); i++) {
            invoiceDetailDTO inDTO = arrIvoiceNeedSell.get(i);
            if (inDTO.getProductId() == productID) {
                inDTO.setPrice(price);
                inDTO.setQuantity(quantity);
                arrIvoiceNeedSell.set(i, inDTO);
                break;
            }
        }
        for (int i = 0; i < arrWareHouseDTONeedSell.size(); i++) {
            WareHouseDTO wareHouseDTO = arrWareHouseDTONeedSell.get(i);
            if (wareHouseDTO.getProductId() == productID) {
                wareHouseDTO.setPrice(new BigDecimal(price));
                wareHouseDTO.setQuantity(quantity);
                break;
            }
        }
        showtotalAmount();
    }

    public void showtotalAmount() {
        jTextFieldTotalAmount.setText("");
        int Total = 0;
        for (WareHouseDTO wareHouseDTO : arrWareHouseDTONeedSell) {
            Total += wareHouseDTO.getQuantity() * wareHouseDTO.getPrice().intValue();
        }
        jTextFieldTotalAmount.setText(Integer.toString(Total));
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldInvoiceId = new javax.swing.JTextField();
        jTextFieldProductName = new javax.swing.JTextField();
        jTextFieldQuantity = new javax.swing.JTextField();
        jTextFieldPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSearchProduct = new javax.swing.JTable();
        jButtonAdd = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonRefresh = new javax.swing.JButton();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jButtonInvoiceGeneration = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldProductId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxCustomer = new javax.swing.JComboBox<>();
        jTextFieldUser = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldDate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldTotalAmount = new javax.swing.JTextField();
        jButtonUpdate = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Invoice ID");

        jLabel3.setText("Price");

        jLabel4.setText("Product Name");

        jLabel5.setText("Quantity");

        jTextFieldProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductNameActionPerformed(evt);
            }
        });

        jTableSearchProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null },
                        { null, null, null, null, null, null, null, null, null, null }
                },
                new String[] {
                        "Phone ID", "Phone Name", "Ram", "Rom", "Battery capacity", "Chip", "Brand", "Origin", "Price",
                        "Quality"
                }));
        jTableSearchProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSearchProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSearchProduct);

        jButtonAdd.setBackground(new java.awt.Color(0, 153, 255));
        jButtonAdd.setText("Add");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(0, 153, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonRefresh.setBackground(new java.awt.Color(0, 153, 255));
        jButtonRefresh.setText("Refresh");
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });

        jButtonSearch.setBackground(new java.awt.Color(0, 153, 255));
        jButtonSearch.setText("Search product");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jTextFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchActionPerformed(evt);
            }
        });

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "Product ID", "Quantity", "Price"
                }));
        jTableProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProduct);

        jButtonInvoiceGeneration.setBackground(new java.awt.Color(0, 153, 255));
        jButtonInvoiceGeneration.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonInvoiceGeneration.setText("Invoice generation");
        jButtonInvoiceGeneration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInvoiceGenerationActionPerformed(evt);
            }
        });

        jLabel6.setText("Product ID");

        jTextFieldProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProductIdActionPerformed(evt);
            }
        });

        jLabel1.setText("User");

        jLabel7.setText("Customer");

        jComboBoxCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCustomerActionPerformed(evt);
            }
        });

        jLabel8.setText("Date");

        jTextFieldDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDateActionPerformed(evt);
            }
        });

        jLabel9.setText("Total amount");

        jButtonUpdate.setBackground(new java.awt.Color(0, 153, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(14, 14, 14)
                                                                                        .addComponent(jLabel3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                113,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(
                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                        layout.createSequentialGroup()
                                                                                                .addContainerGap()
                                                                                                .addComponent(jLabel5,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        115,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                        .addGap(18, 18, 18)
                                                                                        .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addComponent(jLabel6,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        113,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addComponent(jLabel4,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        113,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(jLabel2,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        113,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                        false)
                                                                        .addComponent(jTextFieldProductName,
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                189, Short.MAX_VALUE)
                                                                        .addComponent(jTextFieldInvoiceId,
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTextFieldQuantity)
                                                                        .addComponent(jTextFieldPrice)
                                                                        .addComponent(jTextFieldProductId))
                                                                .addGap(72, 72, 72)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false)
                                                                        .addComponent(jLabel7,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                105, Short.MAX_VALUE)
                                                                        .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(jLabel8,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jButtonAdd,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButtonDelete,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jButtonUpdate,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jTextFieldUser,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 1, Short.MAX_VALUE))
                                                        .addComponent(jComboBoxCustomer,
                                                                javax.swing.GroupLayout.Alignment.TRAILING, 0,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldDate))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674,
                                                        Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel9,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 109,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldTotalAmount,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 129,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(32, 32, 32)
                                                                .addComponent(jButtonInvoiceGeneration,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 148,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane2)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(jTextFieldSearch,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 233,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSearch,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonRefresh,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224,
                                                        Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonRefresh,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonSearch,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldSearch,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jTextFieldInvoiceId,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(3, 3, 3)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(jTextFieldUser,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                30,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7,
                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jLabel6,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(jTextFieldProductId)
                                                                .addComponent(jComboBoxCustomer,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 31,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(jTextFieldProductName,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel8,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jTextFieldDate,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 30,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextFieldQuantity,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 30,
                                                                Short.MAX_VALUE)
                                                        .addComponent(jTextFieldPrice))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonAdd,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonDelete,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jButtonUpdate,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 47,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(26, 26, 26)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldTotalAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonInvoiceGeneration, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        addProductNeedSell(Integer.parseInt(jTextFieldProductId.getText()),
                Integer.parseInt(jTextFieldQuantity.getText()), Integer.parseInt(jTextFieldPrice.getText()));
        showProductNeedSell();
    }// GEN-LAST:event_jButtonAddActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        deleteProductNeedSell(Integer.parseInt(jTextFieldProductId.getText()),
                Integer.parseInt(jTextFieldQuantity.getText()), Integer.parseInt(jTextFieldPrice.getText()));
        showProductNeedSell();
    }// GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableProductMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableProductMouseClicked
        // TODO add your handling code here:
        int row = jTableProduct.getSelectedRow();
        jTextFieldProductId.setText(defaultTableModelProductNeedSell.getValueAt(row, 0).toString());
        jTextFieldQuantity.setText(defaultTableModelProductNeedSell.getValueAt(row, 1).toString());
        jTextFieldPrice.setText(defaultTableModelProductNeedSell.getValueAt(row, 2).toString());
    }// GEN-LAST:event_jTableProductMouseClicked

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        updateProductNeedSell(Integer.parseInt(jTextFieldProductId.getText()),
                Integer.parseInt(jTextFieldQuantity.getText()), Integer.parseInt(jTextFieldPrice.getText()));
        showProductNeedSell();

    }// GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonInvoiceGenerationActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonInvoiceGenerationActionPerformed
        // TODO add your handling code here:
        for (invoiceDetailDTO inDTO : arrIvoiceNeedSell) {
            int invoiceDetailID = invoiceDetailDAO.getLastInvoiceDetailID();
            inDTO.setInvoiceDetailId(invoiceDetailID);
            invoiceDetailBUS.insertInvoiceDetailBUS(inDTO);
        }
        for (WareHouseDTO wareHouseDTO : arrWareHouseDTONeedSell) {
            wareHouseDAO.descreaseProduct(wareHouseDTO.getProductId(), wareHouseDTO.getQuantity());
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        Date utilDate = null;
        int invoiceID = 0;
        try {
            utilDate = simpleDateFormat.parse(jTextFieldDate.getText());
            invoiceID = Integer.parseInt(jTextFieldInvoiceId.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        InvoiceDTO invoiceDTO = new InvoiceDTO(invoiceID, getIDCustomer(), 1, sqlDate,
                new BigDecimal(jTextFieldTotalAmount.getText()), 1);
        InvoiceDAO.getInstance().insert(invoiceDTO);
        this.dispose();
    }// GEN-LAST:event_jButtonInvoiceGenerationActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
        // TODO add your handling code here:
        Vector<ProductDTO> vector = productBLL.searchProduct(jTextFieldSearch.getText());
        showDataProductSearch(vector);

    }// GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonRefreshActionPerformed
        // TODO add your handling code here:
        jTextFieldSearch.setText("");
        showAllDataProduct();
    }// GEN-LAST:event_jButtonRefreshActionPerformed

    private void jTextFieldProductIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldProductIdActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldProductIdActionPerformed

    private void jTextFieldProductNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldProductNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldProductNameActionPerformed

    private void jComboBoxCustomerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxCustomerActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxCustomerActionPerformed

    private void jTextFieldDateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldDateActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldDateActionPerformed

    private void jTableSearchProductMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jTableSearchProductMouseClicked
        // TODO add your handling code here:
        int row = jTableSearchProduct.getSelectedRow();
        if (row != -1) {
            jTextFieldProductId.setText(defaultTableModelProduct.getValueAt(row, 0).toString());
            jTextFieldProductName.setText(defaultTableModelProduct.getValueAt(row, 1).toString());
        }
    }// GEN-LAST:event_jTableSearchProductMouseClicked

    private void jTextFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField7ActionPerformed

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
            java.util.logging.Logger.getLogger(InvoicDetailGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoicDetailGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoicDetailGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoicDetailGUI.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InvoicDetailGUI dialog = new InvoicDetailGUI(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInvoiceGeneration;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProduct;
    private javax.swing.JTable jTableSearchProduct;
    private javax.swing.JTextField jTextFieldDate;
    private javax.swing.JTextField jTextFieldInvoiceId;
    private javax.swing.JTextField jTextFieldPrice;
    private javax.swing.JTextField jTextFieldProductId;
    private javax.swing.JTextField jTextFieldProductName;
    private javax.swing.JTextField jTextFieldQuantity;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JTextField jTextFieldTotalAmount;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables

}
