package phonestore.BUS;

import java.util.ArrayList;

import phonestore.DAO.SuplierDAO;
import phonestore.DTO.SuplierDTO;

public class SuplierBUS {
    public ArrayList<SuplierDTO> arr_SuplierDTOs = new ArrayList<>();
    public SuplierDAO suplierDAO = new SuplierDAO();

    public SuplierBUS() {
        this.arr_SuplierDTOs = suplierDAO.getselectAll();
    }

    public ArrayList<SuplierDTO> getAllSuplier() {
        return arr_SuplierDTOs = suplierDAO.getselectAll();
    }

    public boolean add_suplier(SuplierDTO suplierDTO) {
        boolean check = false;
        try {
            check = suplierDAO.insert(suplierDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean update_suplier(SuplierDTO suplierDTO) {
        boolean check = false;
        try {
            check = suplierDAO.update(suplierDTO) != 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean delete_suplier(int id) {
        boolean check = false;
        try {
            check = suplierDAO.delete(suplierDAO.selectById(id)) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<SuplierDTO> arr_search_suplier(String object) {
        ArrayList<SuplierDTO> arr = new ArrayList<>();
        for (SuplierDTO suplierDTO : arr_SuplierDTOs) {
            String id = Integer.toString(suplierDTO.getSuplierId());
            try {
                if (id.equals(object) || suplierDTO.getSuplierName().contains(object)
                        || suplierDTO.getEmailAddress().contains(object) || suplierDTO.getPhoneNumber().contains(object)
                        || suplierDTO.getAddress().contains(object)) {
                    arr.add(suplierDTO);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public int getLastSupplierID() {
        SuplierDTO suplierDTO = arr_SuplierDTOs.get(arr_SuplierDTOs.size() - 1);
        int i = suplierDTO.getSuplierId() + 1;
        return i;
    }
}