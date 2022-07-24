package com.javaRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationRegex {
    public static void main(String[] args) {

// ------------------------------------------------------------------------------------------

        String strOne = "ac";
        String regexPattern = ".c";
        // . : It doesn't matter if anything is written before or after the phrase
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher m = pattern.matcher(strOne);
        boolean b = m.matches();
        System.out.println("The second expression must be c : " + b);

        System.out.println("The second expression must be c : " + Pattern.compile(".c").matcher("ac").matches());

        System.out.println("The second expression must be c : " + Pattern.matches(".c", "ac"));

// ------------------------------------------------------------------------------------------

        System.out.println("The first term should be only a number : " + Pattern.matches("\\d.", "2c"));

        System.out.println("We use this to print specific expressions : " + "\"");

        System.out.println("This expression must not contain any numbers : " + Pattern.matches("[^0-9].", "2c"));

        System.out.println("The whole phrase must be one number and must contain 7 numbers, but not more than 7 numbers : " + Pattern.matches("\\d{7}", "2678845"));

        System.out.println("It should be between 3 and 7 numbers : " + Pattern.matches("\\d{3,7}", "26845"));

        System.out.println("Only including letters and of course only lowercase letters and between 3 and 7 letters : " + Pattern.matches("[a-z]{3,7}", "acvAd"));

        System.out.println("Only include letters and of course only capital letters and between 3 and 7 letters : " + Pattern.matches("[A-Z]{3,7}", "acvAd"));

        System.out.println("Only contain letters and between 3 and 7 letters : " + Pattern.matches("[a-zA-Z]{3,7}", "acvAd"));

        System.out.println("Contains letters or numbers between 3 and 7 letters : " + Pattern.matches("[a-zA-Z_0-9]{3,7}", "acv8Ad"));

        System.out.println("The first and second terms should contain letters and the third term should only be numbers : " + Pattern.matches("[a-zA-Z]{1,2}[0-9]", "ac4"));

        System.out.println("The first and second terms should contain letters and the third term should only contain the number 3 : " + Pattern.matches("[a-zA-Z]{1,2}3", "ac3"));

    }
}
