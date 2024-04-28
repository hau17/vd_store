package phonestore.DTO;

public class CustomerDTO {
    private int customer_id;
    private String customer_name;
    private int phone_number;
    private String address;

    public CustomerDTO(int customer_id, String customer_name, int phone_number, String address) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.phone_number = phone_number;
        this.address = address;
    }

    public CustomerDTO() {
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" + "customer_id=" + customer_id + ", customer_name=" + customer_name + ", phone_number=" + phone_number + ", address=" + address + '}';
    }

}
