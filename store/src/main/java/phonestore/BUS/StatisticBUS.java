/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;

import java.util.ArrayList;
import phonestore.DAO.StatistisDAO;
import phonestore.DTO.StatistisDTO;

/**
 *
 * @author congh
 */
public class StatisticBUS {
    public StatistisDAO statistisDAO=new StatistisDAO();
    public int getTotalPrice(String fromDate, String toDate){
        int totalPrice=0;
        ArrayList<StatistisDTO> arrayList=statistisDAO.getArrByDateAndDate(fromDate, toDate);
        for(StatistisDTO statistisDTO: arrayList){
            totalPrice +=statistisDTO.getTotalPrice();
        }
        return totalPrice;
    }
    public int getTotalQuantity(String fromDate, String toDate){
    int totalQuantity=0;
    ArrayList<StatistisDTO> arrayList=statistisDAO.getArrByDateAndDate(fromDate, toDate);
    for(StatistisDTO statistisDTO: arrayList){
        totalQuantity +=statistisDTO.getTotalQuantity();
    }
    return totalQuantity;
    }
}
