package phonestore.DTO;

public class SuplierDTO {
    private int suplierId;
    private String suplierName;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    private int status;

    public SuplierDTO() {
    }

    public SuplierDTO(int suplierId, String suplierName, String emailAddress, String phoneNumber, String address,
            int status) {
        this.suplierId = suplierId;
        this.suplierName = suplierName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.status = status;
    }

    @Override
    public String toString() {
        return "SuplierDTO [suplierId=" + suplierId + ", suplierName=" + suplierName + ", emailAddress=" + emailAddress
                + ", phoneNumber=" + phoneNumber + ", address=" + address + ", status=" + status + "]";
    }

    public int getSuplierId() {
        return suplierId;
    }

    public void setSuplierId(int suplierId) {
        this.suplierId = suplierId;
    }

    public String getSuplierName() {
        return suplierName;
    }

    public void setSuplierName(String suplierName) {
        this.suplierName = suplierName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
