import java.util.*;

class Solution_15_3Sum4 {
	public static void main(String[] args) {
		Solution_15_3Sum4 sol = new Solution_15_3Sum4();
		sol.threeSum(new int[] { -2, 0, 1, 1, 2 });
//		sol.threeSum(new int[] { -10, -2, 1, 2, 5, 5, 8 });
		System.out.println("finish");
	}

	List<List<Integer>> list = new ArrayList<>();
	HashSet<List<Integer>> hs = new HashSet<>();

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 0 || nums.length == 1)
			return list;
		int p = 0;
		while (true) {
			int l = p + 1;
			int r = nums.length - 1;
			if (l == r)
				break;
			int sum = 0;
			while (l != r) {
				sum = nums[l] + nums[r] + nums[p];
//				System.out.println(p + " " + l + " " + r);
				if (sum < 0)
					l++;
				else if (sum > 0)
					r--;
				else {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[p]);
					temp.add(nums[l]);
					temp.add(nums[r]);
					hs.add(temp);
					l++;
				}
			}
			p++;
		}
//		System.out.println(hs);
		return new ArrayList<>(hs);
	}
}