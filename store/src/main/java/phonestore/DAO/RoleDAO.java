/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import phonestore.DTO.RoleDTO;
import phonestore.config.JDBCUtil;

/**
 *
 * @author congh
 */
public class RoleDAO implements DAOInterface<RoleDTO>{

    @Override
    public int insert(RoleDTO t) {
        int result=0;
        Connection connection=JDBCUtil.getConnection();
        try {
            String sql ="INSERT INTO role VALUES(?,?,?)";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, t.getRoleID());
            preparedStatement.setString(2, t.getRoleName());
            preparedStatement.setString(3, t.getDescription());
            result=preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;
    }

    @Override
    public int delete(RoleDTO t) {
                int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "DELETE FROM role WHERE role_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, t.getRoleID());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;

    }

    @Override
    public int update(RoleDTO t) {
                int result = 0;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "UPDATE role SET role_name = ?, description = ? WHERE role_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, t.getRoleName());
            preparedStatement.setString(2, t.getDescription());
            preparedStatement.setInt(3, t.getRoleID());
            result = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return result;

    }

    @Override
    public ArrayList<RoleDTO> getselectAll() {
                ArrayList<RoleDTO> arr = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM role";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("role_id");
                String name = resultSet.getString("role_name");
                String description = resultSet.getString("description");
                RoleDTO roleDTO = new RoleDTO(id, name, description);
                arr.add(roleDTO);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return arr;

    }

    @Override
    public RoleDTO selectById(int id) {
                RoleDTO roleDTO = null;
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT * FROM role WHERE role_id = " + id;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int roleId = resultSet.getInt("role_id");
                String roleName = resultSet.getString("role_name");
                String description = resultSet.getString("description");
                roleDTO = new RoleDTO(roleId, roleName, description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return roleDTO;

    }
    
}
