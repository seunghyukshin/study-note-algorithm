import java.util.TreeSet;

public class Solution_135_Candy2 {
	public static void main(String[] args) {
		Solution_135_Candy2 sol = new Solution_135_Candy2();
//		int[] ratings = { 1, 3, 2, 2, 1 };
		int[] ratings = { 1, 3, 4, 5, 2 };
//		int[] ratings = { 1, 2, 2 };
//		int[] ratings = { 1, 0, 2 };
//		int[] ratings = { 2, 0, 1 };
//		int[] ratings = { 1, 0, 2, 0, 1, 2, 1, 4, 0, 2 };
		int res = sol.candy(ratings);
		System.out.println(res);
	}

	public int candy(int[] ratings) {
		TreeSet<Integer> ts = new TreeSet<>();
		int res = 0;

		int[] candies = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			ts.add(ratings[i]);
		}
		for (int t : ts) {
//			System.out.println("t" + t);
			for (int i = 0; i < ratings.length; i++) {
				if (t == ratings[i]) {
					int max = 1;
					if (i - 1 >= 0) {
						if (ratings[i - 1] < ratings[i]) {
							max = candies[i - 1] + 1;
						}
					}
					if (i + 1 < ratings.length) {
						if (ratings[i + 1] < ratings[i]) {
							max = Math.max(max, candies[i + 1] + 1);
						}
					}
//					System.out.println(max);
					candies[i] = max;
					res += candies[i];
				}

			}
		}

		for (int r : ratings) {
			System.out.print(r + " ");
		}
		System.out.println();

		for (int c : candies) {
			System.out.print(c + " ");
		}
		System.out.println();

		return res;
	}
}
