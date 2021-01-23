import java.io.*;
import java.util.Scanner;

public class Solution_D4_4796_의석이의우뚝선산 {
	static int[] h;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			h = new int[N];
			sum = 0;
			int index = 0;
			for (int i = 0; i < N; i++) {
				h[index++] = sc.nextInt();
			}
			for (int k = 1; k < N - 1; k++) {
				if (h[k - 1] < h[k] && h[k] > h[k + 1]) {
					int sum1 = 0;
					int sum2 = 0;
					for (int i = k - 1; i >= 0; i--) {
						if (h[i] < h[i + 1]) {
							sum1++;
						} else {
							break;
						}
					}
					for (int j = k + 1; j < N; j++) {
						if (h[j] < h[j - 1]) {
							sum2++;
						} else {
							break;
						}
					}
					sum += sum1 * sum2;
				}
			}
			System.out.print("#" + t + " ");
			System.out.println(sum);
		}
	}

}
