import java.util.Arrays;

public class Solution_72_EditDistance_2 {
	public static void main(String[] args) {
		Solution_72_EditDistance_2 sol = new Solution_72_EditDistance_2();
		String word1 = "intention";
		String word2 = "execution";
//		String word1 = "horse";
//		String word2 = "ros";
		int answer = sol.minDistance(word1, word2);
		System.out.println(answer);
	}

	public int minDistance(String word1, String word2) {
		int C = word1.length();
		int R = word2.length();
		int[][] dp = new int[R + 1][C + 1];

		// init
		dp[0][0] = 0;
		for (int i = 1; i < R + 1; i++) {
			dp[i][0] = i;
		}

		for (int j = 1; j < C + 1; j++) {
			dp[0][j] = j;
		}

//		print(dp);
		for (int i = 1; i < R + 1; i++) {
			for (int j = 1; j < C + 1; j++) {
				if (word1.charAt(j - 1) == word2.charAt(i - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int insertedNum = dp[i][j - 1] + 1;
					int deletedNum = dp[i - 1][j] + 1;
					int replacedNum = dp[i - 1][j - 1] + 1;
					dp[i][j] = Math.min(insertedNum, Math.min(deletedNum, replacedNum));
				}
			}
		}
//		print(dp);
		return dp[R][C];
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
