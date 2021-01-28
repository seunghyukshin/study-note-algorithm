import java.io.*;
import java.util.*;

public class Solution_D4_8382_방향전환 {
	static Point start, end;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int min;
	static boolean visited[][][];
	static Queue<Point> queue = new LinkedList<>();

	static class Point {
		int x;
		int y;
		int d; // 0 : Not thing 1: vertical 2: horizontal
		int count;

		public Point(int y, int x, int d, int count) {
			this.y = y;
			this.x = x;
			this.d = d;
			this.count = count;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			start = new Point(Integer.parseInt(s[1]), Integer.parseInt(s[0]), 0, 0);
			end = new Point(Integer.parseInt(s[3]), Integer.parseInt(s[2]), 0, 0);
			min = Integer.MAX_VALUE;
			visited = new boolean[201][201][2];

			System.out.print("#" + t + " ");

			if (start.x == end.x && start.y == end.y) {
				System.out.println(0);
				continue;
			}
			visited[start.y + 100][start.x + 100][0] = true;
			queue.add(new Point(start.y, start.x, 1, 0));

			visited[start.y + 100][start.x + 100][1] = true;
			queue.add(new Point(start.y, start.x, 2, 0));
			bfs();
			System.out.println(min);

		}
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			Point p = queue.poll();
//			System.out.println(p.x + " " + p.y);
			if (p.count >= min) {
				continue;
			}

			if (p.d == 1) {
				for (int d = 0; d < 2; d++) {
					int nx = dx[d] + p.x;
					int ny = dy[d] + p.y;

					if (isGo(ny, nx) && !visited[ny + 100][nx + 100][1]) {
						if (ny == end.y && nx == end.x) {
							min = Math.min(min, p.count + 1);
							continue;
						}

						visited[ny + 100][nx + 100][1] = true;
						queue.add(new Point(ny, nx, 2, p.count + 1));
					}
				}
			} else {
				for (int d = 2; d < 4; d++) {
					int nx = dx[d] + p.x;
					int ny = dy[d] + p.y;

					if (isGo(ny, nx) && !visited[ny + 100][nx + 100][0]) {
						if (ny == end.y && nx == end.x) {
							min = Math.min(min, p.count + 1);
							continue;
						}
						visited[ny + 100][nx + 100][0] = true;
						queue.add(new Point(ny, nx, 1, p.count + 1));
					}
				}
			}
		}

	}

	static boolean isGo(int y, int x) {
		return x >= -100 && y >= -100 && x <= 100 && y <= 100;
	}

}
