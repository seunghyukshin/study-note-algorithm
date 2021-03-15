import java.util.Arrays;

public class Solution_322_CoinChange_답 {
	int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Solution_322_CoinChange_답 sol = new Solution_322_CoinChange_답();
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int res = sol.coinChange(coins, amount);
		System.out.println(res);
	}

	public int coinChange(int[] coins, int amount) {
		int max = amount + 1;
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, max);
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
