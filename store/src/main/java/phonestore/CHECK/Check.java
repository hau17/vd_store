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
        try {
            Integer.parseInt(check);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static boolean checkPhoneNumber(String check){
        Pattern pattern=Pattern.compile("^[0-9]{9,12}$");
        Matcher matcher=pattern.matcher(check);
        return matcher.matches();
    }
    public static boolean checkPositiveNumber(String check){
        int number= Integer.parseInt(check);
        if (number>0) {
            return true;
        }
            return false;
        }
    public static boolean checkEmpty(String check){
        if (check.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
