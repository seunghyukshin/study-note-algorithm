import java.io.*;

public class Solution_2814_최장경로 {
	static int N, M;
	static boolean[] visited;
	static int[][] map;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			visited = new boolean[N];
			map = new int[N][N];
			max = Integer.MIN_VALUE;

			for (int m = 0; m < M; m++) {
				String[] ss = br.readLine().split(" ");
				int x = Integer.parseInt(ss[0]);
				int y = Integer.parseInt(ss[1]);
				map[x - 1][y - 1] = 1;
				map[y - 1][x - 1] = 1;
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
//				System.out.println("===start===" + i);
				visited[i] = true;
				dfs(i, 1);
				visited[i] = false;
			}
			System.out.println(max);
		}
	}

	// i:정점번호
	private static void dfs(int i, int count) {
//		System.out.println("i" + i + " count" + count);
		max = Math.max(max, count);

		for (int j = 0; j < N; j++) {
			if (map[i][j] == 1 && !visited[j]) {
				visited[j] = true;
				dfs(j, count + 1);
				visited[j] = false;
			}
		}
	}
}
