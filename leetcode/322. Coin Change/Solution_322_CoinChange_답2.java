import java.util.Arrays;

public class Solution_322_CoinChange_답2 {
	int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Solution_322_CoinChange_답2 sol = new Solution_322_CoinChange_답2();
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int res = sol.coinChange(coins, amount);
		System.out.println(res);
	}

	public int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		return dfs(coins, amount, new int[amount]);
	}

	private int dfs(int[] coins, int rem, int[] count) {
		if (rem < 0)
			return -1;
		if (rem == 0)
			return 0;
		if (count[rem - 1] != 0)
			return count[rem - 1];
		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = dfs(coins, rem - coin, count);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[rem - 1];
	}
}
