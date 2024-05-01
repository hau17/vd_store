package phonestore.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import phonestore.DTO.UserDTO;
import phonestore.config.JDBCUtil;

public class UserDAO implements DAOInterface<UserDTO> {
    public static UserDAO getInstance() {
        return new UserDAO();
    }

    @Override
    public int insert(UserDTO user) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "INSERT INTO User(user_id, user_name, password, full_name, date_of_birth, phone_number, email_address, role_id, status) VALUES(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user.getuser_id());
            ps.setString(2, user.getuser_name());
            ps.setInt(3, user.getPassword());
            ps.setString(4, user.getfull_name());
            ps.setString(5, user.getdate_of_birth());
            ps.setString(6, user.getphone_number());
            ps.setString(7, user.getemail_address());
            ps.setInt(8, user.getrole_id());
            ps.setInt(9, user.getStatus());
            result = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }

        return result;
    }

    @Override
    public int delete(UserDTO user) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE User SET status = ? WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, user.getuser_id());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    @Override
    public int update(UserDTO user) {
        int result = 0;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE User SET user_name = ?, password = ?, full_name = ?, date_of_birth = ?, phone_number = ?, email_address = ?, role_id = ? WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getuser_name());
            ps.setInt(2, user.getPassword());
            ps.setString(3, user.getfull_name());
            ps.setString(4, user.getdate_of_birth());
            ps.setString(5, user.getphone_number());
            ps.setString(6, user.getemail_address());
            ps.setInt(7, user.getrole_id());
            ps.setInt(8, user.getuser_id());
            result = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }

    @Override
    public ArrayList<UserDTO> getselectAll() {
        ArrayList<UserDTO> userDTOs = new ArrayList<>();
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM User WHERE status = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String user_name = rs.getString("user_name");
                int password = rs.getInt("password");
                String full_name = rs.getString("full_name");
                String date_of_birth = rs.getString("date_of_birth");
                String phone_number = rs.getString("phone_number");
                String email_address = rs.getString("email_address");
                int role_id = rs.getInt("role_id");
                int status = rs.getInt("status");
                UserDTO userDTO = new UserDTO(user_id, user_name, password, full_name, date_of_birth, phone_number,
                        email_address, role_id, status);
                userDTOs.add(userDTO);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return userDTOs;
    }

    @Override
    public UserDTO selectById(int user_id) {
        UserDTO userDTO = null;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM User WHERE user_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String user_name = rs.getString("user_name");
                int password = rs.getInt("password");
                String full_name = rs.getString("full_name");
                String date_of_birth = rs.getString("date_of_birth");
                String phone_number = rs.getString("phone_number");
                String email_address = rs.getString("email_address");
                int role_id = rs.getInt("role_id");
                int status = rs.getInt("status");
                userDTO = new UserDTO(user_id, user_name, password, full_name, date_of_birth, phone_number,
                        email_address, role_id, status);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return userDTO;
    }
        public boolean checkLogin(String user, int pass) {
        int check = 0;
        boolean result = false;
        Connection con = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM user WHERE user_name = ? AND password = ?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user);
            st.setInt(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                check = rs.getInt("password");

            }
            if (check != 0) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(con);
        }
        return result;
    }
}
