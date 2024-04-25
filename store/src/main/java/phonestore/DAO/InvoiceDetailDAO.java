package phonestore.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import phonestore.DTO.invoiceDetailDTO;
import phonestore.config.JDBCUtil;

public class InvoiceDetailDAO implements DAOInterface<invoiceDetailDTO> {
    public static InvoiceDetailDAO getInstance() {
        return new InvoiceDetailDAO();
    }

    @Override
    public int insert(invoiceDetailDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO invoice_detail(invoice_detail_id,invoice_id,quantity,product_id,price) " +
                    " VALUES(?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getInvoiceDetailId());
            ps.setInt(2, t.getInvoiceId());
            ps.setInt(3, t.getQuantity());
            ps.setInt(4, t.getProductId());
            ps.setInt(5, t.getPrice());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(invoiceDetailDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM invoice_detail WHERE invoice_detail_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getInvoiceDetailId());
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int update(invoiceDetailDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE invoice_detail SET invoice_id = ?, quantity = ?, product_id = ?, price = ? WHERE invoice_detail_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getInvoiceId());
            ps.setInt(2, t.getQuantity());
            ps.setInt(3, t.getProductId());
            ps.setInt(4, t.getPrice());
            ps.setInt(5, t.getInvoiceDetailId());
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public ArrayList<invoiceDetailDTO> getselectAll() {
        ArrayList<invoiceDetailDTO> arr = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM invoice_detail";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int invoiceDetailId = rs.getInt("invoice_detail_id");
                int invoiceId = rs.getInt("invoice_id");
                int quantity = rs.getInt("quantity");
                int productId = rs.getInt("product_id");
                int price = rs.getInt("price");
                invoiceDetailDTO invoiceDetailDTO = new invoiceDetailDTO(invoiceDetailId, invoiceId, quantity,
                        productId, price);
                arr.add(invoiceDetailDTO);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return arr;
    }

    @Override
    public invoiceDetailDTO selectById(int id) {
        invoiceDetailDTO invoiceDetailDTO = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM invoice_detail WHERE invoice_detail_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int invoiceDetailId = rs.getInt("invoice_detail_id");
                int invoiceId = rs.getInt("invoice_id");
                int quantity = rs.getInt("quantity");
                int productId = rs.getInt("product_id");
                int price = rs.getInt("price");
                invoiceDetailDTO = new invoiceDetailDTO(invoiceDetailId, invoiceId, quantity, productId, price);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return invoiceDetailDTO;
    }
}
