import java.io.*;
import java.util.ArrayList;

public class Solution_D5_4534_트리흑백색칠2 {
	static int N;
	static ArrayList<Integer>[] map;
	static boolean[] visit;
	static final long MOD = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new ArrayList[N];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				map[i] = new ArrayList<Integer>();
			}
			for (int n = 0; n < N - 1; n++) {
				String[] s = br.readLine().split(" ");
				int x = Integer.parseInt(s[0]) - 1;
				int y = Integer.parseInt(s[1]) - 1;
				map[x].add(y);
				map[y].add(x);
			}
			System.out.print("#" + t + " ");
			visit[0] = true;
			long[] array = dfs(0);
			System.out.println((array[0] + array[1]) % MOD);

		}
	}

	private static long[] dfs(int vertex) {
		long white = 1;
		long black = 1;
		for (int i : map[vertex]) {
			if (!visit[i]) {
				visit[i] = true;
				long[] childNode = dfs(i);
				white = (white * (childNode[0] + childNode[1])) % MOD;
				black = (black * childNode[0]) % MOD;
			}
		}
//		System.out.println(vertex + 1 + " : " + white + " " + black);
		return new long[] { white % MOD, black % MOD };
	}

}