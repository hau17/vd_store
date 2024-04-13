package phonestore.DTO;

import java.sql.Date;

public class GRNDTO {
    private int grnId;
    private int suplierId;
    private Date inputDay;
    private int userId;
    private int totalAmount;

    public GRNDTO() {
    }

    public int getGrnId() {
        return grnId;
    }

    public void setGrnId(int grnId) {
        this.grnId = grnId;
    }

    public int getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(int suplierId) {
        this.suplierId = suplierId;
    }

    public Date getInputDay() {
        return inputDay;
    }

    public void setInputDay(Date inputDay) {
        this.inputDay = inputDay;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public GRNDTO(int grnId, int suplierId, Date inputDay, int userId, int totalAmount) {
        this.grnId = grnId;
        this.suplierId = suplierId;
        this.inputDay = inputDay;
        this.userId = userId;
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "GRNDTO [grnId=" + grnId + ", suplierId=" + suplierId + ", inputDay=" + inputDay + ", userId=" + userId
                + ", totalAmount=" + totalAmount + "]";
    }
}
