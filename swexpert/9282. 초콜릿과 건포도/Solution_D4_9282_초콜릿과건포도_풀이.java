import java.io.*;

// dfs로 풀면 시간초과다~
public class Solution_D4_9282_초콜릿과건포도_풀이 {
	static int result;
	static int N, M;
	static int[][] map;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new int[N][M];
			min = Integer.MAX_VALUE;
			for (int n = 0; n < N; n++) {
				String[] ss = br.readLine().split(" ");
				for (int m = 0; m < M; m++) {
					map[n][m] = Integer.parseInt(ss[m]);
				}
			}
//			print(map);

			// (시작 y,x) (y,x 길이)
			result = dfs(0, 0, N, M, Integer.MAX_VALUE);
			System.out.println("#" + t + " " + result);
		}
	}

	private static int dfs(int y, int x, int h, int w, int min) {
		// 종료
		if (w == 1 && h == 1) {
			return 0;
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
			int sum1 = dfs(y, x, i, w, min);
			// 아래쪽비용
			int sum2 = dfs(y + i, x, h - i, w, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		// 세로로 나눠서 최 소 비 용을 구한다.
		for (int i = 1; i < w; i++) {
			// 위쪽비용
			int sum1 = dfs(y, x, h, i, min);
			// 아래쪽비용
			int sum2 = dfs(y, x + i, h, w - i, min);
			int sum3 = sum + sum1 + sum2;
			min = Math.min(min, sum3);
		}
		// 재귀 호출
		return min;
	}
}
