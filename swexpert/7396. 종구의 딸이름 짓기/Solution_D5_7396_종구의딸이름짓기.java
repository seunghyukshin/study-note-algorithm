import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_D5_7396_종구의딸이름짓기 {
	static int N, M;
	static char[][] map;
	static StringBuilder min;
	static boolean[][] visited;

	public static class Point {
		int y;
		int x;
		String s;

		public Point(int y, int x, String s) {
			super();
			this.y = y;
			this.x = x;
			this.s = s;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map = new char[N][M];
			min = new StringBuilder();
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			Queue<Point> queue = new LinkedList<>();
			min.append(map[0][0]);
			queue.add(new Point(0, 0, String.valueOf(map[0][0])));
			while (!queue.isEmpty()) {
				Point p = queue.poll();
				if (p.s.length() == min.length() && min.toString().compareTo(p.s) < 0) {
					continue;
				}
//				System.out.println(p);
				if (p.y == N - 1 && p.x == M - 1)
					break;

				if (p.y + 1 == N) { // x로
					StringBuilder ns = new StringBuilder(p.s);
					ns.append(map[p.y][p.x + 1]);
					if (calc(ns.toString())) {
						min = ns;
						visited[p.y][p.x + 1] = true;
						queue.add(new Point(p.y, p.x + 1, ns.toString()));
						continue;
					}
				}

				if (p.x + 1 == M) { // y로
					StringBuilder ns = new StringBuilder(p.s);
					ns.append(map[p.y + 1][p.x]);
					if (calc(ns.toString())) {
						min = ns;
						visited[p.y + 1][p.x] = true;
						queue.add(new Point(p.y + 1, p.x, ns.toString()));
						continue;
					}
				}

				if (isGo(p.y + 1, p.x) && isGo(p.y, p.x + 1)) {
					if (!visited[p.y][p.x + 1] && map[p.y + 1][p.x] >= map[p.y][p.x + 1]) {
						// x로
						StringBuilder ns = new StringBuilder(p.s);
						ns.append(map[p.y][p.x + 1]);
//						System.out.println(min + " " + ns);
//						System.out.println(min.toString().compareTo(ns.toString()));
						if (calc(ns.toString())) {
							min = ns;
							visited[p.y][p.x + 1] = true;
							queue.add(new Point(p.y, p.x + 1, ns.toString()));
						}
					}
					if (!visited[p.y + 1][p.x] && map[p.y + 1][p.x] <= map[p.y][p.x + 1]) {
						// y로
						StringBuilder ns = new StringBuilder(p.s);
						ns.append(map[p.y + 1][p.x]);

//						System.out.println(min + " " + ns);
//						System.out.println(min.toString().compareTo(ns.toString()));
						if (calc(ns.toString())) {
							min = ns;
							visited[p.y + 1][p.x] = true;
							queue.add(new Point(p.y + 1, p.x, ns.toString()));
						}
					}
				}

			}
			System.out.print("#" + t + " ");
//			System.out.println("ab".compareTo("abc")); // -1
//			System.out.println("abd".compareTo("abc")); // -1
//			System.out.println("ab".compareTo("ba")); // -1
			System.out.println(min);
		}
	}

	static boolean calc(String s) {
		if (min.length() < s.length()) {
//			min = new StringBuilder(s);
			return true;
		}

		int c = min.toString().compareTo(s);
		if (c < 0) { // min = 'a' , s='b'
			return false;
		} else {
//			min = new StringBuilder(s);
			return true;
		}
	}

	static boolean isGo(int y, int x) {
		return y >= 0 && x >= 0 && y < N && x < M;
	}
}
