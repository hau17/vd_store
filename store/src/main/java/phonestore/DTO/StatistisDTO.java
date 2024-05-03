/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.DTO;

/**
 *
 * @author congh
 */
public class StatistisDTO {
    private int productID;
    private int totalQuantity;
    private int totalPrice;

    public StatistisDTO() {
    }

    public StatistisDTO(int productID, int totalQuantity, int totalPrice) {
        this.productID = productID;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "StatistisDTO{" + "productID=" + productID + ", totalQuantity=" + totalQuantity + ", totalPrice=" + totalPrice + '}';
    }
    
}
