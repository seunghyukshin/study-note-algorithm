
public class Solution_32_LongestValidParentheses {
	public static void main(String[] args) {
		Solution_32_LongestValidParentheses sol = new Solution_32_LongestValidParentheses();
//		int res = sol.longestValidParentheses("()()()(");
//		int res = sol.longestValidParentheses("()(()");
//		int res = sol.longestValidParentheses("()(())");
		int res = sol.longestValidParentheses("(()");
		System.out.println(res);
	}

	public int longestValidParentheses(String s) {
		int result = Integer.MIN_VALUE;
		int[] dp = new int[s.length()];
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftCount++;
			} else if (s.charAt(i) == ')') {
				if (leftCount > 0) {
					dp[i] = dp[i - 1] + 2;
					int preIndex = i - dp[i];
					if (preIndex >= 0 && dp[preIndex] != 0) {
						dp[i] += dp[preIndex];
					}
					result = Math.max(dp[i], result);
					leftCount--;
				}
			}
		}
		return result == Integer.MIN_VALUE ? 0 : result;
	}
}
