package solution.java;

public class CheckAnswer {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] inputMyAtoi = {"   +100 ", "-2312312312", "123123123123aabb"};
		for (String input : inputMyAtoi) {
			System.out.println(s.myAtoi(input));
		}

	}

}
