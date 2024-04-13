package phonestore.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import phonestore.DTO.GRNDetailsDTO;
import phonestore.config.JDBCUtil;

public class GRNDetailsDAO implements DAOInterface<GRNDetailsDTO> {
    public static GRNDetailsDAO getInstance() {
        return new GRNDetailsDAO();
    }

    @Override
    public int insert(GRNDetailsDTO t) {
        Connection con = JDBCUtil.getConnection();
        int result = 0;
        try {
            String sql = "INSERT INTO GRNDetail(grn_details_id,grn_id,quantity,product_id,price_grn) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getGrnDetailsId());
            ps.setInt(2, t.getGrnId());
            ps.setInt(3, t.getQuantity());
            ps.setInt(4, t.getProductId());
            ps.setBigDecimal(5, t.getPrice());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(GRNDetailsDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM GRNDetail WHERE grn_details_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getGrnDetailsId());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(GRNDetailsDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE GRNDetail SET grn_id = ?, quantity = ?, product_id = ?, price_grn = ? WHERE grn_details_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getGrnId());
            ps.setInt(2, t.getQuantity());
            ps.setInt(3, t.getProductId());
            ps.setBigDecimal(4, t.getPrice());
            ps.setInt(5, t.getGrnDetailsId());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<GRNDetailsDTO> getselectAll() {
        ArrayList<GRNDetailsDTO> arr = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM GRNDetail";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int grnDetailsId = rs.getInt("grn_details_id");
                int grnId = rs.getInt("grn_id");
                int quantity = rs.getInt("quantity");
                int productId = rs.getInt("product_id");
                BigDecimal price = rs.getBigDecimal("price_grn");
                GRNDetailsDTO grnDetailsDTO = new GRNDetailsDTO(grnDetailsId, grnId, quantity, productId, price);
                arr.add(grnDetailsDTO);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public GRNDetailsDTO selectById(int id) {
        GRNDetailsDTO grnDetailsDTO = null;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM GRNDetail WHERE grn_details_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int grnDetailsId = rs.getInt("grn_details_id");
                int grnId = rs.getInt("grn_id");
                int quantity = rs.getInt("quantity");
                int productId = rs.getInt("product_id");
                BigDecimal price = rs.getBigDecimal("price_grn");
                grnDetailsDTO = new GRNDetailsDTO(grnDetailsId, grnId, quantity, productId, price);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grnDetailsDTO;
    }
}
