/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;

import java.util.ArrayList;
import phonestore.DAO.StatistisDAO;
import phonestore.DTO.StatistisDTO;
import phonestore.DTO.invoiceDetailDTO;

/**
 *
 * @author congh
 */
public class StatisticBUS {
    public StatistisDAO statistisDAO=new StatistisDAO();
    
    public int getTotalPriceProduct(String fromDate, String toDate){
        int totalPrice=0;
        ArrayList<StatistisDTO> arrayList=statistisDAO.getArrProductByDateAndDate(fromDate, toDate);
        for(StatistisDTO statistisDTO: arrayList){
            totalPrice +=statistisDTO.getTotalPrice();
        }
        return totalPrice;
    }
    public int getTotalQuantityProduct(String fromDate, String toDate){
    int totalQuantity=0;
    ArrayList<StatistisDTO> arrayList=statistisDAO.getArrProductByDateAndDate(fromDate, toDate);
    for(StatistisDTO statistisDTO: arrayList){
        totalQuantity +=statistisDTO.getTotalQuantity();
    }
    return totalQuantity;
    }
    public int getTotalPriceinvoice(String date){
        int totalPrice=0;
        ArrayList<invoiceDetailDTO> arrayList=statistisDAO.getArrInvoiceByDate(date);
        for(invoiceDetailDTO inDTO: arrayList){
            totalPrice +=inDTO.getPrice();        }
        return totalPrice;
    }
    public int getTotalQuantityInvoice(String date){
    int totalQuantity=0;
    ArrayList<invoiceDetailDTO> arrayList=statistisDAO.getArrInvoiceByDate(date);
    for(invoiceDetailDTO inDTO: arrayList){
        totalQuantity +=inDTO.getQuantity();
    }
    return totalQuantity;
    }
}
