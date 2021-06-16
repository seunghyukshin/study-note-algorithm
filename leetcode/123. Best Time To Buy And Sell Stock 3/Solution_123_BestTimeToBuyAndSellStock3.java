import java.util.ArrayList;
import java.util.List;

// FAIL ; DFS ; 시간초과
public class Solution_123_BestTimeToBuyAndSellStock3 {
	public static void main(String[] args) {
		Solution_123_BestTimeToBuyAndSellStock3 sol = new Solution_123_BestTimeToBuyAndSellStock3();
//		int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
//		int[] prices = { 1, 2, 3, 4, 5 };
//		int[] prices = { 7, 6, 4, 3, 1 };
		int[] prices = { 1 };
//		int[] prices = { 3, 2, 6, 5, 0, 3 };
		int answer = sol.maxProfit(prices);
		System.out.println(answer);
	}

	int maxSum = 0;
	boolean[] visited;

	public int maxProfit(int[] prices) {
		visited = new boolean[prices.length];
		for (int i = 0; i < prices.length; i++) {
//			System.out.println();
//			System.out.println("시작~~~~ " + i + " 부터~");
//			System.out.println();
			dfs(i, 0, prices, 0);
		}
		return maxSum;
	}

	private void dfs(int buyTime, int buyCount, int[] prices, int sum) {
//		System.out.println("이때매수 !!" + buyTime);
//		System.out.println(sum + "만큼 이득 " + buyCount);

		maxSum = Math.max(maxSum, sum);
		if (buyCount == 2 || buyTime == prices.length - 1) {
			return;
		}

		for (int i = buyTime + 1; i < prices.length; i++) {
			if (prices[buyTime] < prices[i]) {
//				System.out.println("ㅋㅋ 추가매수 ㅋㅋ");
				for (int j = i; j < prices.length; j++) {
					dfs(j, buyCount + 1, prices, sum + prices[i] - prices[buyTime]);
				}
			}
		}
		return;
	}
}
