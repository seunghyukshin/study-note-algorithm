import java.util.LinkedList;
import java.util.Queue;

public class Solution_130_SurroundedRegions {

	public static void main(String[] args) {
		Solution_130_SurroundedRegions sol = new Solution_130_SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		sol.solve(board);
	}

	final char X = 'X';
	final char O = 'O';

	int[] dx = { -1, 1, 0, 0 };
	int[] dy = { 0, 0, -1, 1 };
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

	public void solve(char[][] board) {
		M = board.length;
		N = board[0].length;
		char[][] map = new char[M + 2][N + 2];
		boolean[][] visited = new boolean[M + 2][N + 2];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				map[i + 1][j + 1] = board[i][j];
			}
		}

		Queue<Point> queue = new LinkedList<>();
		visited[0][0] = true;
		queue.add(new Point(0, 0));
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int ny, nx;
			for (int d = 0; d < 4; d++) {
				ny = dy[d] + p.y;
				nx = dx[d] + p.x;
				if (isGo(ny, nx) && !visited[ny][nx] && map[ny][nx] != X) {
					visited[ny][nx] = true;
					queue.add(new Point(ny, nx));
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				board[i][j] = visited[i + 1][j + 1] ? O : X;
			}
		}
	}

	public boolean isGo(int ny, int nx) {
		return ny >= 0 && nx >= 0 && ny < M + 2 && nx < N + 2;
	}
}
