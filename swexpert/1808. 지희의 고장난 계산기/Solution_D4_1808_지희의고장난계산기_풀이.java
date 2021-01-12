import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution_D4_1808_지희의고장난계산기_풀이 {

	static int X;
	static int[] buttons = new int[10];
	static int dp[];
	static final int IMPOSSIBLE = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < s.length; i++) {
				buttons[i] = Integer.parseInt(s[i]);
			}
			X = Integer.parseInt(br.readLine());
			dp = new int[X + 10];

			for (int i = 0; i < 10; i++) {
				if (buttons[i] == 1) {
					dp[i] = 1;
				}
			}

			dfs(X);
			System.out.printf("#%d %d\n", t, dp[X] == IMPOSSIBLE ? -1 : dp[X] + 1);
		}

	}

	static int dfs(int num) {
		if (dp[num] != 0)
			return dp[num];

		// num을 직접 눌러본다, 만약 고장난 숫자가 포함되어 있어 누르지 못한면 Integer.MAX_VALUE 를 return 한다.
		dp[num] = count(num);

		// 인수분해하여 num = a * b 의 형태로 변환
		for (int i = 1; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				int num1 = dfs(i);
				int num2 = dfs(num / i);
				// 직접 번호를 누른 숫자와, 인수분해한 a * b 를 각각 다시 탐색
				// *를 눌렀기 때문에 +1 해준다.
				dp[num] = Math.min(dp[num], num1 == IMPOSSIBLE || num2 == IMPOSSIBLE ? IMPOSSIBLE : num1 + num2 + 1);
			}
		}

		return dp[num];
	}

	static int count(int num) {
		int cnt = 0;

		while (num > 0) {
			int temp = num % 10;
			if (buttons[temp] == 0)
				return IMPOSSIBLE;

			num /= 10;
			cnt++;
		}
		return cnt;
	}
}