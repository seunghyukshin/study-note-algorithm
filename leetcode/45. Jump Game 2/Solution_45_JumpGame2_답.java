import java.util.Arrays;

public class Solution_45_JumpGame2_답 {
	public static void main(String[] args) {
		Solution_45_JumpGame2_답 sol = new Solution_45_JumpGame2_답();
//		int[] nums = { 0 };
		int[] nums = { 2, 3, 1, 1, 4 };
		int res = sol.jump(nums);
		System.out.println(res);
	}

	public int jump(int[] nums) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + nums[i]);
			System.out.println(i + " curFarthest " + curFarthest + " curEnd " + curEnd + " jumps " + jumps);

			if (i == curEnd) {
				System.out.println(i);
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}
}
