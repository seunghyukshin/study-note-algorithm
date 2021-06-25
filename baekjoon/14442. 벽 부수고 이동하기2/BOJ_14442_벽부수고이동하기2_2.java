import java.io.*;
import java.util.*;

// dfs : 시간초과
public class BOJ_14442_벽부수고이동하기2_2 {
	static int N, M, K;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		// init
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		visited[0][0] = true;
		dfs(0, 0, K, 1);
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static int min = Integer.MAX_VALUE;

	private static void dfs(int y, int x, int k, int count) {
		if (min <= count)
			return;
//		System.out.print("y" + y + " x" + x + " ");
//		System.out.println("k" + k + " count" + count);
		int ny, nx;
		for (int d = 0; d < 4; d++) {
			ny = dy[d] + y;
			nx = dx[d] + x;

			if (isGo(ny, nx) && !visited[ny][nx]) {
				if (ny == N - 1 && nx == M - 1) {
					min = Math.min(min, count + 1);
					return;
				}
				if (map[ny][nx] == '0') {
					visited[ny][nx] = true;
					dfs(ny, nx, k, count + 1);
					visited[ny][nx] = false;
				} else if (k != 0) {
					// 벽이지만 아직 부술 힘이 남아있을 때
					visited[ny][nx] = true;
					dfs(ny, nx, k - 1, count + 1);
					visited[ny][nx] = false;
				}
			} else {
				continue;
			}
		}
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
