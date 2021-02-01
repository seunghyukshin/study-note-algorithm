import java.io.*;
import java.util.*;

public class BOJ_2636_치즈 {

	static int H, W;
	static int[][] map;
	static boolean[][] visited;
	static final int SPACE = 0;
	static final int CHEEZE = 1;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static class Point {
		int x, y;

		public Point(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		H = Integer.parseInt(s[0]);
		W = Integer.parseInt(s[1]);
		map = new int[H][W];
		visited = new boolean[H][W];

		for (int i = 0; i < H; i++) {
			String[] ss = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(ss[j]);
			}
		}

		Queue<Point> queue = new LinkedList<>();

		int hour = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (true) {
			boolean isChanged = false;

			// start
			visited = new boolean[H][W];
			visited[0][0] = true;
			queue.add(new Point(0, 0));
			int count = 0;
			while (!queue.isEmpty()) {
				Point p = queue.poll();
//				System.out.println(p.x + " " + p.y + " " + map[p.y][p.x]);

				int ny, nx;
				for (int d = 0; d < 4; d++) {
					ny = dy[d] + p.y;
					nx = dx[d] + p.x;
					if (isGo(ny, nx) && !visited[ny][nx]) {
						if (map[ny][nx] != CHEEZE) {
							visited[ny][nx] = true;
							queue.add(new Point(ny, nx));

						} else {
							count++;
							isChanged = true;
							visited[ny][nx] = true;
							map[ny][nx] = SPACE;
						}
					}

				}
			}
			list.add(count);
			if (!isChanged) {
				break;
			}
			hour++;
		}
		System.out.println(hour);
		System.out.println(list.get(list.size() - 2));
	}

	static boolean isGo(int y, int x) {
		return y >= 0 && x >= 0 && y < H && x < W;
	}

	static void print() {

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
