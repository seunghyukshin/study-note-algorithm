import java.util.LinkedList;
import java.util.Queue;

public class Solution_63_UniquePaths2_2 {

	int[] dx = { 1, 0 };
	int[] dy = { 0, 1 };
	boolean[][] visit;
	int M, N;

	public class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Point [y=" + y + ", x=" + x + "]";
		}

	}

	public static void main(String[] args) {

		Solution_63_UniquePaths2_2 sol = new Solution_63_UniquePaths2_2();
//		int ans = sol.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } });
		int ans = sol.uniquePathsWithObstacles(
				new int[][] { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } });
		System.out.println(ans);
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int result = 0;
		M = obstacleGrid.length;
		N = obstacleGrid[0].length;

		visit = new boolean[M][N];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			System.out.println(p);

			if (isGo(p.y, p.x) && obstacleGrid[p.y][p.x] != 1) {
				if (p.y == M - 1 && p.x == N - 1) {
					result++;
					continue;
				}
				int ny, nx;
				for (int d = 0; d < 2; d++) {
					nx = dx[d] + p.x;
					ny = dy[d] + p.y;

					queue.add(new Point(ny, nx));

				}

			}
		}

		return result;
	}

	public boolean isGo(int y, int x) {
		return y < M && x < N;
	}
}
