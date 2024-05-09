/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import phonestore.DAO.StatistisDAO;
import phonestore.DTO.StatistisDTO;
import phonestore.DTO.invoiceDetailDTO;

/**
 *
 * @author congh
 */
public class StatisticBUS {
    public StatistisDAO statistisDAO=new StatistisDAO();
    public ProductBLL productBLL=new ProductBLL();
    
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
            totalPrice +=inDTO.getPrice()*inDTO.getQuantity();        
        }
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
    public boolean ExportExcel(String path ,Date date ){
        boolean check=false;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String simpdate =simpleDateFormat.format(date);
        ArrayList<invoiceDetailDTO> arr = statistisDAO.getArrInvoiceByDate(simpdate);
        try {
            Workbook workbook= new XSSFWorkbook();
            Sheet sheet=workbook.createSheet("invoice");
            Row rowDate =sheet.createRow(0);
            rowDate.createCell(0).setCellValue("Date");
            rowDate.createCell(1).setCellValue(simpdate);
            Row rowHeader=sheet.createRow(1);
            rowHeader.createCell(0).setCellValue("Phone ID");
            rowHeader.createCell(1).setCellValue("Phone Name");
            rowHeader.createCell(2).setCellValue("Quantity");
            rowHeader.createCell(3).setCellValue("Price");
            
            int rowNum=2;
            for(invoiceDetailDTO inDTO: arr){
                Row row =sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(inDTO.getProductId());
                row.createCell(1).setCellValue(productBLL.getProductDTO(inDTO.getProductId()).getProduct_name());
                row.createCell(2).setCellValue(inDTO.getQuantity());
                row.createCell(3).setCellValue(inDTO.getPrice());
            }
            try {
                FileOutputStream fileOutputStream= new FileOutputStream(path);
                workbook.write(fileOutputStream);
                check=true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean ExportExcel(String path , Date fromDate,Date toDate){
        boolean check=false;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String fromdate =simpleDateFormat.format(fromDate);
        String todate =simpleDateFormat.format(toDate);
        ArrayList<StatistisDTO> arrayList=statistisDAO.getArrProductByDateAndDate(fromdate, todate);
        try {
            Workbook workbook=new XSSFWorkbook();
            Sheet sheet=workbook.createSheet("Product");
            Row dateRow=sheet.createRow(0);
            dateRow.createCell(0).setCellValue("From");
            dateRow.createCell(1).setCellValue(fromdate);
            dateRow.createCell(2).setCellValue("To");
            dateRow.createCell(3).setCellValue(todate);
            Row headRow=sheet.createRow(1);
            headRow.createCell(0).setCellValue("Phone ID");
            headRow.createCell(1).setCellValue("Phone name");
            headRow.createCell(2).setCellValue("Total quantity");
            headRow.createCell(3).setCellValue("Total price");
            int rowNum=2;
            for (StatistisDTO sdto:arrayList) {                
                Row row=sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(sdto.getProductID());
                row.createCell(1).setCellValue(productBLL.getProductDTO(sdto.getProductID()).getProduct_name());
                row.createCell(2).setCellValue(sdto.getTotalQuantity());
                row.createCell(3).setCellValue(sdto.getTotalPrice());
            }
            try {
                FileOutputStream fileOutputStream=new FileOutputStream(path);
                workbook.write(fileOutputStream);
                check=true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
