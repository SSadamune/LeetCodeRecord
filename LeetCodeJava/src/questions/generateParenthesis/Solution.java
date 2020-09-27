/**
 * https://leetcode.com/problems/generate-parentheses/
 * 2020.09.27
 */
package questions.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ans;
    private int length;

    // my answer
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

    // reference answer: dfs
    public List<String> generateParenthesisDfs(int n) {
        List<String> res = new ArrayList<>();
        // special case
        if (n == 0) return res;

        // dfs, find possible results
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr a string as current result
     * @param left   how many open brackets left for use
     * @param right  how many close brackets left for use
     * @param res    result set
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // no brackets for use, add curStr
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        // Pruning: used ')' more than '('
        if (left > right) {
            return;
        }

        // use a new '('
        if (left > 0) {
            dfs(curStr + "(", left - 1, right, res);
        }

        // use a new ')'
        if (right > 0) {
            dfs(curStr + ")", left, right - 1, res);
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }
}
