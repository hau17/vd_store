package phonestore.DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import phonestore.DTO.GRNDTO;
import phonestore.DTO.SuplierDTO;
import phonestore.config.JDBCUtil;

public class SuplierDAO implements DAOInterface<SuplierDTO> {
    public static SuplierDAO getInstance() {
        return new SuplierDAO();
    }

    @Override
    public int insert(SuplierDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO Supplier(supplier_id, supplier_name, email_address, phone_number, address) VALUES(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getSuplierId());
            ps.setString(2, t.getSuplierName());
            ps.setString(3, t.getEmailAddress());
            ps.setString(4, t.getPhoneNumber());
            ps.setString(5, t.getAddress());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int delete(SuplierDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM Supplier WHERE supplier_id= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, t.getSuplierId());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(SuplierDTO t) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Supplier " +
                    "SET supplier_name= ?,email_address= ?,phone_number= ?,address= ? WHERE supplier_id= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, t.getSuplierName());
            ps.setString(2, t.getEmailAddress());
            ps.setString(3, t.getPhoneNumber());
            ps.setString(4, t.getAddress());
            ps.setInt(5, t.getSuplierId());
            result = ps.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ArrayList<SuplierDTO> getselectAll() {
        ArrayList<SuplierDTO> arr = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM Supplier";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("supplier_id");
                String name = rs.getString("supplier_name");
                String email_address = rs.getString("email_address");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                SuplierDTO suplierDTO = new SuplierDTO(id, name, email_address, phone_number, address);
                arr.add(suplierDTO);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @Override
    public SuplierDTO selectById(int id) {
        SuplierDTO suplierDTO = null;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM Supplier WHERE supplier_id= " + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int sup_id = rs.getInt("supplier_id");
                String name = rs.getString("supplier_name");
                String email_address = rs.getString("email_address");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                suplierDTO = new SuplierDTO(sup_id, name, email_address, phone_number, address);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return suplierDTO;
    }

    public static void main(String[] args) {
        GRNDTO grndto = new GRNDTO(10, 1, new Date(1000, 10, 10), 1, 100);
        System.out.println(grndto);
        GRNDAO.getInstance().insert(grndto);
    }
}
