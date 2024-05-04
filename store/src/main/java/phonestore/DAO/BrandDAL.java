package phonestore.DAO;

import java.sql.*;
import java.util.Vector;

import phonestore.DTO.BrandDTO;
import phonestore.config.JDBCUtil;

public class BrandDAL {

    public Vector<BrandDTO> getAllBrands() {
        Vector<BrandDTO> arr = new Vector<BrandDTO>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Brand where status = 'active'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BrandDTO br = new BrandDTO();
                br.setBrand_id(rs.getInt("Brand_id"));
                br.setBrand_name(rs.getString("Brand_name"));
                br.setStatus("active");
                arr.add(br);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return arr;
    }

    public boolean addBrand(BrandDTO bra) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Insert into Brand values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, bra.getBrand_id());
            stmt.setString(2, bra.getBrand_name());
            stmt.setString(3, "active");
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }

    public boolean updateBrand(BrandDTO bra) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Brand SET brand_name=?, status=? WHERE brand_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, bra.getBrand_name());
            stmt.setString(2, bra.getStatus());
            stmt.setInt(3, bra.getBrand_id());
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    public boolean deleteBrand(int brandID) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Brand set status = 'disable' WHERE brand_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, brandID);
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    public Vector<BrandDTO> searchBrand(String searchText) {
        Vector<BrandDTO> arr = new Vector<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql;
            PreparedStatement stmt;
            if (isNumeric(searchText)) {
                sql = "SELECT * FROM Brand WHERE brand_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, searchText);
            } else {
                sql = "SELECT * FROM Brand WHERE brand_name LIKE ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + searchText + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BrandDTO bra = new BrandDTO();
                bra.setBrand_id(rs.getInt("brand_id"));
                bra.setBrand_name(rs.getString("brand_name"));
                arr.add(bra);
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

    public boolean hasBrandID(int id) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Brand where brand_id=" + id;
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
    public BrandDTO getBrandByID(int id){
        Connection con= JDBCUtil.getConnection();
        BrandDTO brandDTO=new BrandDTO();
        try {
            String sql = "Select * from Brand where brand_id=" + id;
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {                
                brandDTO.setBrand_id(rs.getInt("brand_id"));
                brandDTO.setBrand_name(rs.getString("brand_name"));
                brandDTO.setStatus("status");
            }

        } catch (Exception e) {
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return brandDTO;
    }
}
