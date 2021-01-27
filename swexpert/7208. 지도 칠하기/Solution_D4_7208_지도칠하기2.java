import java.io.*;

public class Solution_D4_7208_지도칠하기2 {
	static int N;
	static int colors[];
	static boolean visited[];
	static int map[][];
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			colors = new int[N];
			map = new int[N][N];
			visited = new boolean[N];
//			min = Integer.MAX_VALUE;
			min = 0;
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				colors[i] = Integer.parseInt(s[i]);
			}

			for (int i = 0; i < N; i++) {
				String[] ss = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(ss[j]);
				}
			}
			System.out.print("#" + t + " ");
			visited[0] = true;
			dfs(0, 0);
			System.out.println(min);
		}
	}

	private static void dfs(int index, int count) {
		int nowCount = count;
//		System.out.println("index:" + index + " count:" + count);
		int nowColor = colors[index];
		for (int j = 0; j < N; j++) {
			if (map[index][j] == 1 && !visited[j]) {
				int nestColor = colors[j];
				if (nestColor == nowColor) {
					for (int c = 1; c <= 4; c++) {
						if (nowColor == c)
							continue;
						nestColor = c;
						colors[j] = c;
					}
					nowCount++;
				}

				visited[j] = true;
				dfs(j, nowCount);
				visited[j] = false;
				colors[j] = nestColor;
			}
		}
		min = Math.max(min, count);

	}

	private static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
