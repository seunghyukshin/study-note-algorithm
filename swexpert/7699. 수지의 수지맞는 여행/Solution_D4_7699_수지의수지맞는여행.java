import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// bfs - 시간초과 (20001ms)
public class Solution_D4_7699_수지의수지맞는여행 {
	static int R, C;
	static String[][] map;
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

			map = new String[R][C];
			max = Integer.MIN_VALUE;

			for (int r = 0; r < R; r++) {
				char[] c = br.readLine().toCharArray();
				for (int i = 0; i < c.length; i++) {
					map[r][i] = String.valueOf(c[i]);
				}
			}

			Queue<Point> queue = new LinkedList<>();
			queue.add(new Point(0, 0, map[0][0]));
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				String nowAlphas = p.s;
				System.out.println(nowAlphas);
				max = Math.max(max, nowAlphas.length());
				for (int d = 0; d < 4; d++) {
					int nx = p.x + dx[d];
					int ny = p.y + dy[d];

					if (isGo(ny, nx) && !nowAlphas.contains(map[ny][nx])) {
						String nextAlphas = map[ny][nx];
//						visited[ny][nx] = true;

						queue.add(new Point(ny, nx, nowAlphas.concat(nextAlphas)));
					}
				}

			}
			System.out.print("#" + t + " ");
			System.out.println(max);
//			print();
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
