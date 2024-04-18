package phonestore.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import java.sql.ResultSet;
import phonestore.DTO.GRNDTO;
import phonestore.config.JDBCUtil;

public class GRNDAO implements DAOInterface<GRNDTO> {
    public static GRNDAO getInstance() {
        return new GRNDAO();
    }

    @Override
    public int insert(GRNDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getInstance().getConnection();
        try {
            String sql = "INSERT INTO GoodReceivedNote(grn_id, supplier_id, input_day, user_id, total_amount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getGrnId());
            ps.setInt(2, t.getSuplierId());
            ps.setDate(3, t.getInputDay());
            ps.setInt(4, t.getUserId());
            ps.setInt(5, t.getTotalAmount());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeconnection();
        }
        return result;
    }

    @Override
    public int delete(GRNDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getInstance().getConnection();
        try {
            String sql = "DELETE FROM GoodReceivedNote WHERE grn_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getGrnId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeconnection();
        }
        return result;
    }

    @Override
    public int update(GRNDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getInstance().getConnection();
        try {
            String sql = "UPDATE GoodReceivedNote SET supplier_id = ?, input_day = ?, user_id = ?, total_amount = ? WHERE grn_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getSuplierId());
            ps.setDate(2, t.getInputDay());
            ps.setInt(3, t.getUserId());
            ps.setInt(4, t.getTotalAmount());
            ps.setInt(5, t.getGrnId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeconnection();
        }
        return result;
    }

    @Override
    public ArrayList<GRNDTO> getselectAll() {
        ArrayList<GRNDTO> arr = new ArrayList<>();
        Connection con = JDBCUtil.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM GoodReceivedNote";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int grnId = rs.getInt("grn_id");
                int supplierId = rs.getInt("supplier_id");
                Date inputDay = rs.getDate("input_day");
                int userId = rs.getInt("user_id");
                int totalAmount = rs.getInt("total_amount");
                GRNDTO grnDTO = new GRNDTO(grnId, supplierId, inputDay, userId, totalAmount);
                arr.add(grnDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeconnection();
        }
        return arr;
    }

    @Override
    public GRNDTO selectById(int id) {
        GRNDTO grnDTO = null;
        Connection con = JDBCUtil.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM GoodReceivedNote WHERE grn_id = " + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int grnId = rs.getInt("grn_id");
                int supplierId = rs.getInt("supplier_id");
                Date inputDay = rs.getDate("input_day");
                int userId = rs.getInt("user_id");
                int totalAmount = rs.getInt("total_amount");
                grnDTO = new GRNDTO(grnId, supplierId, inputDay, userId, totalAmount);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.getInstance().closeconnection();
        }
        return grnDTO;
    }
}
