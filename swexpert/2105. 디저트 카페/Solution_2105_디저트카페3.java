import java.io.*;

public class Solution_2105_디저트카페3 {
	static int[][] map;
	static int[] dx = { 1, -1, -1, 1 };
	static int[] dy = { -1, -1, 1, 1 };
	static int N;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			System.out.print("#" + t + " ");

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dfs(i, j, new int[4], 0, 0, new boolean[101]);
				}
			}
			max = max == Integer.MIN_VALUE ? -1 : max;
			System.out.println(max);
		}
	}

	private static void dfs(int y, int x, int[] directions, int preDirection, int sum, boolean[] visited) {
//		System.out.println(y + " " + x);

		int nx, ny;

		for (int d = 0; d < 4; d++) {
			if ((preDirection == 0 && (d == 0 || d == 1)) || (preDirection == 1 && (d == 1 || d == 2))) {

				nx = dx[d] + x;
				ny = dy[d] + y;

				if (isGo(ny, nx) && !visited[map[ny][nx]]) {
					directions[d]++;
					visited[map[ny][nx]] = true;
					dfs(ny, nx, directions, d, sum + 1, visited);
					visited[map[ny][nx]] = false;
					directions[d]--;
				}
			}
		}
		if (preDirection == 2) {
			int d = directions[2] == directions[0] ? 3 : 2;
			nx = dx[d] + x;
			ny = dy[d] + y;

			if (isGo(ny, nx) && !visited[map[ny][nx]]) {
				directions[d]++;
				visited[map[ny][nx]] = true;
				dfs(ny, nx, directions, d, sum + 1, visited);
				visited[map[ny][nx]] = false;
				directions[d]--;
			}

		} else if (preDirection == 3) {
			if (directions[1] == directions[3]) {
				max = Math.max(max, sum);
				return;
			}
			int d = 3;
			nx = dx[d] + x;
			ny = dy[d] + y;

			if (isGo(ny, nx) && !visited[map[ny][nx]]) {
				directions[d]++;
				visited[map[ny][nx]] = true;
				dfs(ny, nx, directions, d, sum + 1, visited);
				visited[map[ny][nx]] = false;
				directions[d]--;
			}
		}
	}

	static boolean isGo(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
