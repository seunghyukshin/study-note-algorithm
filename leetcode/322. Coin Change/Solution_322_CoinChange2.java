import java.util.Arrays;

public class Solution_322_CoinChange2 {
	int min = Integer.MAX_VALUE;
	int[] dp;

	public static void main(String[] args) {
		Solution_322_CoinChange2 sol = new Solution_322_CoinChange2();
//		int[] coins = { 1, 2, 5 };
		int[] coins = { 5 };
		int amount = 11;
		int res = sol.coinChange(coins, amount);
		System.out.println(res);
	}

	public int coinChange(int[] coins, int amount) {
		dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);

		dp[0] = 0;

		for (int i = 1; i <= amount; i++) {
			int min = amount + 1;
			for (int j = 0; j < coins.length; j++) {
				if (i - coins[j] >= 0) {
					min = Math.min(min, dp[i - coins[j]] + 1);
					dp[i] = min;
				}
			}
		}
//		for (int d : dp) {
//			System.out.print(d + " ");
//		}
//		System.out.println();
		return dp[amount] == amount + 1 ? -1 : dp[amount];
	}

}
