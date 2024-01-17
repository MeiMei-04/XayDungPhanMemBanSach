/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hepler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author hieud
 */
public class EmailValidator {
    private static Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._]{5,20}@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    public EmailValidator() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}  
