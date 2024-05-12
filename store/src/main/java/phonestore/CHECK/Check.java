/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonestore.CHECK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author congh
 */
public class Check {
    public static boolean checkInteger(String check){
        Pattern pattern=Pattern.compile("^[0-9]$");
        Matcher matcher=pattern.matcher(check);
        return matcher.matches();
    }
    public static boolean checkPhoneNumber(String check){
        Pattern pattern=Pattern.compile("^[0-9]{9,12}$");
        Matcher matcher=pattern.matcher(check);
        return matcher.matches();
    }
//    public static boolean checEmail(String check){
//        
//    }
}
