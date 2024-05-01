/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;
import java.math.BigDecimal;
import phonestore.DTO.WareHouseDTO;
import phonestore.DAO.WareHouseDAO;
import java.util.ArrayList;

/**
 *
 * @author congh
 */
public class WarehouseBUS {
    ArrayList<WareHouseDTO> arrayList = new ArrayList<>();
    WareHouseDAO warehouseDAO= new WareHouseDAO();
    public WarehouseBUS(){
        this.arrayList= warehouseDAO.getselectAll();
    }
    public ArrayList<WareHouseDTO> getAllWareHouseDTOs(){
        return warehouseDAO.getselectAll();
    }
    public boolean insert(WareHouseDTO wareHouseDTO){
        boolean check= false;
        try {
            check = warehouseDAO.insert(wareHouseDTO)!=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean update(WareHouseDTO wareHouseDTO){
        boolean check= false;
        try {
            check = warehouseDAO.update(wareHouseDTO)!=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean delete(WareHouseDTO wareHouseDTO){
        boolean check= false;
        try {
            check = warehouseDAO.delete(wareHouseDTO)!=0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public  ArrayList<WareHouseDTO> search(String object){
        ArrayList<WareHouseDTO> arr_searchArrayList=new ArrayList<>();
        for(WareHouseDTO wareHouseDTO : arrayList){
            String id =Integer.toString(wareHouseDTO.getProductId());
            String quantity = Integer.toString(wareHouseDTO.getQuantity());
            String price = wareHouseDTO.getPrice().toString();
            if (id.contains(object) || quantity.contains(object) || price.contains(object)) {
                arr_searchArrayList.add(wareHouseDTO);
            }
        }
        return arr_searchArrayList;
    }
    public int getLastWarehouseID(){
        return warehouseDAO.getLastWarehouseID();
    }
}
