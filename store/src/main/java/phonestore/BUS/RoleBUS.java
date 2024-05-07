/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.BUS;

import java.util.ArrayList;
import phonestore.DAO.RoleDAO;
import phonestore.DTO.RoleDTO;

/**
 *
 * @author congh
 */
public class RoleBUS {
    public RoleDAO roleDAO=new RoleDAO();
    public RoleBUS() {
    }

    public ArrayList<RoleDTO> getAllRole() {
        return roleDAO.getselectAll();
    }

    public boolean add_suplier(RoleDTO roleDTO) {
        boolean check = false;
        try {
            check = roleDAO.insert(roleDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean update_suplier(RoleDTO roleDTO) {
        boolean check = false;
        try {
            check = roleDAO.update(roleDTO) != 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean delete_suplier(int id) {
        boolean check = false;
        try {
            check = roleDAO.delete(roleDAO.selectById(id)) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<RoleDTO> getArrSearch(String search) {
        ArrayList<RoleDTO> arr = new ArrayList<>();
        for (RoleDTO rdto : roleDAO.getselectAll()) {
            String id = Integer.toString(rdto.getRoleID());
            try {
                if (id.contains(search) || rdto.getRoleName().contains(search)
                        || rdto.getDescription().contains(search)){
                    arr.add(rdto);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
}
