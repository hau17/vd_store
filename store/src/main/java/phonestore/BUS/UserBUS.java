package phonestore.BUS;

import java.util.ArrayList;

import phonestore.DAO.UserDAO;
import phonestore.DTO.UserDTO;

public class UserBUS {
    public ArrayList<UserDTO> arr_UserDTOs = new ArrayList<>();
    public UserDAO userDAO = new UserDAO();
    private String userName;

    public UserBUS() {
        this.arr_UserDTOs = userDAO.getselectAll();
    }

    public ArrayList<UserDTO> getAllUser() {
        return arr_UserDTOs = userDAO.getselectAll();
    }

    public boolean add_User(UserDTO UserDTO) {
        boolean check = false;
        try {
            check = userDAO.insert(UserDTO) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean update_user(UserDTO userDTO) {
        boolean check = false;
        try {
            check = userDAO.update(userDTO) != 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public boolean delete_user(int id) {
        boolean check = false;
        try {
            check = userDAO.delete(userDAO.selectById(id)) != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<UserDTO> arr_search_user(String object) {
        ArrayList<UserDTO> arr = new ArrayList<>();
        for (UserDTO userDTO : arr_UserDTOs) {
            String id = Integer.toString(userDTO.getuser_id());
            try {
                if (id.equals(object) || userDTO.getuser_name().contains(object)
                        || userDTO.getemail_address().contains(object)
                        || userDTO.getphone_number().contains(object)
                        || userDTO.getdate_of_birth().contains(object)
                        || userDTO.getfull_name().contains(object)
                        || Integer.toString(userDTO.getrole_id()).contains(object)
                        || Integer.toString(userDTO.getPassword()).contains(object)
                        || Integer.toString(userDTO.getStatus()).contains(object)) {
                    arr.add(userDTO);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
    public String getUserNameByID(int id){
        UserDTO userDTO=userDAO.selectById(id);
        return userDTO.getfull_name();
    }

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
}
