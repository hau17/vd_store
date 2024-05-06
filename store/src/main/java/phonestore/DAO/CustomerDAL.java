package phonestore.DAO;

import java.sql.*;
import java.util.Vector;

import phonestore.DTO.CustomerDTO;
import phonestore.config.JDBCUtil;

public class CustomerDAL {

    public Vector<CustomerDTO> getAllCustomers() {
        Vector<CustomerDTO> arr = new Vector<CustomerDTO>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Customer where status = 'active'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                CustomerDTO cs = new CustomerDTO();
                cs.setCustomer_id(rs.getInt("Customer_id"));
                cs.setCustomer_name(rs.getString("Customer_name"));
                cs.setPhone_number(rs.getInt("Phone_number"));
                cs.setAddress(rs.getString("Address"));
                arr.add(cs);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return arr;
    }

    public boolean addCustomer(CustomerDTO cus) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Insert into Customer values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, cus.getCustomer_id());
            stmt.setString(2, cus.getCustomer_name());
            stmt.setInt(3, cus.getPhone_number());
            stmt.setString(4, cus.getAddress());
            stmt.setString(5, cus.getStatus());
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }

    public boolean updateCustomer(CustomerDTO cus) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Customer SET customer_name=?, phone_number=?, address=?, status=? WHERE customer_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cus.getCustomer_name());
            stmt.setInt(2, cus.getPhone_number());
            stmt.setString(3, cus.getAddress());
            stmt.setString(4, "disable");
            stmt.setInt(5, cus.getCustomer_id());
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }

    public boolean deleteCustomer(int customerID) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Customer set status = 'disable' WHERE customer_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, customerID);
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    public Vector<CustomerDTO> searchCustomer(String searchText) {
        Vector<CustomerDTO> arr = new Vector<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql;
            PreparedStatement stmt;
            if (isNumeric(searchText)) {
                sql = "SELECT * FROM Customer WHERE customer_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, searchText);
            } else {
                sql = "SELECT * FROM Customer WHERE customer_name LIKE ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + searchText + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CustomerDTO cus = new CustomerDTO();
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setCustomer_name(rs.getString("customer_name"));
                cus.setPhone_number(rs.getInt("phone_number"));
                cus.setAddress(rs.getString("address"));
                arr.add(cus);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return arr;
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean hasCustomerID(int id) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Customer where customer_id=" + id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            result = rs.next();
        } catch (SQLException ex) {
            System.err.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }
    public CustomerDTO getCustomerByID(int id){
        CustomerDTO cus=new CustomerDTO();
        Connection con=JDBCUtil.getConnection();
        try {
            String sql="Select * from Customer where customer_id=" + id;
            Statement statement=con.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {                
                cus.setCustomer_id(rs.getInt("customer_id"));
                cus.setCustomer_name(rs.getString("customer_name"));
                cus.setPhone_number(rs.getInt("phone_number"));
                cus.setAddress(rs.getString("address"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return cus;
    }
    public int getLastCustomerID(){
        int i=0;
        Connection connection=JDBCUtil.getConnection();
        try {
            String sql ="SELECT customer_id"+
                    " FROM customer"+
                    " WHERE customer_id= (SELECT MAX(customer_id) FROM customer)";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {                
                i = resultSet.getInt("customer_id")+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
