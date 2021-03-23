import java.util.LinkedList;
import java.util.Queue;

public class Solution_200_NumberOfIslands {
	public static void main(String[] args) {

		Solution_200_NumberOfIslands sol = new Solution_200_NumberOfIslands();
		String[][] gridString = { { "1", "1", "1", "1", "0" }, { "1", "1", "0", "1", "0" }, { "1", "1", "0", "0", "0" },
				{ "0", "0", "0", "0", "0" } };
		char[][] grid = new char[gridString.length][gridString[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = gridString[i][j].charAt(0);
			}
		}
		int res = sol.numIslands(grid);
		System.out.println(res);
	}

	public class Point {
		int y;
		int x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}

	int[] dx = { 0, 0, 1, -1 };
	int[] dy = { 1, -1, 0, 0 };
	int M, N;
	boolean visit[][];

	public int numIslands(char[][] grid) {
		int count = 0;

		M = grid.length;
		N = grid[0].length;
		visit = new boolean[M][N];
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == '1' && !visit[i][j]) {
					count++;
					queue.add(new Point(i, j));
					bfs(grid, queue);
				}

			}
		}

		return count;
	}

	private void bfs(char[][] grid, Queue<Point> queue) {
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int ny, nx;
			for (int d = 0; d < 4; d++) {
				ny = dy[d] + p.y;
				nx = dx[d] + p.x;
				if (isGo(ny, nx) && !visit[ny][nx] && grid[ny][nx] == '1') {
					visit[ny][nx] = true;
					queue.add(new Point(ny, nx));
				}
			}

		}
	}

	private boolean isGo(int ny, int nx) {
		return ny < M && nx < N && nx >= 0 && ny >= 0;
	}
}
