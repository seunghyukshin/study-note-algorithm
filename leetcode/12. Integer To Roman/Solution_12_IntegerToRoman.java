import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/*
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
 * */
public class Solution_12_IntegerToRoman {
	public final char[] symbols = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };

	public static void main(String[] args) {
		Solution_12_IntegerToRoman sol = new Solution_12_IntegerToRoman();
//		int num = 345;
		int num = 300;
//		int num = 1994;
		String answer = sol.intToRoman(num);
		System.out.println(answer);
	}

	public String intToRoman(int num) {
		String input = String.valueOf(num);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int n = c - '0';
			int j = input.length() - i - 1;
			String s = convertToRoman(n, j);
			sb.append(s);
		}

		return sb.toString();
	}

	private String convertToRoman(int n, int j) {
		StringBuilder sb = new StringBuilder();
		if (j == 3) {
			for (int i = 0; i < n; i++) {
				sb.append(symbols[6]);
			}
		} else {
			if (n >= 1 && n <= 3) {
				for (int i = 0; i < n; i++) {
					sb.append(symbols[2 * j]);
				}
			} else if (n == 4) {
				sb.append(symbols[2 * j]);
				sb.append(symbols[2 * j + 1]);
			} else if (n == 5) {
				sb.append(symbols[2 * j + 1]);
			} else if (n >= 6 && n <= 8) {
				sb.append(symbols[2 * j + 1]);
				for (int i = 0; i < n - 5; i++) {
					sb.append(symbols[2 * j]);
				}
			} else if (n == 9) {
				sb.append(symbols[2 * j]);
				sb.append(symbols[2 * j + 2]);
			}
		}
		return sb.toString();
	}
}
