package phonestore.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import phonestore.DTO.GRNDetailDTO;
import phonestore.config.JDBCUtil;

public class GRNDetailDAO implements DAOInterface<GRNDetailDTO> {
    public static GRNDetailDAO getInstance() {
        return new GRNDetailDAO();
    }

    @Override
    public int insert(GRNDetailDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO grndetail(grn_details_id,grn_id,quantity,product_id,price_grn) " +
                    "VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getGrnDetailID());
            ps.setInt(2, t.getGrnID());
            ps.setInt(3, t.getQuantity());
            ps.setInt(4, t.getProductID());
            ps.setBigDecimal(5, t.getPrice());
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
    public int delete(GRNDetailDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM grndetail WHERE grn_details_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getGrnDetailID());
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
    public int update(GRNDetailDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE grndetail SET grn_id = ?, quantity = ?, product_id = ?, price_grn = ? WHERE grn_details_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getGrnID());
            ps.setInt(2, t.getQuantity());
            ps.setInt(3, t.getProductID());
            ps.setBigDecimal(4, t.getPrice());
            ps.setInt(5, t.getGrnDetailID());
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
    public ArrayList<GRNDetailDTO> getselectAll() {
        ArrayList<GRNDetailDTO> arr = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM grndetail";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int grnDetailID = rs.getInt("grn_details_id");
                int grnID = rs.getInt("grn_id");
                int quantity = rs.getInt("quantity");
                int productID = rs.getInt("product_id");
                BigDecimal price = rs.getBigDecimal("price_grn");
                GRNDetailDTO grnDetailDTO = new GRNDetailDTO(grnDetailID, grnID, quantity, productID, price);
                arr.add(grnDetailDTO);
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
    public GRNDetailDTO selectById(int id) {
        GRNDetailDTO grnDetailDTO = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM grndetail WHERE grn_details_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int grnDetailID = rs.getInt("grn_details_id");
                int grnID = rs.getInt("grn_id");
                int quantity = rs.getInt("quantity");
                int productID = rs.getInt("product_id");
                BigDecimal price = rs.getBigDecimal("price_grn");
                grnDetailDTO = new GRNDetailDTO(grnDetailID, grnID, quantity, productID, price);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return grnDetailDTO;
    }

    public GRNDetailDTO getGRNDetailByProductID(int id) {
        GRNDetailDTO grnDetailDTO = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM grndetail WHERE product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int grnDetailID = rs.getInt("grn_details_id");
                int grnID = rs.getInt("grn_id");
                int quantity = rs.getInt("quantity");
                int productID = rs.getInt("product_id");
                BigDecimal price = rs.getBigDecimal("price_grn");
                grnDetailDTO = new GRNDetailDTO(grnDetailID, grnID, quantity, productID, price);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return grnDetailDTO;
    }
}
