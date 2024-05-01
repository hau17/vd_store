package phonestore.DTO;

import java.math.BigDecimal;

public class WareHouseDTO {
    private int productId;
    private int quantity;
    private BigDecimal price;
    private int status;

    public WareHouseDTO() {
    }

    public WareHouseDTO(int productId, int quantity, BigDecimal price, int status) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "WareHouseDTO{" + "productId=" + productId + ", quantity=" + quantity + ", price=" + price + ", status=" + status + '}';
    }

    
}
