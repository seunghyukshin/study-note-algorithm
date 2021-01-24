import java.io.*;
import java.util.*;

public class Solution_4012_요리사 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int min;
	static List<Integer> list = new ArrayList<>();
	static List<Integer> list2 = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N];
			min = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			nCr(0, 0);
//			print();
			System.out.print("#" + t + " ");
			System.out.println(min);
		}
	}

	private static void nCr(int start, int count) {
		if (count == N / 2) {
			int sumA = 0;
			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < list.size(); j++) {
					int indexi = list.get(i);
					int indexj = list.get(j);

					sumA += map[indexi][indexj];
					visited[indexi] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				if (!visited[i]) {
					list2.add(i);
				}
			}

			int sumB = 0;
			for (int i = 0; i < list2.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
					int indexi = list2.get(i);
					int indexj = list2.get(j);

					sumB += map[indexi][indexj];
				}
			}
			min = Math.min(min, Math.abs(sumA - sumB));
//			System.out.println(list.toString() + "  " + list2.toString() + " sumA:" + sumA + " sumB:" + sumB);
			list2 = new ArrayList<>();
			Arrays.fill(visited, false);
			return;
		}

		for (int i = start; i < N; i++) {
			list.add(i);
			nCr(i + 1, count + 1);
			list.remove(list.indexOf(i));
		}
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
