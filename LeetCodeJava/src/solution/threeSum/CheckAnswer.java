package solution.threeSum;

public class CheckAnswer {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {
                {-1, 0, 1, 2, -1, -4},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {-1, -1, -1, -1, 0, 1, 1, 1, 1},
                {1, 1, 1}
        };
        for (int[] i : input) {
            System.out.println(s.threeSum(i));
        }

    }

}
