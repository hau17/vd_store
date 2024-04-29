package phonestore.DTO;

import java.math.BigDecimal;

public class WareHouseDTO {
    private int productId;
    private int quantity;
    private BigDecimal price;

    public WareHouseDTO() {
    }

    public WareHouseDTO(int productId, int quantity, BigDecimal price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
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

    @Override
    public String toString() {
        return "WareHouseDTO [productId=" + productId + ", quantity=" + quantity + ", price=" + price + "]";
    }

}
