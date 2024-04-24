package phonestore.BUS;

import java.util.ArrayList;

import phonestore.DAO.InvoiceDAO;
import phonestore.DTO.InvoiceDTO;

public class InvoiceBUS {
    public ArrayList<InvoiceDTO> arr_InvoiceDTOs = new ArrayList<>();
    public InvoiceDAO invoiceDAO = new InvoiceDAO();

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
            String customerId = Integer.toString(invoiceDTO.getCustomer_id());
            String userId = Integer.toString(invoiceDTO.getUserId());

            if (invoiceId.equals(search) || customerId.equals(search) || userId.equals(search)) {
                arr_search.add(invoiceDTO);
            }
        }
        return arr_search;
    }
}