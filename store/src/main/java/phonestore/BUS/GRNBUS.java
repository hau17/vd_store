/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;

import java.util.ArrayList;

import phonestore.DAO.GRNDAO;
import phonestore.DTO.GRNDTO;

public class GRNBUS {
    ArrayList<GRNDTO> arrGrnDTOs = new ArrayList<>();
    static GRNDAO grnDAO = new GRNDAO();

    public GRNBUS() {
        this.arrGrnDTOs = grnDAO.getselectAll();
    }

    public static ArrayList<GRNDTO> getAllGRN() {
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
        ArrayList<GRNDTO> arr = grnDAO.getselectAll();

        for (GRNDTO grnDTO : arr) {
            String grnId = Integer.toString(grnDTO.getGRN_id());
            String supplierId = Integer.toString(grnDTO.getSupplier_id());
            String inputDay = grnDTO.getInput_day().toString();
            String userId = Integer.toString(grnDTO.getUser_id());
            String totalAmount = grnDTO.getTotal_amount().toString();

            if (grnId.equals(stringSearch) || supplierId.equals(stringSearch) ||
                    inputDay.contains(stringSearch) || userId.equals(stringSearch) ||
                    totalAmount.equals(stringSearch)) {
                arr.add(grnDTO);
            }
        }
        return arr;
    }

    public ArrayList<GRNDTO> getGRNByID(int id) {
        ArrayList<GRNDTO> arrayList = grnDAO.getselectAll();
        ArrayList<GRNDTO> arr = new ArrayList<>();
        for (GRNDTO grnDTO : arrayList) {
            if (grnDTO.getGRN_id() == id) {
                arr.add(grnDTO);
            }
        }
        return arr;
    }
}