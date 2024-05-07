/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import phonestore.DTO.GRNDTO;
import phonestore.config.JDBCUtil;

/**
 *
 * @author congh
 */
public class GRNDAO implements DAOInterface<GRNDTO> {
    public static GRNDAO getInstance() {
        return new GRNDAO();
    }

    @Override
    public int insert(GRNDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO grn(GRN_id, supplier_id, input_day, user_id, total_amount) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getGRN_id());
            ps.setInt(2, t.getSupplier_id());
            ps.setDate(3, new java.sql.Date(t.getInput_day().getTime()));
            ps.setInt(4, t.getUser_id());
            ps.setBigDecimal(5, t.getTotal_amount());
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
    public int delete(GRNDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM grn WHERE GRN_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getGRN_id());
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
    public int update(GRNDTO t) {
        int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE grn SET supplier_id = ?, input_day = ?, user_id = ?, total_amount = ? WHERE GRN_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, t.getSupplier_id());
            ps.setDate(2, new java.sql.Date(t.getInput_day().getTime()));
            ps.setInt(3, t.getUser_id());
            ps.setBigDecimal(4, t.getTotal_amount());
            ps.setInt(5, t.getGRN_id());
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
    public ArrayList<GRNDTO> getselectAll() {
        ArrayList<GRNDTO> arr = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM grn";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int GRN_id = rs.getInt("GRN_id");
                int supplier_id = rs.getInt("supplier_id");
                Date input_day = rs.getDate("input_day");
                int user_id = rs.getInt("user_id");
                BigDecimal total_amount = rs.getBigDecimal("total_amount");
                GRNDTO grnDTO = new GRNDTO(GRN_id, supplier_id, input_day, user_id, total_amount);
                arr.add(grnDTO);
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
    public GRNDTO selectById(int id) {
        GRNDTO grnDTO = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM grn WHERE GRN_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int GRN_id = rs.getInt("GRN_id");
                int supplier_id = rs.getInt("supplier_id");
                Date input_day = rs.getDate("input_day");
                int user_id = rs.getInt("user_id");
                BigDecimal total_amount = rs.getBigDecimal("total_amount");
                grnDTO = new GRNDTO(GRN_id, supplier_id, input_day, user_id, total_amount);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return grnDTO;
    }
    
        public int getLastGRNID(){
        int id=0;
        Connection connection=JDBCUtil.getConnection();
        try {
            String sql ="SELECT grn_id FROM grn WHERE grn_id= (SELECT MAX(grn_id) FROM grn)";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {                
                id=resultSet.getInt("grn_id")+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return id;
    }

}
