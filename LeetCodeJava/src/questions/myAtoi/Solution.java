package questions.myAtoi;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 2020.09.22 19:25 ~ 21:15
 */

public class Solution {

    public int myAtoi(String str) {
        if (!str.matches("^\\s*[\\+\\-]?\\d+.*")) return 0;
        Pattern pattern = Pattern.compile("[\\+\\-]?\\d+");
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find())  return 0;
        String strNumber = matcher.group(0);

        // remove 0
        Matcher mZero = Pattern.compile("^[\\+\\-]?0*").matcher(strNumber);
        String head = strNumber.charAt(0)== '+' || strNumber.charAt(0)== '-' ?
                strNumber.substring(0,1) + "0" : "0";
        strNumber = mZero.replaceAll(head);

        if (strNumber.length() >= 13) strNumber = strNumber.substring(0, 13);
        if (Long.parseLong(strNumber) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (Long.parseLong(strNumber) < -Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return Integer.valueOf(strNumber).intValue();
    }

    // reference answer 1: try-catch
    public int myAtoiRegex1(String str) {
        // remove space
        str = str.trim();

        Pattern p = Pattern.compile("^[\\+\\-]?\\d+");
        Matcher m = p.matcher(str);
        int value = 0;

        if (m.find()){
            try {
                value = Integer.parseInt(str.substring(m.start(), m.end()));
            } catch (Exception e){
                value = str.charAt(0) == '-' ? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return value;
    }

    // reference answer 2: Biginteger
    public int myAtoiRegex2(String str) {
        String pattern = "^\\s*([+-]?\\d+)";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(str);
        if (!m.find( ))  return 0;

        BigInteger ans = new BigInteger(m.group(1));
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0){
            return Integer.MIN_VALUE;
        }
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0){
            return Integer.MAX_VALUE;
        }
        return ans.intValue();

    }

    // reference answer 3: Automaton
    public int myAtoiAutomaton(String str) {
        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}

