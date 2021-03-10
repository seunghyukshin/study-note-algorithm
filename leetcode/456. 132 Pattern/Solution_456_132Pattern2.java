import java.util.Arrays;

// for문 2개로 
// 322ms 5.04%
public class Solution_456_132Pattern2 {
	public static void main(String[] args) {
		Solution_456_132Pattern2 sol = new Solution_456_132Pattern2();
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
		for (int i = 1; i < nums.length - 1; i++) {
			int midValue = nums[i];
			int[] lefts = new int[i];
			int[] rights = new int[nums.length - 1 - i];
			System.arraycopy(nums, 0, lefts, 0, i);
			System.arraycopy(nums, i + 1, rights, 0, nums.length - 1 - i);
//
//			Arrays.sort(lefts);
//			Arrays.sort(rights);

			for (int j = 0; j < lefts.length; j++) {
				System.out.print(lefts[j]);
			}
			System.out.print(" / ");
			System.out.print(midValue);
			System.out.print(" / ");
			for (int j = 0; j < rights.length; j++) {
				System.out.print(rights[j]);
			}
			System.out.println();

			int rightMaxValue = Integer.MIN_VALUE;
			for (int j = 0; j < rights.length; j++) {
				if (midValue > rights[j] && rightMaxValue < rights[j]) {
					rightMaxValue = rights[j];
				}
			}
			if (rightMaxValue == Integer.MAX_VALUE)
				continue;

			for (int j = 0; j < lefts.length; j++) {
				if (lefts[j] < rightMaxValue) {
					return true;
				}
			}

		}
		return res;
	}
}
