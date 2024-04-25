package phonestore.BUS;

import java.util.ArrayList;

import phonestore.DAO.InvoiceDetailDAO;
import phonestore.DTO.invoiceDetailDTO;

public class InvoiceDetailBUS {
    ArrayList<invoiceDetailDTO> arr_InvoiceDetailDTOs = new ArrayList<>();
    InvoiceDetailDAO invoiceDetailDAO = new InvoiceDetailDAO();

    public InvoiceDetailBUS() {
        this.arr_InvoiceDetailDTOs = invoiceDetailDAO.getselectAll();
    }

    public ArrayList<invoiceDetailDTO> getAllDetail() {
        ArrayList<invoiceDetailDTO> arr = invoiceDetailDAO.getselectAll();
        return arr;
    }

    public boolean insertInvoiceDetailBUS(invoiceDetailDTO invoiceDetailDTO) {
        boolean check = false;
        try {
            check = invoiceDetailDAO.insert(invoiceDetailDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteInvoiceDetailBUS(invoiceDetailDTO invoiceDetailDTO) {
        boolean check = false;
        try {
            check = invoiceDetailDAO.delete(invoiceDetailDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateInvoiceDetailBUS(invoiceDetailDTO invoiceDetailDTO) {
        boolean check = false;
        try {
            check = invoiceDetailDAO.update(invoiceDetailDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<invoiceDetailDTO> arrSearchArrayList(String stringSearch) {
        ArrayList<invoiceDetailDTO> arr = invoiceDetailDAO.getselectAll();

        for (invoiceDetailDTO invoiceDetailDTO : arr) {
            String invoice_detail_id = Integer.toString(invoiceDetailDTO.getInvoiceDetailId());
            String invoice_id = Integer.toString(invoiceDetailDTO.getInvoiceId());
            String quantity = Integer.toString(invoiceDetailDTO.getQuantity());
            String product_id = Integer.toString(invoiceDetailDTO.getProductId());
            if (invoice_detail_id.equals(stringSearch) || invoice_id.contains(stringSearch) ||
                    quantity.contains(stringSearch) || product_id.contains(stringSearch)) {
                arr.add(invoiceDetailDTO);
            }
        }
        return arr;
    }
}
