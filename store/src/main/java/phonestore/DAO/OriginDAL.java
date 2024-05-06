package phonestore.DAO;

import java.sql.*;
import java.util.Vector;

import phonestore.DTO.OriginDTO;
import phonestore.config.JDBCUtil;

public class OriginDAL {
    public static OriginDAL getInstance() {
        return new OriginDAL();
    }

    public Vector<OriginDTO> getAllOrigins() {
        Vector<OriginDTO> arr = new Vector<OriginDTO>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Origin where status = 'active'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                OriginDTO br = new OriginDTO();
                br.setOrigin_id(rs.getInt("Origin_id"));
                br.setOrigin_name(rs.getString("Origin_name"));

                arr.add(br);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return arr;
    }

    public boolean addOrigin(OriginDTO org) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Insert into Origin values(?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, org.getOrigin_id());
            stmt.setString(2, org.getOrigin_name());
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

    public boolean updateOrigin(OriginDTO bra) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Origin SET origin_name=? WHERE origin_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, bra.getOrigin_name());
            stmt.setInt(2, bra.getOrigin_id());
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    public boolean deleteOrigin(int originID) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE Origin set status = 'disable' WHERE origin_id=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, originID);
            if (stmt.executeUpdate() >= 1)
                result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    public Vector<OriginDTO> searchOrigin(String searchText) {
        Vector<OriginDTO> arr = new Vector<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql;
            PreparedStatement stmt;
            if (isNumeric(searchText)) {
                sql = "SELECT * FROM Origin WHERE origin_id = ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, searchText);
            } else {
                sql = "SELECT * FROM Origin WHERE origin_name LIKE ?";
                stmt = con.prepareStatement(sql);
                stmt.setString(1, "%" + searchText + "%");
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                OriginDTO bra = new OriginDTO();
                bra.setOrigin_id(rs.getInt("origin_id"));
                bra.setOrigin_name(rs.getString("origin_name"));
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

    public boolean hasOriginID(int id) {
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "Select * from Origin where origin_id=" + id;
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
        public int getLastOriginID(){
        int i=0;
        Connection connection=JDBCUtil.getConnection();
        try {
            String sql ="SELECT origin_id"+
                    " FROM origin"+
                    " WHERE origin_id= (SELECT MAX(origin_id) FROM origin)";
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()) {
                i = resultSet.getInt("origin_id")+1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
