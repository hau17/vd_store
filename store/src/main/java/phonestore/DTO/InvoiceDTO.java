package phonestore.DTO;

import java.math.BigDecimal;
import java.sql.Date;

public class InvoiceDTO {
    private int invoiceId;
    private int customer_id;
    private int userId;
    private Date dateOfInvoice;
    private BigDecimal totalAmount;
    private int status;

    public InvoiceDTO() {
    }

    @Override
    public String toString() {
        return "InvoiceDTO [invoiceId=" + invoiceId + ", customer_id=" + customer_id + ", userId=" + userId
                + ", dateOfInvoice=" + dateOfInvoice + ", totalAmount=" + totalAmount + ", status=" + status + "]";
    }

    public InvoiceDTO(int invoiceId, int customer_id, int userId, Date dateOfInvoice, BigDecimal totalAmount,
            int status) {
        this.invoiceId = invoiceId;
        this.customer_id = customer_id;
        this.userId = userId;
        this.dateOfInvoice = dateOfInvoice;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateOfInvoice() {
        return dateOfInvoice;
    }

    public void setDateOfInvoice(Date dateOfInvoice) {
        this.dateOfInvoice = dateOfInvoice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
