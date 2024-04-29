package phonestore.DTO;

import java.math.BigDecimal;

public class GRNDetailDTO {
    private int grnDetailID;
    private int grnID;
    private int quantity;
    private int productID;
    private BigDecimal price;

    public GRNDetailDTO() {
    }

    public GRNDetailDTO(int grnDetailID, int grnID, int quantity, int productID, BigDecimal price) {
        this.grnDetailID = grnDetailID;
        this.grnID = grnID;
        this.quantity = quantity;
        this.productID = productID;
        this.price = price;
    }

    public int getGrnDetailID() {
        return grnDetailID;
    }

    public void setGrnDetailID(int grnDetailID) {
        this.grnDetailID = grnDetailID;
    }

    public int getGrnID() {
        return grnID;
    }

    public void setGrnID(int grnID) {
        this.grnID = grnID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GRNDetailDTO [grnDetailID=" + grnDetailID + ", grnID=" + grnID + ", quantity=" + quantity
                + ", productID=" + productID + ", price=" + price + "]";
    }

}
