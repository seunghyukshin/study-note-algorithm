
public class Solution_115_DistinctSubsequences_답 {
	int count = 0;

	public static void main(String[] args) {

		Solution_115_DistinctSubsequences_답 sol = new Solution_115_DistinctSubsequences_답();
//		String s = "babgbag";
//		String t = "bag";
//		String s = "rabbbit";
//		String t = "rabbit";
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String t = "bcddceeeebecbc";
		int res = sol.numDistinct(s, t);
		System.out.println(res);
	}

	public int numDistinct(String S, String T) {
		// array creation
		int[][] mem = new int[T.length() + 1][S.length() + 1];

		// filling the first row: with 1s
		for (int j = 0; j <= S.length(); j++) {
			mem[0][j] = 1;
		}

		// the first column is 0 by default in every other rows but the first, which we
		// need.

		for (int i = 1; i < T.length() + 1; i++) {
			for (int j = 1; j < S.length() + 1; j++) {
				if (T.charAt(i - 1) == S.charAt(j - 1)) {
					mem[i][j] = mem[i - 1][j - 1] + mem[i][j - 1];
				} else {
					mem[i][j] = mem[i][j - 1];
				}
			}
		}

		for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j < mem[i].length; j++) {
				System.out.print(mem[i][j] + " ");
			}
			System.out.println();
		}

		return mem[T.length()][S.length()];
	}
}
