
public class Solution_42_TrappingRainWater {
	public static void main(String[] args) {
		Solution_42_TrappingRainWater sol = new Solution_42_TrappingRainWater();
//		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
//		int[] height = { 4, 2, 0, 3, 2, 5 };
		int[] height = { 4 };
		int res = sol.trap(height);
		System.out.println(res);
	}

	public int trap(int[] height) {
		if (height.length == 0)
			return 0;

		int result = 0;

		int[] lefts = new int[height.length];
		int left = height[0];
		for (int i = 1; i < height.length; i++) {
			if (height[i] > left) {
				left = height[i];
			} else {
				lefts[i] = left - height[i];
			}
		}
		int right = height[height.length - 1];
		for (int i = height.length - 2; i >= 0; i--) {
			if (height[i] > right) {
				right = height[i];
			} else {
				result += Math.min(lefts[i], right - height[i]);
			}
		}

		return result;
	}
}
