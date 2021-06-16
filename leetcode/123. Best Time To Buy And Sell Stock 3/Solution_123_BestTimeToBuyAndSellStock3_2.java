import java.util.*;

public class Solution_123_BestTimeToBuyAndSellStock3_2 {
	public static void main(String[] args) {
		Solution_123_BestTimeToBuyAndSellStock3_2 sol = new Solution_123_BestTimeToBuyAndSellStock3_2();
//		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int[] prices = { 1, 2, 3, 4, 5 };
//		int[] prices = { 7, 6, 4, 3, 1 };
//		int[] prices = { 1 };
//		int[] prices = { 3, 2, 6, 5, 0, 3 };
//		int[] prices = { 3, 5, 0, 3, 1, 4 };
		int answer = sol.maxProfit(prices);
		System.out.println(answer);
	}

	public int maxProfit(int[] prices) {
		int N = prices.length;
		int[] lefts = new int[N];
		int[] rights = new int[N];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		// make array
		for (int i = 0; i < N; i++) {
			min = Math.min(min, prices[i]);
			if (i != 0)
				lefts[i] = Math.max(lefts[i - 1], prices[i] - min);
		}
		for (int i = N - 1; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			if (i != N - 1)
				rights[i] = Math.max(rights[i + 1], max - prices[i]);
		}
//		print(lefts);
//		print(rights);

		int maxSum = 0;
		for (int i = 0; i < N; i++) {
			int sum = lefts[i] + rights[i];
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
