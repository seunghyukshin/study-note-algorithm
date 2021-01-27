import java.io.*;

public class BOJ_3109_빵집 {
	static int[] dx = { 1, 1, 1 };
	static int[] dy = { -1, 0, 1 };
	static int R, C;
	static char[][] map;
	static boolean[][] visited;
	static int count;

	static final char SPACE = '.';
	static final char WALL = 'x';

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new char[R][C];
		visited = new boolean[R][C];
		count = 0;

		for (int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
		}

		for (int i = 0; i < R; i++) {
			if (map[i][0] == SPACE) {
				visited[i][0] = true;
				dfs(i, 0);
			}
		}
		System.out.println(count);
//		print();
	}

	private static boolean dfs(int y, int x) {
//		System.out.println(x + " " + y);
		for (int d = 0; d < 3; d++) {
			int nx = dx[d] + x;
			int ny = dy[d] + y;

			if (isGo(ny, nx) && !visited[ny][nx] && map[ny][nx] == SPACE) {
				if (nx == C - 1) {
//					System.out.println("=======" + x + " " + y);
					visited[ny][nx] = true;
					count++;
					return true;
				}
				visited[ny][nx] = true;
				if (dfs(ny, nx)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isGo(int y, int x) {
		return y >= 0 && x >= 0 && y < R && x < C;
	}

	static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
