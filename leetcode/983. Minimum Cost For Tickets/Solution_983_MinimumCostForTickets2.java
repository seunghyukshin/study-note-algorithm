import java.util.Arrays;

/*
 * cost[0] : 1-day
 * cost[1] : 7-day
 * cost[2] : 30-day
 * */

// 0 ms, faster than 100.00%
public class Solution_983_MinimumCostForTickets2 {
	int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Solution_983_MinimumCostForTickets2 sol = new Solution_983_MinimumCostForTickets2();
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		int res = sol.mincostTickets(days, costs);
		System.out.println(res);
	}

	public int mincostTickets(int[] days, int[] costs) {
		int lastDay = days[days.length - 1];
		int[] dp = new int[lastDay + 1];
		boolean[] isGo = new boolean[lastDay + 1];
		for (int i = 0; i < days.length; i++) {
			isGo[days[i]] = true;
		}

		for (int i = 1; i <= lastDay; i++) {
			if (isGo[i]) {
				int a = dp[i - 1] + costs[0];

				int b;
				if (i > 7) {
					b = dp[i - 7] + costs[1];
				} else {
					b = costs[1];
				}

				int c;
				if (i > 30) {
					c = dp[i - 30] + costs[2];
				} else {
					c = costs[2];
				}

				int min = Math.min(a, Math.min(b, c));
				dp[i] = min;
			} else {
				dp[i] = dp[i - 1];
			}
		}
//		for (int i = 0; i < dp.length; i++) {
//			System.out.print(dp[i] + " ");
//		}
//		System.out.println();

		return dp[lastDay];
	}

}
