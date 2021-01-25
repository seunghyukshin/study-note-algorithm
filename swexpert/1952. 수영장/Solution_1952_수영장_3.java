import java.io.*;

public class Solution_1952_수영장_3 {
	static int[] cost;
	static int[] calendar;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cost = new int[4];
			calendar = new int[12];
			String[] s = br.readLine().split(" ");
			for (int i = 0; i < 4; i++) {
				cost[i] = Integer.parseInt(s[i]);
			}
			String[] s2 = br.readLine().split(" ");
			for (int i = 0; i < 12; i++) {
				calendar[i] = Integer.parseInt(s2[i]);
			}
			min = cost[3];

			dfs(0, 0);
			System.out.print("#" + t + " ");
			System.out.println(min);

		}
	}

	private static void dfs(int month, int sum) {

//		System.out.println("month:" + month);
//		System.out.println(" sum:" + sum);
		if (month >= 12) {
			min = Math.min(min, sum);
			return;
		}
		if (min <= sum) {
			return;
		}
		int oneDayCost = cost[0] * calendar[month];
		int oneMonthCost = Math.min(oneDayCost, cost[1]);
		dfs(month + 1, sum + oneMonthCost);

		int threeMonthCost = cost[2];
		dfs(month + 3, sum + threeMonthCost);
	}
}


