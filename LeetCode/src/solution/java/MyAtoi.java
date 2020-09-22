package solution.java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 2020.09.22 19:25 ~ 21:15
 */

public class MyAtoi {

    public int myAtoi(String str) {
        int i = 0;
        if (str.matches("\\s*[\\+\\-]?\\d+.*")) {
            Pattern pattern = Pattern.compile("[\\+\\-]?\\d+");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                String strNumber = matcher.group(0);

                // remove 0
                Matcher mZero = Pattern.compile("^[\\+\\-]?0*").matcher(strNumber);
                String head = strNumber.charAt(0)== '+' || strNumber.charAt(0)== '-' ?
                        strNumber.substring(0,1) + "0" : "0";
                strNumber = mZero.replaceAll(head);

                if (strNumber.length() >= 13) strNumber = strNumber.substring(0, 13);
                if (Long.parseLong(strNumber) > Integer.MAX_VALUE) {
                    i = Integer.MAX_VALUE;
                } else if (Long.parseLong(strNumber) < -Integer.MIN_VALUE){
                    i = Integer.MIN_VALUE;
                } else {
                    i = Integer.parseInt(strNumber);
                }
            }
        }
        return i;
    }

}


