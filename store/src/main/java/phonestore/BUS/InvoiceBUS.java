package phonestore.BUS;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import phonestore.DAO.CustomerDAL;
import phonestore.DAO.InvoiceDAO;
import phonestore.DAO.InvoiceDetailDAO;
import phonestore.DAO.ProductDAL;
import phonestore.DAO.UserDAO;
import phonestore.DTO.CustomerDTO;
import phonestore.DTO.InvoiceDTO;
import phonestore.DTO.ProductDTO;
import phonestore.DTO.UserDTO;

public class InvoiceBUS {
    public ArrayList<InvoiceDTO> arr_InvoiceDTOs = new ArrayList<>();
    public InvoiceDAO invoiceDAO = new InvoiceDAO();
    public InvoiceDetailDAO invoiceDetailDAO = new InvoiceDetailDAO();
    public CustomerDAL customerDAL = new CustomerDAL();
    public ProductDAL productDAL = new ProductDAL();
    public UserDAO userDAO = new UserDAO();

    public InvoiceBUS() {
        this.arr_InvoiceDTOs = invoiceDAO.getselectAll();
    }

    public ArrayList<InvoiceDTO> getAllInvoice() {
        return arr_InvoiceDTOs = invoiceDAO.getselectAll();
    }

    public boolean addInvoice(InvoiceDTO invoiceDTO) {
        boolean check = false;
        try {
            check = invoiceDAO.insert(invoiceDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteInvoice(int id) {
        boolean check = false;
        try {
            check = invoiceDAO.delete(invoiceDAO.selectById(id)) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateInvoice(InvoiceDTO invoiceDTO) {
        boolean check = false;
        try {
            check = invoiceDAO.update(invoiceDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<InvoiceDTO> arrSearch(String search) {
        ArrayList<InvoiceDTO> arr_search = new ArrayList<>();
        for (InvoiceDTO invoiceDTO : invoiceDAO.getselectAll()) {
            String invoiceId = Integer.toString(invoiceDTO.getInvoiceId());
            String customerName = customerDAL.getCustomerByID(invoiceDTO.getCustomer_id()).getCustomer_name();
            String userName = userDAO.selectById(invoiceDTO.getUserId()).getfull_name();
//            Date date= invoiceDTO.getDateOfInvoice();
//            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            if (invoiceId.equals(search) || customerName.contains(search) || userName.contains(search)) {
                arr_search.add(invoiceDTO);
            }
        }
        return arr_search;
    }

    public int getLastInvoiceID() {
        int id = invoiceDAO.geLastInvoiceIDInDatabase();
        return id + 1;
    }

    public void exportExcel(String path, int id) {
        InvoiceDTO invoiceDTO = InvoiceDAO.getInstance().selectById(id);
        UserDTO userDTO = UserDAO.getInstance().selectById(invoiceDTO.getUserId());
        Vector<ProductDTO> vectorProduct = productDAL.getAllProducts();
        Vector<CustomerDTO> vectorCustomerDTOs = customerDAL.getAllCustomers();
        int invoiceID = id;
        String userName = userDTO.getfull_name();
        Date date = invoiceDTO.getDateOfInvoice();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String customerName = "";
        int customerPhone = 0;
        String customerAddress = "";
        BigDecimal totalAmount = invoiceDTO.getTotalAmount();
        for (CustomerDTO customerDTO : vectorCustomerDTOs) {
            if (customerDTO.getCustomer_id() == invoiceID) {
                customerName = customerDTO.getCustomer_name();
                customerPhone = customerDTO.getPhone_number();
                customerAddress = customerDTO.getAddress();
                break;
            }
        }
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(path));
            document.open();
            Paragraph header = new Paragraph();
            header.add(new Paragraph("INVOICE"));
            Paragraph body = new Paragraph();
            body.add(new Paragraph());
            body.add(new Paragraph("invoice No:" + invoiceID));
            body.add(new Paragraph("invoice issuer:" + userName));
            body.add(new Paragraph("invoice date:" + simpleDateFormat.format(date)));
            body.add(new Paragraph("Customer Name:" + customerName));
            body.add(new Paragraph("Custome Phone:" + customerPhone));
            body.add(new Paragraph("Customer Address:" + customerAddress));
            PdfPTable pdfPTable = new PdfPTable(3);

            document.add(header);
            document.add(body);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}