package phonestore.DTO;

public class invoiceDetailDTO {
    private int invoiceDetailId;
    private int invoiceId;
    private int quantity;

    public int getInvoiceDetailId() {
        return invoiceDetailId;
    }

    @Override
    public String toString() {
        return "invoiceDetailDTO [invoiceDetailId=" + invoiceDetailId + ", invoiceId=" + invoiceId + ", quantity="
                + quantity + ", productId=" + productId + ", price=" + price + "]";
    }

    public void setInvoiceDetailId(int invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int productId;
    private int price;

    public invoiceDetailDTO() {
    }

    public invoiceDetailDTO(int invoiceDetailId, int invoiceId, int quantity, int productId, int price) {
        this.invoiceDetailId = invoiceDetailId;
        this.invoiceId = invoiceId;
        this.quantity = quantity;
        this.productId = productId;
        this.price = price;
    }

}
