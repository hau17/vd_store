/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.DTO;

/**
 *
 * @author congh
 */
import java.math.BigDecimal;
import java.util.Date;

public class GRNDTO {
    private int GRN_id;
    private int supplier_id;
    private Date input_day;
    private int user_id;
    private BigDecimal total_amount;

    public GRNDTO() {
    }

    public GRNDTO(int GRN_id, int supplier_id, Date input_day, int user_id, BigDecimal total_amount) {
        this.GRN_id = GRN_id;
        this.supplier_id = supplier_id;
        this.input_day = input_day;
        this.user_id = user_id;
        this.total_amount = total_amount;
    }

    public int getGRN_id() {
        return GRN_id;
    }

    public void setGRN_id(int GRN_id) {
        this.GRN_id = GRN_id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Date getInput_day() {
        return input_day;
    }

    public void setInput_day(Date input_day) {
        this.input_day = input_day;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    @Override
    public String toString() {
        return "GRNDTO [GRN_id=" + GRN_id + ", supplier_id=" + supplier_id + ", input_day=" + input_day + ", user_id="
                + user_id + ", total_amount=" + total_amount + "]";
    }
}