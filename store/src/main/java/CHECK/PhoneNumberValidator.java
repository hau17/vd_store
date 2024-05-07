/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CHECK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author congh
 */
public class PhoneNumberValidator {
    public static boolean isValidPhoneNumber(String phoneNumber) {
         if (phoneNumber.length() < 10 || phoneNumber.length() > 11) {
            return false;
        }
        String regex = "^[0-9]+$"; 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        
        return matcher.matches();
    }
}
