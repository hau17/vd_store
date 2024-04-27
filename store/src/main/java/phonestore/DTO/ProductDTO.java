package phonestore.DTO;

public class ProductDTO {
    private int product_id;
    private String product_name;
    private String ram;
    private String rom;
    private String battery_capacity;
    private String chip;
    private int brand_id;
    private int origin_id;
    private String status;
    private String image_path;

    public ProductDTO(int product_id, String product_name, String ram, String rom, String battery_capacity, String chip,
            int brand_id, int origin_id, String status, String image_path) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.ram = ram;
        this.rom = rom;
        this.battery_capacity = battery_capacity;
        this.chip = chip;
        this.brand_id = brand_id;
        this.origin_id = origin_id;
        this.status = status;
        this.image_path = image_path;
    }

    public ProductDTO() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getBattery_capacity() {
        return battery_capacity;
    }

    public void setBattery_capacity(String battery_capacity) {
        this.battery_capacity = battery_capacity;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public int getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(int origin_id) {
        this.origin_id = origin_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
