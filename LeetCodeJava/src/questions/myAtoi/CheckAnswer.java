package questions.myAtoi;

public class CheckAnswer {

	public static void main(String[] args) {
	    Solution s = new Solution();
		String[] inputMyAtoi = {
		        "   +100 ",
		        "-2312312312",
		        "123123123123aabb",
		        "  -0000000123456789",
		        "    0000000000000   ",
		        "    +0a32"
		        };
		for (String input : inputMyAtoi) {
			System.out.println(s.myAtoi(input));
		}

	}

}
