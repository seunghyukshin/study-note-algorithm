import java.util.Arrays;

// FAIL
public class Solution_72_EditDistance {
	public static void main(String[] args) {
		Solution_72_EditDistance sol = new Solution_72_EditDistance();
		String word1 = "leetcode";
		String word2 = "etco";
//		String word1 = "horsos";
//		String word2 = "ros";
		int answer = sol.minDistance(word1, word2);
		System.out.println(answer);
	}

	public int minDistance(String word1, String word2) {
		int result = 0;
		int C = word1.length();
		int R = word2.length();
		int[][] dp = new int[R + 1][C + 1];

//		Arrays.fill(dp[0], 1);
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
					dp[i][j] = dp[i][j - 1] + 1;
				} else {
//					dp[i][j] = dp[i - 1][j - 1];
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		print(dp);
		int recycledCount = dp[R][C];
		result = Math.max(R - recycledCount, C - recycledCount);
		return result;
	}

	public void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
