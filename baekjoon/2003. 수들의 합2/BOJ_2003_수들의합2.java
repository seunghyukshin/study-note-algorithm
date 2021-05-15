import java.io.*;

public class BOJ_2003_수들의합2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		int M = Integer.parseInt(inputs[1]);

		int[] nums = new int[N];
		String[] inputs2 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(inputs2[i]);
		}

		int l = 0;
		int r = 0;
		int sum = nums[r];
		int count = 0;
		while (true) {
//			System.out.println(l + " " + r + " " + sum);
			if (sum <= M) {
				if (sum == M) {
					count++;
				}
				if (r == N - 1) {
					break;
				}
				r++;
				sum += nums[r];
			} else {
				sum -= nums[l];
				l++;
			}
		}
		System.out.println(count);
	}
}
