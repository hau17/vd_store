/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import phonestore.DTO.StatistisDTO;
import phonestore.config.JDBCUtil;

/**
 *
 * @author congh
 */
public class StatistisDAO {
//    public ArrayList<StatistisDTO> getAllData() {
//    ArrayList<StatistisDTO> arr = new ArrayList<>();
//    Connection connection = JDBCUtil.getConnection();
//    try {
//        String sql = "SELECT p.product_id, SUM(invd.quantity) AS total_quantity, SUM(invd.quantity * invd.price) AS total_price " +
//                     "FROM invoice inv " +
//                     "INNER JOIN invoice_detail invd ON inv.invoice_id = invd.invoice_id " +
//                     "INNER JOIN product p ON invd.product_id = p.product_id " +
//                     "GROUP BY p.product_id";
//        
//        Statement st = connection.createStatement();
//        ResultSet rs = st.executeQuery(sql);
//        while (rs.next()) {                
//            int id = rs.getInt("product_id");
//            int total_quantity = rs.getInt("total_quantity");
//            int total_price = rs.getInt("total_price");
//            StatistisDTO tsDTO = new StatistisDTO(id, total_quantity, total_price);
//            arr.add(tsDTO);
//        }
//        
//    } catch (Exception e) {
//        e.printStackTrace();
//    } finally {
//        JDBCUtil.closeConnection(connection);
//    }
//    return arr;
//}

    public ArrayList<StatistisDTO> getArrByDateAndDate(String fromDate ,String toDate){
        ArrayList<StatistisDTO> arr = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();
        try {
            String sql = "SELECT p.product_id, SUM(invd.quantity) AS total_quantity, SUM(invd.quantity * invd.price) AS total_price " +
                         "FROM invoice inv " +
                         "INNER JOIN invoice_detail invd ON inv.invoice_id = invd.invoice_id " +
                         "INNER JOIN product p ON invd.product_id = p.product_id " +
                         "WHERE ";
            
            if (fromDate != null && !fromDate.isEmpty() && toDate != null && !toDate.isEmpty()) {
                sql += "inv.invoice_date BETWEEN '" + fromDate + "' AND '" + toDate + "' ";
            } else {
                sql += "1=1 "; 
            }
            sql += "GROUP BY p.product_id";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                int id = rs.getInt("product_id");
                int total_quantity = rs.getInt("total_quantity");
                int total_price = rs.getInt("total_price");
                StatistisDTO tsDTO = new StatistisDTO(id, total_quantity, total_price);
                arr.add(tsDTO);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
        }
        return arr;
    }
}