import java.util.ArrayList;
import java.util.List;

public class Solution_120_Triangle {

	public static void main(String[] args) {
		Solution_120_Triangle sol = new Solution_120_Triangle();
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		// triangle = [[2],[3,4],[6,5,7],[4,1,8,3]];
		List<Integer> list0 = new ArrayList<>();
		list0.add(2);
		list.add(list0);
		List<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(4);
		list.add(list1);
		List<Integer> list2 = new ArrayList<>();
		list2.add(6);
		list2.add(5);
		list2.add(7);
		list.add(list2);
		List<Integer> list3 = new ArrayList<>();
		list3.add(4);
		list3.add(1);
		list3.add(8);
		list3.add(3);
		list.add(list3);
		int res = sol.minimumTotal(list);
		System.out.println(res);
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int[][] nums = new int[triangle.size()][triangle.size()];
		int[][] dp = new int[triangle.size()][triangle.size()];

		for (int i = 0; i < triangle.size(); i++) {
			List<Integer> list = triangle.get(i);
			if (i == 0)
				dp[0][0] = list.get(0);
			for (int j = 0; j < list.size(); j++) {
				nums[i][j] = list.get(j);
			}
		}

		for (int i = 1; i < nums.length; i++) {
			List<Integer> list = triangle.get(i);
			for (int j = 0; j < list.size(); j++) {
				int a = Integer.MAX_VALUE;
				int b = Integer.MAX_VALUE;
//				System.out.println(i + " " + j);
				if (j != 0) {
					a = dp[i - 1][j - 1] + nums[i][j];
				}
				if (j != list.size() - 1) {
					b = dp[i - 1][j] + nums[i][j];
				}

				int min = Math.min(a, b);
				dp[i][j] = min;

//				System.out.print(dp[i][j] + " ");
			}
//			System.out.println();
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < dp.length; i++) {
			res = Math.min(res, dp[dp.length - 1][i]);
		}

//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp.length; j++) {
//				
//			}
//		}
		return res;
	}
}
