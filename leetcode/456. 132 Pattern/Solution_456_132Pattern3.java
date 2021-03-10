import java.util.Arrays;
// 57 ms, faster than 24.09%
public class Solution_456_132Pattern3 {
	public static void main(String[] args) {
		Solution_456_132Pattern3 sol = new Solution_456_132Pattern3();
//		int[] nums = { 1, 2, 3, 4 };
//		int[] nums = { 3, 1, 4, 2 };
//		int[] nums = { -1, 3, 2, 0 };
		int[] nums = { 3, 5, 0, 3, 4 };
//		int[] nums = { 1, 3, 2, 4, 5, 6, 7, 8, 9, 10 };
//		int[] nums = { 1, 2, 3, 2, 4, 5, 6, 7, 8, 9, 10 };
		boolean res = sol.find132pattern(nums);
		System.out.println(res);
	}

	public boolean find132pattern(int[] nums) {
		boolean res = false;
		if (nums.length < 3) {
			return false;
		}

		int[] dp = new int[nums.length];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			min = Math.min(min, nums[i]);
			dp[i] = min;
		}

		for (int i = 1; i < nums.length - 1; i++) {
			int midValue = nums[i];

			if (dp[i - 1] >= midValue) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (dp[i - 1] < nums[j] && nums[j] < midValue) {
					return true;
				}
			}
		}
		return res;
	}
}
