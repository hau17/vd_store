package phonestore.BUS;

import java.util.Vector;

import phonestore.DAO.CustomerDAL;
import phonestore.DTO.CustomerDTO;

public class CustomerBLL {
    CustomerDAL cusDAL = new CustomerDAL();

    public Vector<CustomerDTO> getAllCustomers() {
        return cusDAL.getAllCustomers();
    }

    public String addCustomer(CustomerDTO cus) {
        if (cusDAL.hasCustomerID(cus.getCustomer_id())) {
            return "Customer ID already exists";
        }
        if (cusDAL.addCustomer(cus))
            return "Successfully added";
        return "Failed to add";
    }

    public String updateCustomer(CustomerDTO cus) {
        if (!cusDAL.hasCustomerID(cus.getCustomer_id()))
            return "Customer ID does not exist";
        if (cusDAL.updateCustomer(cus))
            return "Successfully updated";
        return "Failed to update";
    }

    public String deleteCustomer(CustomerDTO cus) {
        if (!cusDAL.hasCustomerID(cus.getCustomer_id()))
            return "Customer ID does not exist";
        if (cusDAL.deleteCustomer(cus.getCustomer_id()))
            return "Successfully deleted";
        return "Failed to delete";

    }

    public Vector<CustomerDTO> searchCustomer(String searchText) {
        return cusDAL.searchCustomer(searchText);
    }
    public String getCustomerNameById(int id){
        CustomerDTO cdto=null;
        Vector<CustomerDTO> vector= cusDAL.getAllCustomers();
        for(CustomerDTO customerDTO: vector){
            if (customerDTO.getCustomer_id() == id) {
                cdto= customerDTO;
            }
        }
        return cdto.getCustomer_name();
    }
    public CustomerDTO getCustomerDTOByID(int id){
        return cusDAL.getCustomerByID(id);
    }
    public int getLastCustomerID(){
        return cusDAL.getLastCustomerID();
    }
    
}
