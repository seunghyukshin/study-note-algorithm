import java.util.Arrays;

public class Solution_45_JumpGame2 {
	public static void main(String[] args) {
		Solution_45_JumpGame2 sol = new Solution_45_JumpGame2();
		int[] nums = { 0 };
//		int[] nums = { 2, 3, 1, 1, 4 };
		int res = sol.jump(nums);
		System.out.println(res);
	}

	public int jump(int[] nums) {
		int[] dp = new int[nums.length];

		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j <= nums[i]; j++) {
				if (i + j < nums.length) {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}

		return dp[dp.length - 1];
	}
}
