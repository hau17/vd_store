package phonestore.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import phonestore.DTO.WareHouseDTO;
import phonestore.config.JDBCUtil;
import java.sql.ResultSet;
import java.sql.Statement;

public class WareHouseDAO implements DAOInterface<WareHouseDTO> {
    public static WareHouseDAO getInstance() {
        return new WareHouseDAO();
    }

    @Override
    public int insert(WareHouseDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO warehouse(product_id, quantity, price) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getProductId());
            ps.setInt(2, t.getQuantity());
            ps.setBigDecimal(3, t.getPrice());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(WareHouseDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM warehouse WHERE product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getProductId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int update(WareHouseDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE warehouse SET quantity = ?, price = ? WHERE product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getQuantity());
            ps.setBigDecimal(2, t.getPrice());
            ps.setInt(3, t.getProductId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public ArrayList<WareHouseDTO> getselectAll() {
        ArrayList<WareHouseDTO> list = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM warehouse";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");
                WareHouseDTO dto = new WareHouseDTO(productId, quantity, price);
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return list;
    }

    @Override
    public WareHouseDTO selectById(int id) {
        WareHouseDTO dto = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM warehouse WHERE product_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");
                dto = new WareHouseDTO(productId, quantity, price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return dto;
    }
    public boolean descreaseProduct(int productID, int quantity){
        Connection connection=JDBCUtil.getConnection();
        boolean result=false;
        int qtt=0 ;
        try {
            String sql="SELECT * FROM warehouse WHERE product_id= "+productID;
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            while (rs.next()) {                
                qtt=rs.getInt("quantity");
            }
            if (qtt>=quantity) {
                
                int newQuantity= qtt-quantity;
                String sqlUpdate="UPDATE warehouse SET quantity = ? WHERE product_id = "+productID;
                PreparedStatement ps=connection.prepareStatement(sqlUpdate);
                ps.setInt(1, newQuantity);
                int kq= ps.executeUpdate();
                if(kq !=0){
                    result=true;
                }
            }   
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }
    

    public static void main(String[] args) {
        // ArrayList<WareHouseDTO> arr = WareHouseDAO.getInstance().getselectAll();
        // for (WareHouseDTO wareHouseDTO : arr) {
        // System.out.println(wareHouseDTO.toString());
        // }
        // WareHouseDTO wareHouseDTO = new WareHouseDTO();
        // wareHouseDTO.setProductId(4);
        // System.out.println(WareHouseDAO.getInstance().selectById(wareHouseDTO.getProductId()).toString());
    }
}