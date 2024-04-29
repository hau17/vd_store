package phonestore.DTO;

public class BrandDTO {
    private int brand_id;
    private String brand_name;
    private String status;

    public BrandDTO(int brand_id, String brand_name, String status) {
        this.brand_id = brand_id;
        this.brand_name = brand_name;
        this.status = status;
    }

    public BrandDTO() {
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BrandDTO{" + "brand_id=" + brand_id + ", brand_name=" + brand_name + ", status=" + status + '}';
    }


}
