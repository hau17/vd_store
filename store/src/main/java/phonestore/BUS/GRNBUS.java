/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import jdk.internal.loader.URLClassPath;

import phonestore.DAO.GRNDAO;
import phonestore.DTO.GRNDTO;
import phonestore.BUS.BrandBLL;
import phonestore.BUS.OriginBLL;
import phonestore.BUS.GRNBUS;
import phonestore.BUS.GRNDetailBUS;
import phonestore.BUS.SuplierBUS;
import phonestore.DTO.GRNDetailDTO;
import sun.java2d.pipe.SpanShapeRenderer;
public class GRNBUS {
    ArrayList<GRNDTO> arrGrnDTOs = new ArrayList<>();
    static GRNDAO grnDAO = new GRNDAO();

    public GRNBUS() {
        this.arrGrnDTOs = grnDAO.getselectAll();
    }

    public ArrayList<GRNDTO> getAllGRN() {
        ArrayList<GRNDTO> arr = grnDAO.getselectAll();
        return arr;
    }

    public boolean insertGRNBUS(GRNDTO grnDTO) {
        boolean check = false;
        try {
            check = grnDAO.insert(grnDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteGRNBUS(GRNDTO grnDTO) {
        boolean check = false;
        try {
            check = grnDAO.delete(grnDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateGRNBUS(GRNDTO grnDTO) {
        boolean check = false;
        try {
            check = grnDAO.update(grnDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<GRNDTO> searchGRN(String stringSearch) {
        ArrayList<GRNDTO> arr = new ArrayList<>();
        
        for (GRNDTO grnDTO : grnDAO.getselectAll()) {
            String grnId = Integer.toString(grnDTO.getGRN_id());
            String supplierId = Integer.toString(grnDTO.getSupplier_id());
            String inputDay = grnDTO.getInput_day().toString();
            String userId = Integer.toString(grnDTO.getUser_id());
            String totalAmount = grnDTO.getTotal_amount().toString();

            if (grnId.contains(stringSearch) || supplierId.contains(stringSearch) ||
                    inputDay.contains(stringSearch) || userId.contains(stringSearch) ||
                    totalAmount.contains(stringSearch)) {
                arr.add(grnDTO);
            }
        }
        return arr;
    }

    public GRNDTO getGRNByID(int id) {
        GRNDTO grndto = null;
        grndto = grnDAO.selectById(id);
        return grndto;
    }

    public int getLastGRNID() {
        return grnDAO.getLastGRNID();
    }
    public boolean exportPdf(String path ,int GRNid){
        SuplierBUS suplierBUS=new SuplierBUS();
        GRNBUS grnbus=new GRNBUS();
        GRNDetailBUS gRNDetailBUS=new GRNDetailBUS();
        OriginBLL originBLL=new OriginBLL();
        BrandBLL brandBLL=new BrandBLL();
        ProductBLL productBLL=new ProductBLL();
        UserBUS userBUS=new UserBUS();
        GRNDTO grndto= grnbus.getGRNByID(GRNid);
        String userName= userBUS.getUserNameByID(grndto.getUser_id());
        int grnId=grndto.getGRN_id();
        int supplierID= grndto.getSupplier_id();
        String supplierName = suplierBUS.getSuplierDTOByID(grndto.getSupplier_id()).getSuplierName();
        Date d= grndto.getInput_day();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String date=simpleDateFormat.format(d);
        Document document=new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            Paragraph headerParagraph=new Paragraph();
            headerParagraph.add("GRN");
            headerParagraph.add(new Paragraph("Receipt creator:"+ userName));
            headerParagraph.add(new Paragraph("GRN ID:"+grnId));
            headerParagraph.add(new Paragraph("Date:"+date));
            headerParagraph.add(new Paragraph("Supplier ID:"+supplierID));
            headerParagraph.add(new Paragraph("Supplier Name:"+supplierName));
            headerParagraph.add(new Paragraph(new Chunk("\n\n")));
            PdfPTable pdfPTable=new PdfPTable(4);
            pdfPTable.addCell("Phone ID");
            pdfPTable.addCell("Phone Name");
            pdfPTable.addCell("Quantity");
            pdfPTable.addCell("Price");
            for(GRNDetailDTO grnddto:gRNDetailBUS.arrShowDetailDTOByID(grnId)){
                pdfPTable.addCell(grnddto.getProductID()+"");
                pdfPTable.addCell(productBLL.getProductDTO(grnddto.getProductID()).getProduct_name());
                pdfPTable.addCell(grnddto.getQuantity()+"");
                pdfPTable.addCell(grnddto.getPrice()+"");
            }
            Paragraph footerParagraph=new Paragraph();
            footerParagraph.add("Total amount:"+grndto.getTotal_amount()+"");
            document.add(headerParagraph);
            document.add(pdfPTable);
            document.add(footerParagraph);
            document.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}