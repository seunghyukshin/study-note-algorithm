import java.util.*;

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 * */
public class Solution_12_IntegerToRoman_명 {
	public final String[] symbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
	public final int[] labels = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

	public HashMap<Integer, String> map = new HashMap<>();

	public static void main(String[] args) {
		Solution_12_IntegerToRoman_명 sol = new Solution_12_IntegerToRoman_명();
//		int num = 345;
//		int num = 300;
		int num = 1994;
		String answer = sol.intToRoman(num);
		System.out.println(answer);
	}

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int i = 12;
		while (true) {
			if (i == -1) {
				break;
			}

			if (num >= labels[i]) {
				num -= labels[i];
				sb.append(symbols[i]);
			} else {
				i--;
			}

		}

		return sb.toString();
	}

}
