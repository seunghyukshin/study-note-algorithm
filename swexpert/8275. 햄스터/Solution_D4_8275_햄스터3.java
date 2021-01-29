import java.io.*;
import java.util.*;

public class Solution_D4_8275_햄스터3 {
	static int N, X, M;
	static int L[], R[], S[];
	static int[] array;
	static List<Integer> list = new ArrayList<>();
	static int max;
	static int[] maxArray;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] st = br.readLine().split(" ");
			N = Integer.parseInt(st[0]);
			X = Integer.parseInt(st[1]);
			M = Integer.parseInt(st[2]);
			L = new int[M];
			R = new int[M];
			S = new int[M];
			array = new int[N];
			maxArray = new int[N];
			max = Integer.MIN_VALUE;
			for (int i = 0; i < M; i++) {
				String st2[] = br.readLine().split(" ");
				int li = Integer.parseInt(st2[0]);
				int ri = Integer.parseInt(st2[1]);
				int si = Integer.parseInt(st2[2]);

				L[i] = li;
				R[i] = ri;
				S[i] = si;
			}

			System.out.print("#" + t + " ");
			nHr(0, X, N);
			if (max != Integer.MIN_VALUE) {
				for (int i = 0; i < maxArray.length; i++) {
					int c = maxArray[i];
					System.out.print(c);
					if (i != maxArray.length - 1)
						System.out.print(" ");
				}
				System.out.println();
			} else {
				System.out.println(-1);
			}
		}
	}

	static void nHr(int index, int n, int r) {
		if (index == r) {
			boolean flag = true;
			for (int i = 0; i < M; i++) {
				int sum = 0;
				for (int j = L[i] - 1; j <= R[i] - 1; j++) {
					sum += array[j];
				}
				if (sum != S[i]) {
					flag = false;
				}
			}
			if (flag) {
				int sum = 0;
				for (int k : array) {
					sum += k;
				}
				if (max < sum) {
					max = sum;
					System.arraycopy(array, 0, maxArray, 0, array.length);
				}
			}
			return;
		}

		for (int i = 0; i <= n; i++) {
			array[index] = i;
			nHr(index + 1, n, r);
			array[index] = 0;
		}
	}

	static void printArray() {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
