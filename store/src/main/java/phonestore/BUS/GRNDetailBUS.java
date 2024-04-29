package phonestore.BUS;

import java.util.ArrayList;

import phonestore.DAO.GRNDetailDAO;
import phonestore.DTO.GRNDetailDTO;

public class GRNDetailBUS {
    ArrayList<GRNDetailDTO> arrGrnDetailDTOs = new ArrayList<>();
    GRNDetailDAO grnDetailDAO = new GRNDetailDAO();

    public GRNDetailBUS() {
        this.arrGrnDetailDTOs = grnDetailDAO.getselectAll();
    }

    public ArrayList<GRNDetailDTO> getAllDetail() {
        ArrayList<GRNDetailDTO> arr = grnDetailDAO.getselectAll();
        return arr;
    }

    public boolean insertGRNDetailBUS(GRNDetailDTO grnDetailDTO) {
        boolean check = false;
        try {
            check = grnDetailDAO.insert(grnDetailDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean deleteGRNDetailBUS(GRNDetailDTO grnDetailDTO) {
        boolean check = false;
        try {
            check = grnDetailDAO.delete(grnDetailDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean updateGRNDetailBUS(GRNDetailDTO grnDetailDTO) {
        boolean check = false;
        try {
            check = grnDetailDAO.update(grnDetailDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<GRNDetailDTO> arrSearchArrayList(String stringSearch) {
        ArrayList<GRNDetailDTO> arr = grnDetailDAO.getselectAll();

        for (GRNDetailDTO grnDetailDTO : arr) {
            String grn_detail_id = Integer.toString(grnDetailDTO.getGrnDetailID());
            String grn_id = Integer.toString(grnDetailDTO.getGrnID());
            String quantity = Integer.toString(grnDetailDTO.getQuantity());
            String product_id = Integer.toString(grnDetailDTO.getProductID());
            if (grn_detail_id.equals(stringSearch) || grn_id.contains(stringSearch) ||
                    quantity.contains(stringSearch) || product_id.contains(stringSearch)) {
                arr.add(grnDetailDTO);
            }
        }
        return arr;
    }

    public ArrayList<GRNDetailDTO> arrShowDetailDTOByID(int id) {
        ArrayList<GRNDetailDTO> arrayList = grnDetailDAO.getselectAll();
        ArrayList<GRNDetailDTO> arr = new ArrayList<>();
        for (GRNDetailDTO grnDetailDTO : arrayList) {
            if (grnDetailDTO.getGrnID() == id) {
                arr.add(grnDetailDTO);
            }
        }
        return arr;
    }
}