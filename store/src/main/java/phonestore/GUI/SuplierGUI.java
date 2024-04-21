package phonestore.GUI;

import phonestore.BUS.SuplierBUS;
import phonestore.DAO.SuplierDAO;
import phonestore.DTO.SuplierDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SuplierGUI extends JFrame {
    public JPanel jPanelSuplier;
    public JButton jButtonAdd;
    public JButton jButtonDelete;
    public JButton jButtonUpdate;
    public JTable jTableSuplier;
    public JScrollPane jScrollPaneSuplier;
    public DefaultTableModel defaultTableModelSuplier;
    public TextField textFieldId, textFieldName, textFieldPhone, textFieldEmail, textFieldAddress;
    public JLabel labelId, labelName, labelPhone, labelEmail, labelAddress;
    public SuplierBUS suplierBUS;
    public JTextField jTextFieldSearch;
    public JButton jButtonSearch, jButtonRefresh;

    public SuplierGUI() {
        //font chữ, kích thước button
        Font font = new Font("Arial", Font.BOLD, 12);
        Dimension btnsize = new Dimension(80, 19);
        jPanelSuplier = new JPanel();
        setSize(900, 600);
        setLayout(new FlowLayout());
        jPanelSuplier.setLayout(new BorderLayout());


        jButtonAdd = new JButton("add");
        jButtonAdd.setFont(font);
        jButtonAdd.setFocusable(false);
        jButtonAdd.setPreferredSize(btnsize);

        jButtonDelete = new JButton("delete");
        jButtonDelete.setFont(font);
        jButtonDelete.setFocusable(false);
        jButtonDelete.setPreferredSize(btnsize);

        jButtonUpdate = new JButton("update");
        jButtonUpdate.setFont(font);
        jButtonUpdate.setFocusable(false);
        suplierBUS = new SuplierBUS();
        jButtonUpdate.setPreferredSize(btnsize);

        JPanel jPanel_empty = new JPanel();
        jPanel_empty.setSize(200,19);

        jTextFieldSearch = new JTextField(30);
        jButtonSearch= new JButton("search");
        jButtonSearch.setFont(font);
        jButtonSearch.setFocusable(false);
        jButtonSearch.setPreferredSize(btnsize);
        jButtonRefresh=new JButton("Refresh");
        jButtonRefresh.setFont(font);
        jButtonRefresh.setFocusable(false);
        jButtonRefresh.setPreferredSize(btnsize);

        // Panel chứa các nút CRUD
        JPanel jPanelCRUD = new JPanel();
        jPanelCRUD.add(jButtonAdd);
        jPanelCRUD.add(jButtonDelete);
        jPanelCRUD.add(jButtonUpdate);
        jPanelCRUD.add(jPanel_empty);
        jPanelCRUD.add(jTextFieldSearch);
        jPanelCRUD.add(jButtonSearch);
        jPanelCRUD.add(jButtonRefresh);
        //tạo table
        jTableSuplier = new JTable();
        jTableSuplier.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPaneSuplier = new JScrollPane(jTableSuplier);
        defaultTableModelSuplier = new DefaultTableModel();
        jTableSuplier.setModel(defaultTableModelSuplier);
        defaultTableModelSuplier.addColumn("id");
        defaultTableModelSuplier.addColumn("name");
        defaultTableModelSuplier.addColumn("email");
        defaultTableModelSuplier.addColumn("phone number");
        defaultTableModelSuplier.addColumn("address");
        // tạo Panel để chứa danh sách Suplier
        JPanel jPanelList = new JPanel();
        jPanelList.add(jScrollPaneSuplier);

        // panel thêm, sửa thông tin
        JPanel jpanel_information = new JPanel();
        jpanel_information.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        textFieldId = new TextField(20);
        textFieldName = new TextField(20);
        textFieldPhone = new TextField(20);
        textFieldEmail = new TextField(20);
        textFieldAddress = new TextField(20);
        labelId = new JLabel("ID");
        labelName = new JLabel("Name");
        labelPhone = new JLabel("Phone");
        labelEmail = new JLabel("Email");
        labelAddress = new JLabel("Address");
        gbc.gridx = 0;
        gbc.gridy = 0;
        jpanel_information.add(labelId, gbc);
        gbc.gridx = 1;
        jpanel_information.add(textFieldId, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        jpanel_information.add(labelName, gbc);
        gbc.gridx = 1;
        jpanel_information.add(textFieldName, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        jpanel_information.add(labelPhone, gbc);
        gbc.gridx = 1;
        jpanel_information.add(textFieldPhone, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        jpanel_information.add(labelEmail, gbc);
        gbc.gridx = 1;
        jpanel_information.add(textFieldEmail, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        jpanel_information.add(labelAddress, gbc);
        gbc.gridx = 1;
        jpanel_information.add(textFieldAddress, gbc);

        jPanelSuplier.add(jPanelCRUD, BorderLayout.NORTH);
        jPanelSuplier.add(jPanelList, BorderLayout.CENTER);
        jPanelSuplier.add(jpanel_information, BorderLayout.SOUTH);
        showDataSuplier();
        jTableSuplier.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Point p = e.getPoint();
                int row = jTableSuplier.rowAtPoint(p);
                showDataSuplier(row);
            }
        });
        jButtonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = textFieldId.getText();
                    String name = textFieldName.getText();
                    String phone = textFieldPhone.getText();
                    String email = textFieldEmail.getText();
                    String address = textFieldAddress.getText();
                    SuplierDTO suplierDTO = new SuplierDTO(Integer.parseInt(id), name, email, phone, address, 1);
                    // SuplierBUS suplierBUS=new SuplierBUS();
                    suplierBUS.add_suplier(suplierDTO);
                    showDataSuplier();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    // JOptionPane.showMessageDialog(suplierg,"không được để
                    // trống","ERROR",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jButtonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // SuplierBUS suplierBUS=new SuplierBUS();
                try {
                    suplierBUS.delete_suplier(Integer.parseInt(textFieldId.getText()));
                    showDataSuplier();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        jButtonUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = textFieldId.getText();
                String name = textFieldName.getText();
                String phone = textFieldPhone.getText();
                String email = textFieldEmail.getText();
                String address = textFieldAddress.getText();
                SuplierDTO suplierDTO = new SuplierDTO(Integer.parseInt(id), name, email, phone, address, 1);
                // SuplierBUS suplierBUS=new SuplierBUS();
                suplierBUS.update_suplier(suplierDTO);
                showDataSuplier();
            }
        });
        jButtonSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textSearch = jTextFieldSearch.getText();
                ArrayList<SuplierDTO> arr_search= suplierBUS.arr_search_suplier(textSearch);
                showDataSuplier(arr_search);
            }
        });
        jButtonRefresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTextFieldSearch.setText("");
                showDataSuplier();
            }
        });
        add(jPanelSuplier);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showDataSuplier() {
        defaultTableModelSuplier.setRowCount(0);
        // SuplierBUS suplierBUS=new SuplierBUS();
        ArrayList<SuplierDTO> suplierDTOArrayList = suplierBUS.getAllSuplier();
        for (SuplierDTO suplierDTO : suplierDTOArrayList) {
            Object[] ob = new Object[] { suplierDTO.getSuplierId(), suplierDTO.getSuplierName(),
                    suplierDTO.getEmailAddress(), suplierDTO.getPhoneNumber(), suplierDTO.getAddress() };
            defaultTableModelSuplier.addRow(ob);
        }
    }

    public void showDataSuplier(int x) {
        // SuplierBUS suplierBUS=new SuplierBUS();
        ArrayList<SuplierDTO> suplierDTOArrayList = suplierBUS.getAllSuplier();
        SuplierDTO suplierDTO = suplierDTOArrayList.get(x);
        textFieldId.setText(Integer.toString(suplierDTO.getSuplierId()));
        textFieldName.setText(suplierDTO.getSuplierName());
        textFieldEmail.setText(suplierDTO.getEmailAddress());
        textFieldPhone.setText(suplierDTO.getPhoneNumber());
        textFieldAddress.setText(suplierDTO.getAddress());
    }
    public void showDataSuplier(ArrayList<SuplierDTO> arr) {
        defaultTableModelSuplier.setRowCount(0);
        // SuplierBUS suplierBUS=new SuplierBUS();
        ArrayList<SuplierDTO> suplierDTOArrayList = arr;
        for (SuplierDTO suplierDTO : suplierDTOArrayList) {
            Object[] ob = new Object[] { suplierDTO.getSuplierId(), suplierDTO.getSuplierName(),
                    suplierDTO.getEmailAddress(), suplierDTO.getPhoneNumber(), suplierDTO.getAddress() };
            defaultTableModelSuplier.addRow(ob);
        }
    }


    public static void main(String[] args) {
        SuplierGUI dialog = new SuplierGUI();
        dialog.setVisible(true);
    }
}
