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
        return arr_SuplierDTOs=suplierDAO.getselectAll();
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
            try {
                if (suplierDTO.getSuplierId() == Integer.parseInt(object) || suplierDTO.getSuplierName().equals(object)
                        || suplierDTO.getEmailAddress().equals(object) || suplierDTO.getPhoneNumber().equals(object)
                        || suplierDTO.getAddress().equals(object)) {
                    arr.add(suplierDTO);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
}
