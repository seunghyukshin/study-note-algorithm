// for문 2개로 
public class Solution_456_132Pattern {
	public static void main(String[] args) {
		Solution_456_132Pattern sol = new Solution_456_132Pattern();
//		int[] nums = { 1, 2, 3, 4 };
//		int[] nums = { 3, 1, 4, 2 };
//		int[] nums = { -1, 3, 2, 0 };
//		int[] nums = { 3, 5, 0, 3, 4 };
//		int[] nums = { 1, 3, 2, 4, 5, 6, 7, 8, 9, 10 };
		int[] nums = { 1, 2, 3, 2, 4, 5, 6, 7, 8, 9, 10 };
		boolean res = sol.find132pattern(nums);
		System.out.println(res);
	}

	public boolean find132pattern(int[] nums) {
		boolean res = false;
		for (int i = 0; i < nums.length - 2; i++) {
			int l = i + 1;
			int r = nums.length - 1;
			int rValue = nums[nums.length - 1];  
			while (l != r) {
				System.out.println(i + " " + l + " " + r);
				if (nums[i] < nums[r]) {
					if (nums[l] > nums[r]) {
						return true;
					} else {
						r--;
					}
//					r--;
				} else {
					r--;
				}
			}

		}
		return res;
	}
}
