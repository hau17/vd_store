package phonestore.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import phonestore.DTO.InvoiceDTO;
import phonestore.config.JDBCUtil;

import java.sql.ResultSet;
import java.sql.Statement;

public class InvoiceDAO implements DAOInterface<InvoiceDTO> {
    public static InvoiceDAO getInstance() {
        return new InvoiceDAO();
    }

    @Override
    public int insert(InvoiceDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO invoice(invoice_id, customer_id, user_id, invoice_date, total_amount, status) VALUES(?, ?, ?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getInvoiceId());
            ps.setInt(2, t.getCustomer_id());
            ps.setInt(3, t.getUserId());
            ps.setDate(4, t.getDateOfInvoice());
            ps.setBigDecimal(5, t.getTotalAmount());
            ps.setInt(6, 1);
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    @Override
    public int delete(InvoiceDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE invoice SET status = ? " +
                    "WHERE invoice_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, t.getInvoiceId());
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    @Override
    public int update(InvoiceDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE invoice SET customer_id = ?, user_id = ?, invoice_date = ?, total_amount = ? WHERE invoice_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getCustomer_id());
            ps.setInt(2, t.getUserId());
            ps.setDate(3, t.getDateOfInvoice());
            ps.setBigDecimal(4, t.getTotalAmount());
            ps.setInt(5, t.getInvoiceId());

            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    @Override
    public ArrayList<InvoiceDTO> getselectAll() {
        ArrayList<InvoiceDTO> arr = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM invoice";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int invoiceId = rs.getInt("invoice_id");
                int customerId = rs.getInt("customer_id");
                int userId = rs.getInt("user_id");
                Date invoiceDate = rs.getDate("invoice_date");
                BigDecimal totalAmount = rs.getBigDecimal("total_amount");
                int status = rs.getInt("status");
                InvoiceDTO invoiceDTO = new InvoiceDTO(invoiceId, customerId, userId, invoiceDate, totalAmount, status);
                arr.add(invoiceDTO);
            }
            // rs.close();
            // st.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return arr;
    }

    @Override
    public InvoiceDTO selectById(int id) {
        InvoiceDTO invoiceDTO = null;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM invoice WHERE invoice_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int invoiceId = rs.getInt("invoice_id");
                int customerId = rs.getInt("customer_id");
                int userId = rs.getInt("user_id");
                Date invoiceDate = rs.getDate("invoice_date");
                BigDecimal totalAmount = rs.getBigDecimal("total_amount");
                int status = rs.getInt("status");
                invoiceDTO = new InvoiceDTO(invoiceId, customerId, userId, invoiceDate, totalAmount, status);
            }
            // rs.close();
            // ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return invoiceDTO;
    }
}
