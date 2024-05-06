package phonestore.BUS;

import java.util.Vector;

import phonestore.DAO.ProductDAL;
import phonestore.DTO.ProductDTO;

public class ProductBLL {
    ProductDAL prDAL = new ProductDAL();

    public Vector<ProductDTO> getAllProducts() {
        return prDAL.getAllProducts();
    }

    public String addProduct(ProductDTO pr) {
        if (prDAL.hasProductID(pr.getProduct_id())) {
            return "Product ID already exists";
        }
        if (prDAL.addProduct(pr))
            return "Successfully added";
        return "Failed to add";
    }

    public String updateProduct(ProductDTO pr) {
        if (!prDAL.hasProductID(pr.getProduct_id()))
            return "Product ID does not exist";
        if (prDAL.updateProduct(pr))
            return "Successfully updated";
        return "Failed to update";
    }

    public String deleteProduct(ProductDTO pr) {
        if (!prDAL.hasProductID(pr.getProduct_id()))
            return "Product ID does not exist";
        if (prDAL.deleteProduct(pr.getProduct_id()))
            return "Successfully deleted";
        return "Failed to delete";

    }

    public Vector<ProductDTO> searchProduct(String searchText) {
        return prDAL.searchProduct(searchText);
    }

    public ProductDTO getProductDTO(int id) {
        ProductDTO pro = null;
        Vector<ProductDTO> vector = prDAL.getAllProducts();
        for (ProductDTO productDTO : vector) {
            if (productDTO.getProduct_id() == id) {
                pro = productDTO;
            }
        }
        return pro;
    }
    public int getLastProductID(){
        return prDAL.getLastProductID();
    }
}
