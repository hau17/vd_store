package phonestore.DTO;

import java.math.BigDecimal;

public class GRNDetailsDTO {
    private int grnDetailsId;
    private int grnId;
    private int quantity;
    private int productId;
    private BigDecimal price;

    public GRNDetailsDTO() {
    }

    public GRNDetailsDTO(int grnDetailsId, int grnId, int quantity, int productId, BigDecimal price) {
        this.grnDetailsId = grnDetailsId;
        this.grnId = grnId;
        this.quantity = quantity;
        this.productId = productId;
        this.price = price;
    }

    public int getGrnDetailsId() {
        return grnDetailsId;
    }

    public void setGrnDetailsId(int grnDetailsId) {
        this.grnDetailsId = grnDetailsId;
    }

    public int getGrnId() {
        return grnId;
    }

    public void setGrnId(int grnId) {
        this.grnId = grnId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GRNDetails [grnDetailsId=" + grnDetailsId + ", grnId=" + grnId + ", quantity=" + quantity
                + ", productId=" + productId + ", price=" + price + "]";
    }
}
