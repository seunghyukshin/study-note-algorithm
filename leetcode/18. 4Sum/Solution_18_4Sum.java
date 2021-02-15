import java.util.*;

public class Solution_18_4Sum {
	public static void main(String[] args) {
		Solution_18_4Sum sol = new Solution_18_4Sum();
		sol.fourSum(new int[] { 0, 1, -1, -2, 0, 2 }, 0);
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		HashSet<List<Integer>> hs = new HashSet<>();
		Arrays.sort(nums);
		for (int p1 = 0; p1 < nums.length - 3; p1++) {
			for (int p2 = p1 + 1; p2 < nums.length - 2; p2++) {
				int l = p2 + 1;
				int r = nums.length - 1;

				while (true) {
//					System.out.println(p1 + " " + p2 + " " + l + " " + r + " ");
					if (l == r)
						break;
					int sum = nums[p1] + nums[p2] + nums[l] + nums[r];
					if (sum > target)
						r--;
					else if (sum < target)
						l++;
					else {
						List<Integer> list = new ArrayList<>();
						list.add(nums[p1]);
						list.add(nums[p2]);
						list.add(nums[l]);
						list.add(nums[r]);
						hs.add(list);
						l++;
					}
				}

			}
		}
		return new ArrayList<List<Integer>>(hs);
	}
}
