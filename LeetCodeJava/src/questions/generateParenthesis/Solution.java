/*
 * https://leetcode.com/problems/generate-parentheses/
 * 2020.09.27
 */
package questions.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ans;
    private int length;

    public List<String> generateParenthesis(int n) {
        this.ans = new ArrayList<String>();
        this.length = n * 2;
        addStringToAns("", 0, 0);
        return this.ans;
    }

    public void addStringToAns(String str, int left, int right) {
        // add str to this.ans
        if (left + right == this.length) this.ans.add(str);

        // the number of '(' & ')' are the same, must add '('
        else if (left == right) addStringToAns(str + "(", left + 1, right);

        // the number of '(' is enough, fill the rest ')'
        else if (left == this.length / 2){
            StringBuilder closingBracket = new StringBuilder();
            while (right < left) {
                closingBracket.append(")");
                right++;
            }
            addStringToAns(str + closingBracket, left, right);

        // add '(' or ')'
        } else {
            addStringToAns(str + "(", left + 1, right);
            addStringToAns(str + ")", left, right + 1);
        }
    }
}
