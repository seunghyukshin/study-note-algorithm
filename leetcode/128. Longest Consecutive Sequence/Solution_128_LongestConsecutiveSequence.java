import java.util.Arrays;

public class Solution_128_LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {

		Arrays.sort(nums);
		int max = Integer.MIN_VALUE;
		int prev = Integer.MIN_VALUE;
		int count = 1;
		for (int i = 0; i < nums.length; i++) {
			// System.out.print(prev +" "+nums[i] +" "+count);
			// System.out.println();
			if (prev + 1 == nums[i]) {
				count++;
			} else if (prev == nums[i]) {
				continue;
			} else {
				count = 1;
			}
			max = Math.max(max, count);
			prev = nums[i];
		}
		max = max < 0 ? 0 : max;
		return max;
	}
}
