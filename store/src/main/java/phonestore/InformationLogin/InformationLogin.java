/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.InformationLogin;


/**
 *
 * @author congh
 */
public class InformationLogin {
    private static InformationLogin instance;
    private String userName ;
    public static synchronized InformationLogin getInstance(){
        if(instance==null){
            instance=new InformationLogin();
        }
        return instance;
    }
    public void setUsername(String name){
        this.userName=name;
    }
    public String getUserName(){
        return userName;
    }
}