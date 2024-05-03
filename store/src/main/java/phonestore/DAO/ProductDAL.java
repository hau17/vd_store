package phonestore.DAO;

import java.sql.*;
import java.util.Vector;

import phonestore.DTO.ProductDTO;
import phonestore.config.JDBCUtil;

public class ProductDAL {

    public Vector<ProductDTO> getAllProducts() {
        Vector<ProductDTO> arr = new Vector<ProductDTO>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Product where status = 'active'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ProductDTO pr = new ProductDTO();
                pr.setProduct_id(rs.getInt("product_id"));
                pr.setProduct_name(rs.getString("product_name"));
                pr.setRam(rs.getString("ram"));
                pr.setRom(rs.getString("rom"));
                pr.setBattery_capacity(rs.getString("battery_capacity"));
                pr.setChip(rs.getString("chip"));
                pr.setBrand_id(rs.getInt("brand_id"));
                pr.setOrigin_id(rs.getInt("origin_id"));
                pr.setImage_path(rs.getString("image_path"));
                arr.add(pr);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return arr;
    }

    public boolean addProduct(ProductDTO pro) {
        boolean result = false;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "Insert into Product values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pro.getProduct_id());
            stmt.setString(2, pro.getProduct_name());
            stmt.setString(3, pro.getRam());
            stmt.setString(4, pro.getRom());
            stmt.setString(5, pro.getBattery_capacity());
            stmt.setString(6, pro.getChip());
            stmt.setInt(7, pro.getBrand_id());
            stmt.setInt(8, pro.getOrigin_id());
            stmt.setString(9, pro.getStatus());
            stmt.setString(10, pro.getImage_path());
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(connection);
        }

        return result;
    }

    public boolean updateProduct(ProductDTO pro) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Product SET product_name=?, ram=?, rom=?, battery_capacity=?, chip=?, brand_id=?, origin_id=?, status=?, image_path=? WHERE product_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, pro.getProduct_name());
            stmt.setString(2, pro.getRam());
            stmt.setString(3, pro.getRom());
            stmt.setString(4, pro.getBattery_capacity());
            stmt.setString(5, pro.getChip());
            stmt.setInt(6, pro.getBrand_id());
            stmt.setInt(7, pro.getOrigin_id());
            stmt.setString(8, pro.getStatus());
            stmt.setString(9, pro.getImage_path());
            stmt.setInt(10, pro.getProduct_id());
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }

    public boolean deleteProduct(int productID) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Product set status = 'disable' WHERE product_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, productID);
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }

    public Vector<ProductDTO> searchProduct(String searchText) {
        Vector<ProductDTO> arr = new Vector<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql;
            PreparedStatement stmt;
            if (isNumeric(searchText)) {
                sql = "SELECT * FROM Product WHERE product_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, searchText);
            } else {
                sql = "SELECT * FROM Product WHERE product_name LIKE ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + searchText + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductDTO pr = new ProductDTO();
                pr.setProduct_id(rs.getInt("product_id"));
                pr.setProduct_name(rs.getString("product_name"));
                pr.setRam(rs.getString("ram"));
                pr.setRom(rs.getString("rom"));
                pr.setBattery_capacity(rs.getString("battery_capacity"));
                pr.setChip(rs.getString("chip"));
                pr.setBrand_id(rs.getInt("brand_id"));
                pr.setOrigin_id(rs.getInt("origin_id"));
                pr.setImage_path(rs.getString("image_path"));
                arr.add(pr);
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

    public boolean hasProductID(int id) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Product where product_id=" + id;
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
    public ProductDTO getProductbyID(int id){
            ProductDTO product = null;
            Connection con = JDBCUtil.getConnection();
            try {
                String sql = "SELECT * FROM Product WHERE product_id=?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    product = new ProductDTO();
                    product.setProduct_id(rs.getInt("product_id"));
                    product.setProduct_name(rs.getString("product_name"));
                    product.setRam(rs.getString("ram"));
                    product.setRom(rs.getString("rom"));
                    product.setBattery_capacity(rs.getString("battery_capacity"));
                    product.setChip(rs.getString("chip"));
                    product.setBrand_id(rs.getInt("brand_id"));
                    product.setOrigin_id(rs.getInt("origin_id"));
                    product.setImage_path(rs.getString("image_path"));
                }
            } catch (SQLException ex) {
                System.err.println(ex);
            } finally {
                JDBCUtil.closeConnection(con);
            }
            return product;

    }
}