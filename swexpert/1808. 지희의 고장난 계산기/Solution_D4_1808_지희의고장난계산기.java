import java.io.*;
import java.util.*;

// fail - 100개중 1개 pass. 주어진 테케만 다맞음

public class Solution_D4_1808_지희의고장난계산기 {
	public static List<Integer> button;
	public static int X;
	public static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			button = new ArrayList<>();
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) {
				if (s[i].equals("1")) {
					button.add(i);
				}
			}
			X = Integer.parseInt(br.readLine());
			dp = new int[1000000];
			Arrays.fill(dp, Integer.MAX_VALUE);

			int result = dfs(X);

			if (X == 1 && isOnButton(1))
				result = 1;

			if (result == Integer.MAX_VALUE)
				result = -2;

			System.out.print("#" + t + " ");
			System.out.println(result + 1);
		}

	}

	private static int dfs(int x) {
		// 소수냐 ?
		if (isPrime(x)) {
			// 버튼 안고장났냐?
			if (isOnButton(x)) {
				dp[x] = Math.min(dp[x], String.valueOf(x).length());
				return dp[x];
			} else {
				return Integer.MAX_VALUE;
			}
		}

		if (dp[x] != Integer.MAX_VALUE) {
			return dp[x];
		}

		for (int i = 2; i < x / 2; i++) {
			int j = (int) (x / i);
			if (i * j == x) {
				if (dp[i] == Integer.MAX_VALUE) {
					dp[i] = dfs(i);
				}

				if (dp[j] == Integer.MAX_VALUE) {
					dp[j] = dfs(j);
				}

				int sum = dp[i] + dp[j] + 1;
				if (dp[i] == Integer.MAX_VALUE || dp[j] == Integer.MAX_VALUE) {
					if (isOnButton(x))
						dp[x] = Math.min(dp[x], String.valueOf(x).length());
					else
						dp[x] = Math.min(dp[x], Integer.MAX_VALUE);
				} else {
					dp[x] = Math.min(dp[x], sum);
				}
//				System.out.println("x" + x + " i" + i + " sum1)" + dp[i] + " sum2)" + dp[(int) (x / i)] + " sum)" + sum
//						+ " dp[" + x + "]" + dp[x]);
			}
		}

		return dp[x];
	}

	private static boolean isOnButton(int x) {
		String s = String.valueOf(x);

		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - '0';
			if (!button.contains(c))
				return false;
		}
		return true;
	}

	private static boolean isPrime(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
