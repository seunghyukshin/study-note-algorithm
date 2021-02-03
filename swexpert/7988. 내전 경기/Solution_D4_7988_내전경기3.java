import java.io.*;
import java.util.*;

// pass 2hour... 이분 그래프
public class Solution_D4_7988_내전경기3 {
	static int K;
	static boolean flag;
	static Map<String, Integer> hashMap;
	static String[][] temp;
	static int[][] map;
	static int N;
	static int[] team;
	// 0: not visited / 1: left / 2: right
	static final int NOT_VISITED = 0;
	static final int LEFT = 1;
	static final int RIGHT = 2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			flag = true;
			hashMap = new HashMap<String, Integer>();

			temp = new String[K][2];
			for (int i = 0; i < K; i++) {
				String[] s = br.readLine().split(" ");
				if (!hashMap.containsKey(s[0])) {
					hashMap.put(s[0], hashMap.size());
				}
				if (!hashMap.containsKey(s[1])) {
					hashMap.put(s[1], hashMap.size());
				}
				temp[i][0] = s[0];
				temp[i][1] = s[1];
			}
			N = hashMap.size();
			map = new int[N][N];
			team = new int[N];
			for (int i = 0; i < K; i++) {
				int index1 = hashMap.get(temp[i][0]);
				int index2 = hashMap.get(temp[i][1]);
				map[index1][index2] = 1;
				map[index2][index1] = 1;
			}

			System.out.print("#" + t + " ");
			team[0] = LEFT;
			dfs(0, LEFT, 1);

			String result = flag ? "Yes" : "No";
			System.out.println(result);
		}
	}

	private static void dfs(int vertex, int color, int count) {
//		System.out.println(vertex + " " + color + " " + count);
		if (!flag)
			return;
		for (int i = 0; i < N; i++) {
			if (map[vertex][i] == 1 && team[i] == NOT_VISITED) {
				if (color == LEFT) {
					team[i] = RIGHT;
					dfs(i, RIGHT, count + 1);
				} else if (color == RIGHT) {
					team[i] = LEFT;
					dfs(i, LEFT, count + 1);
				}
			} else if (map[vertex][i] == 1 && team[i] == color) {
				flag = false;
				return;
			}
		}
	}

	static void print() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
}
