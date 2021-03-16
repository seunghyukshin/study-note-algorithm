import java.util.Arrays;

/*
 * cost[0] : 1-day
 * cost[1] : 7-day
 * cost[2] : 30-day
 * */

// dp 2 ms, faster than 37.66%
public class Solution_983_MinimumCostForTickets {
	public static void main(String[] args) {
		Solution_983_MinimumCostForTickets sol = new Solution_983_MinimumCostForTickets();
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };

		int res = sol.mincostTickets(days, costs);
		System.out.println(res);
	}

	public int mincostTickets(int[] days, int[] costs) {
		// init
		int lastDay = days[days.length - 1];
		boolean[] isGo = new boolean[lastDay + 1];
		int[] dp = new int[lastDay + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		for (int i = 0; i < days.length; i++) {
			isGo[days[i]] = true;
		}

		// start
		dp[0] = 0;
		for (int i = 1; i <= lastDay; i++) {
			if (isGo[i]) {
				for (int j = 0; j < 30 && i + j <= lastDay; j++) {
					dp[i + j] = Math.min(dp[i + j], dp[i - 1] + costs[2]);
				}
				for (int j = 0; j < 7 && i + j <= lastDay; j++) {
					dp[i + j] = Math.min(dp[i + j], dp[i - 1] + costs[1]);
				}
				dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]);
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
