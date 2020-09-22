package solution.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public int myAtoi(String str) {
        int i = 0;
        if (str.matches("\\s*[\\+\\-]?\\d+.*")) {
            System.out.println("check1");
            Pattern pattern = Pattern.compile("[\\+\\-]?\\d+");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String number = matcher.group(0);
                if (number.length() >= 12) number = number.substring(0, 12);
                System.out.println(number);
                if (Long.parseLong(number) > 2147483647) {
                    i = 2147483647;
                } else if (Long.parseLong(number) < -2147483648){
                    i = -2147483648;
                } else {
                    i = Integer.parseInt(number);
                }
            }
            System.out.println("check2");
        }
        return i;
    }

}

/*
 * 2020.09.22 19:25~20:38
 */
