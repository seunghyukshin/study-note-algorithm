import java.io.*;
import java.util.Arrays;

// memoization으로.
public class Solution_D4_9282_초콜릿과건포도_풀이2 {
	static int result;
	static int N, M;
	static int[][] map;
	static int[][][][] dp; // y,x,h,w
	// 기억하기위한 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new int[N][M];
			dp = new int[N + 1][M + 1][N + 1][M + 1];

			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}

			for (int n = 0; n < N; n++) {
				String[] ss = br.readLine().split(" ");
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(ss[m]);
				}
			}
			result = dfs(0, 0, N, M);
			System.out.println("#" + t + " " + result);
		}
	}

	private static int dfs(int y, int x, int h, int w) {
		// 종료
		if (w == 1 && h == 1) {
			return 0;
		}
		// memoization은 종료조건 하나 더쓴다. 구해놓은 값있으면 그거 쓰겟다.
		if (dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}

		// 실행
		// 기존에 있던 덩어리의 건포도 개수
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		// 가로로 나눠서 최 소 비 용을 구한다.
		for (int i = 1; i < h; i++) {
			// 위쪽비용
			if (dp[y][x][i][w] == Integer.MAX_VALUE) {
				dp[y][x][i][w] = dfs(y, x, i, w);
			}
			// 아래쪽비용
			if (dp[y + i][x][h - i][w] == Integer.MAX_VALUE) {
				dp[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
			}
			int sum3 = sum + dp[y][x][i][w] + dp[y + i][x][h - i][w];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		// 세로로 나눠서 최 소 비 용을 구한다.
		for (int i = 1; i < w; i++) {
			// 위쪽비용
			if (dp[y][x][h][i] == Integer.MAX_VALUE) {
				dp[y][x][h][i] = dfs(y, x, h, i);
			}
			// 아래쪽비용
			if (dp[y][x + i][h][w - i] == Integer.MAX_VALUE) {
				dp[y][x + i][h][w - i] = dfs(y, x + i, h, w - i);
			}
			int sum3 = sum + dp[y][x][h][i] + dp[y][x + i][h][w - i];
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}
		// 재귀 호출
		return dp[y][x][h][w];
	}
}
