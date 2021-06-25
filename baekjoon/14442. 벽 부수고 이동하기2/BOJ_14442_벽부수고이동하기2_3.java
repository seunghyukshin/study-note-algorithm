import java.io.*;
import java.util.*;

// Fail; 3차원배열; 시간초과(20%); 
public class BOJ_14442_벽부수고이동하기2_3 {
	static int N, M, K;
	static char[][] map;
	static int[][][] countMap;
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
		countMap = new int[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(countMap[i][j], Integer.MAX_VALUE);

			}
		}
//		print(map);

		Queue<Point> queue = new LinkedList<>();
		countMap[0][0][K] = 1;
		queue.add(new Point(0, 0, K, 1));
		int min = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (min < p.count) {
				continue;
			}

			for (int k = 0; k < p.k; k++) {
				if (countMap[p.y][p.x][k] <= p.count) {
					continue;
				}
			}
//			System.out.println(p);
			int ny, nx;
			for (int d = 0; d < 4; d++) {
				ny = dy[d] + p.y;
				nx = dx[d] + p.x;

				if (isGo(ny, nx) && p.count + 1 < countMap[ny][nx][p.k]) {
					if (ny == N - 1 && nx == M - 1) {
						min = Math.min(min, p.count + 1);
						System.out.println(min);
						return;

					}

					if (map[ny][nx] == '0') {
						countMap[ny][nx][p.k] = p.count + 1;
						queue.offer(new Point(ny, nx, p.k, p.count + 1));
					} else { // 벽
						if (p.k != 0) {
							countMap[ny][nx][p.k - 1] = p.count + 1;
							queue.offer(new Point(ny, nx, p.k - 1, p.count + 1));
						}
					}
				}
			}
//			print(countMap);

		}

		for (int k = 0; k <= K; k++) {
			min = Math.min(min, countMap[N - 1][M - 1][k]);
		}
		int result = min == Integer.MAX_VALUE ? -1 : min;
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
