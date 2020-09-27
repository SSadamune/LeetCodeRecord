package questions.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<String> ans;
    private int length;

    public List<String> generateParenthesis(int n) {
        this.ans.clear();
        this.length = n * 2;
        this.ans = new ArrayList<String>();

        addStringToAns("", 0, 0, 0);

        return this.ans;
    }

    public void addStringToAns(String str, int index, int left, int right) {
        if (index == length) this.ans.add(str);

    }
}
