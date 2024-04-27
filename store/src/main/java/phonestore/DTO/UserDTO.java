package phonestore.DTO;

public class UserDTO {
    private int user_id;
    private String user_name;
    private int password;
    private String full_name;
    private String date_of_birth;
    private String phone_number;
    private String email_address;
    private int role_id;
    private int status;

    public UserDTO() {
    }

    public UserDTO(int user_id, String user_name, int password, String full_name, String date_of_birth,
            String phone_number, String email_address, int role_id, int status) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.full_name = full_name;
        this.date_of_birth = date_of_birth;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.role_id = role_id;
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDTO [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", full_name="
                + full_name + ", date_of_birth=" + date_of_birth + ", phone_number=" + phone_number + ", email_address="
                + email_address + ", role_id=" + role_id + ", status=" + status + "]";
    }

    public int getuser_id() {
        return user_id;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getuser_name() {
        return user_name;
    }

    public void setuser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getfull_name() {
        return full_name;
    }

    public void setfull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getdate_of_birth() {
        return date_of_birth;
    }

    public void setdate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getphone_number() {
        return phone_number;
    }

    public void setphone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getemail_address() {
        return email_address;
    }

    public void setemail_address(String email_address) {
        this.email_address = email_address;
    }

    public int getrole_id() {
        return role_id;
    }

    public void setrole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}