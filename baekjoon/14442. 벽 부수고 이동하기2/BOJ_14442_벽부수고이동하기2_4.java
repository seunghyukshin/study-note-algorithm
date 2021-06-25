import java.io.*;
import java.util.*;

// 3차원배열 + 벽뿌수기전에 형님찾기
// 99%에서 틀렸습니다. -> next가 finish냐 에서 current가 finish냐?로 바꿔야됨
// becuz, map이 한칸짜리인 경우 때문에
// 총 2시간 40분
public class BOJ_14442_벽부수고이동하기2_4 {
	static int N, M, K;
	static char[][] map;
	static boolean[][][] visited;
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
		visited = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
//		print(map);

		Queue<Point> queue = new LinkedList<>();
		visited[0][0][K] = true;
		queue.add(new Point(0, 0, K, 1));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if (p.y == N - 1 && p.x == M - 1) {
				System.out.println(p.count);
				return;
			}
//			System.out.println(p);
			int ny, nx;
			for (int d = 0; d < 4; d++) {
				ny = dy[d] + p.y;
				nx = dx[d] + p.x;

				if (isGo(ny, nx)) {
					if (map[ny][nx] == '0' && !visited[ny][nx][p.k]) {
						visited[ny][nx][p.k] = true;
						queue.offer(new Point(ny, nx, p.k, p.count + 1));
					} else { // 벽
						// !visited[ny][nx][p.k] : 벽을 안뿌수고도 간사람이 있다? 그럼 난 안가야지
						// !visited[ny][nx][p.k - 1] : 왔던길 안가려고
						if (p.k != 0 && !visited[ny][nx][p.k] && !visited[ny][nx][p.k - 1]) {
							visited[ny][nx][p.k - 1] = true;
							queue.offer(new Point(ny, nx, p.k - 1, p.count + 1));
						}
					}
				}
			}
//			print(countMap);

		}
		System.out.println(-1);
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
