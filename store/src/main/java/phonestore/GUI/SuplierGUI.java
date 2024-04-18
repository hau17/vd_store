package phonestore.GUI;

import phonestore.BUS.SuplierBUS;
import phonestore.DTO.SuplierDTO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SuplierGUI extends JDialog {
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

    public SuplierGUI() {
        Font font = new Font("Arial", Font.BOLD, 12);
        Color btnColor = new Color(50, 150, 200);
        Dimension btnsize = new Dimension(80, 30);
        jPanelSuplier = new JPanel();
        setContentPane(jPanelSuplier);
        setSize(800, 650);
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

        // Panel chứa các nút CRUD
        JPanel jPanelCRUD = new JPanel();
        jPanelCRUD.add(jButtonAdd);
        jPanelCRUD.add(jButtonDelete);
        jPanelCRUD.add(jButtonUpdate);
        jTableSuplier = new JTable();
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
        setVisible(true);
        setLocationRelativeTo(null);
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

    public static void main(String[] args) {
        SuplierGUI dialog = new SuplierGUI();
    }
}
