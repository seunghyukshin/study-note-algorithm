import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// dfs - pass
// 알파벳 개수 26개로 제한 (207ms)
// 백트래킹 (159ms)
public class Solution_D4_7699_수지의수지맞는여행3 {
	static int R, C;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int max;

	public static class Point {
		int x;
		int y;
		String s;

		public Point(int y, int x, String s) {
			this.x = x;
			this.y = y;
			this.s = s;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);

			map = new char[R][C];
			visited = new boolean[26];
			max = Integer.MIN_VALUE;

			for (int r = 0; r < R; r++) {
				char[] c = br.readLine().toCharArray();
				for (int i = 0; i < c.length; i++) {
					map[r][i] = c[i];
				}
			}
			
			visited[map[0][0] - 'A'] = true;
			dfs(0, 0, 1);

			System.out.print("#" + t + " ");
			System.out.println(max);
		}
	}

	private static void dfs(int y, int x, int count) {
		max = Math.max(max, count);
		if (max == 26)
			return;
//		System.out.println(s);
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (isGo(ny, nx) && !visited[map[ny][nx] - 'A']) {
				visited[map[ny][nx] - 'A'] = true;
				dfs(ny, nx, count + 1);
				visited[map[ny][nx] - 'A'] = false;
			}
		}

	}

	public static boolean isGo(int y, int x) {
		return x >= 0 && y >= 0 && y < R && x < C;
	}

	public static void print() {

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
