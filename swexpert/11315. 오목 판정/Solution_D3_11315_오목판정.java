import java.io.*;

public class Solution_D3_11315_오목판정 {
	static int N;
	static char STONE = 'o';
	static char[][] map;
	static int[] dx = { 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1 };
	static boolean[][][] visit;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visit = new boolean[N][N][4];
			flag = false;

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == STONE) {
						for (int d = 0; d < 4; d++) {
							if (visit[i][j][d]) {
								continue;
							}
//							System.out.println("i" + i + " j" + j + " d" + d);
							dfs(i, j, d, 1);
						}
					}
				}
			}
			System.out.println(flag ? "YES" : "NO");
		}
	}

	private static void dfs(int y, int x, int d, int count) {
//		System.out.println(y + " " + x + " " + d);
		if (count == 5) {
			flag = true;
		}
		if (flag)
			return;

		int ny = dy[d] + y;
		int nx = dx[d] + x;
		if (isGo(ny, nx) && !visit[ny][nx][d] && map[ny][nx] == STONE) {
			visit[ny][nx][d] = true;
			dfs(ny, nx, d, count + 1);
		}
	}

	static boolean isGo(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < N;
	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
