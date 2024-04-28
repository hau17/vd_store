package phonestore.BUS;

import java.util.Vector;

import phonestore.DAO.BrandDAL;
import phonestore.DTO.BrandDTO;

public class BrandBLL {
    BrandDAL braDAL = new BrandDAL();

    public Vector<BrandDTO> getAllBrands() {
        return braDAL.getAllBrands();
    }

    public String addBrand(BrandDTO bra) {
        if (braDAL.hasBrandID(bra.getBrand_id())) {
            return "Brand ID already exists";
        }
        if (braDAL.addBrand(bra))
            return "Successfully added";
        return "Failed to add";
    }

    public String updateBrand(BrandDTO bra) {
        if (!braDAL.hasBrandID(bra.getBrand_id()))
            return "Brand ID does not exist";
        if (braDAL.updateBrand(bra))
            return "Successfully updated";
        return "Failed to update";
    }

    public String deleteBrand(BrandDTO bra) {
        if (!braDAL.hasBrandID(bra.getBrand_id()))
            return "Brand ID does not exist";
        if (braDAL.deleteBrand(bra.getBrand_id()))
            return "Successfully deleted";
        return "Failed to delete";

    }

    public Vector<BrandDTO> searchBrand(String searchText) {
        return braDAL.searchBrand(searchText);
    }
}
