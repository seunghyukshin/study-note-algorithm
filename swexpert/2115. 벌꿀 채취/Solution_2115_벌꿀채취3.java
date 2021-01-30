import java.io.*;
import java.util.*;

public class Solution_2115_벌꿀채취3 {
	static int N, M, C;
	static int map[][];
	static int valueMap[][];
	static ArrayList<Integer> honeyList;
	static int maxOfmulSum;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			C = Integer.parseInt(s[2]);
			map = new int[N][N];
			valueMap = new int[N][N];
			maxOfmulSum = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				String[] s2 = br.readLine().split(" ");
				for (int j = 0; j < s2.length; j++) {
					map[i][j] = Integer.parseInt(s2[j]);
				}
			}

			// valueMap 생성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					honeyList = new ArrayList<>();
					maxOfmulSum = Integer.MIN_VALUE;
					for (int k = j; k < j + M; k++) {
						honeyList.add(map[i][k]);
					}

					for (int k = M; k > 0; k--) {
						nCr(0, 0, M, k, 0, 0);
					}
					valueMap[i][j] = maxOfmulSum;
				}
			}
//			printArray();

			// valueMap nCr
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N - M + 1; j++) {
					int prove1 = valueMap[i][j];
					for (int i2 = i; i2 < N; i2++) {
						for (int j2 = 0; j2 < N - M + 1; j2++) {
							if (i == i2 && j + M > j2)
								continue;
							int prove2 = valueMap[i2][j2];
							if (max < prove1 + prove2) {
								max = Math.max(max, prove1 + prove2);
//								System.out.println(prove1 + " " + prove2 + " " + max);
							}
						}
					}
				}
			}
			System.out.print("#" + t + " ");
			System.out.println(max);

		}

	}

	private static void nCr(int start, int count, int n, int r, int sum, int mulSum) {
		if (sum > C) {
			return;
		}
		if (count == r) {
			if (mulSum > maxOfmulSum) {
				maxOfmulSum = mulSum;
			}
			return;
		}
		for (int i = start; i < n; i++) {

			int newSum = sum + honeyList.get(i);
			int newMulSum = mulSum + honeyList.get(i) * honeyList.get(i);
			nCr(i + 1, count + 1, n, r, newSum, newMulSum);

//			sum += i;
		}
	}

	public static int calcurate(ArrayList<Integer> list) {
		int sum = 0;
		for (int i : list) {
			sum += i * i;
		}
		return sum;
	}

	public static void printArray() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(valueMap[i][j] + " ");
			}
			System.out.println();
		}

	}
}
