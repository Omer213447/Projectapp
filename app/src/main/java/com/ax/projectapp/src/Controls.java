package com.ax.projectapp.src;

import java.util.regex.Pattern;

public class Controls {
    //This function will look if there is upper letter in the string, if there is output 1(True), if not output 0(false)
    public static boolean isAnyUpperLetterInIt(String looked){
        return Pattern.matches(".*[A-Z].*", looked);
    }
    //This function will look if there is special characters in the string, if there is output 1(True), if not output 0(false)
    public static boolean isAnyPunctuationInIt(String looked){
        return Pattern.matches(".*[!\"#$%&'()*+,-.\\/:;<=>?@\\[\\]^_`\\{|\\}~].*", looked);
    }
}
