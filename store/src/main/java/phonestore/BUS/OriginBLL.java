package phonestore.BUS;

import java.util.Vector;

import phonestore.DAO.OriginDAL;
import phonestore.DTO.OriginDTO;

public class OriginBLL {
    OriginDAL braDAL = new OriginDAL();

    public Vector<OriginDTO> getAllOrigins() {
        return braDAL.getAllOrigins();
    }

    public String addOrigin(OriginDTO bra) {
        if (braDAL.hasOriginID(bra.getOrigin_id())) {
            return "Origin ID already exists";
        }
        if (braDAL.addOrigin(bra))
            return "Successfully added";
        return "Failed to add";
    }

    public String updateOrigin(OriginDTO bra) {
        if (!braDAL.hasOriginID(bra.getOrigin_id()))
            return "Origin ID does not exist";
        if (braDAL.updateOrigin(bra))
            return "Successfully updated";
        return "Failed to update";
    }

    public String deleteOrigin(OriginDTO bra) {
        if (!braDAL.hasOriginID(bra.getOrigin_id()))
            return "Origin ID does not exist";
        if (braDAL.deleteOrigin(bra.getOrigin_id()))
            return "Successfully deleted";
        return "Failed to delete";

    }

    public Vector<OriginDTO> searchOrigin(String searchText) {
        return braDAL.searchOrigin(searchText);
    }

    public OriginDTO getOriginByID(int id) {
        OriginDTO org = null;
        Vector<OriginDTO> vector = OriginDAL.getInstance().getAllOrigins();
        for (OriginDTO originDTO : vector) {
            if (originDTO.getOrigin_id() == id) {
                org = originDTO;
            }
        }
        return org;
    }
    public int getLastOriginID(){
        return braDAL.getLastOriginID();
    }
}