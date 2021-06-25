import java.io.*;
import java.util.*;

// Fail; BFS; k값 비교가 안됨
public class BOJ_14442_벽부수고이동하기2 {
	static int N, M, K;
	static char[][] map;
	static int[][] countMap;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static class Point {
		int y;
		int x;
		int k;
		int count;

		public Point(int y, int x, int k, int count) {
			super();
			this.y = y;
			this.x = x;
			this.k = k;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + ", k=" + k + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		map = new char[N][M];
		countMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(countMap[i], Integer.MAX_VALUE);
		}
//		print(map);

		Queue<Point> queue = new LinkedList<>();
		countMap[0][0] = 1;
		queue.add(new Point(0, 0, K, 1));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			System.out.println(p);
			int ny, nx;
			for (int d = 0; d < 4; d++) {
				ny = dy[d] + p.y;
				nx = dx[d] + p.x;

				if (isGo(ny, nx) && p.count + 1 < countMap[ny][nx]) {
					if (map[ny][nx] == '0') {
						countMap[ny][nx] = p.count + 1;
						queue.offer(new Point(ny, nx, p.k, p.count + 1));
					} else { // 벽
						if (p.k != 0) {
							countMap[ny][nx] = p.count + 1;
							queue.offer(new Point(ny, nx, p.k - 1, p.count + 1));
						}
					}
				}
			}
			print(countMap);

		}

		int result = countMap[N - 1][M - 1] == Integer.MAX_VALUE ? -1 : countMap[N - 1][M - 1];
		System.out.println(result);
	}

	private static boolean isGo(int ny, int nx) {
		return ny >= 0 && nx >= 0 && ny < N && nx < M;
	}

	private static void print(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
