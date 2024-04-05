package L04_BinaryIndexTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BIT {

    static int N, M, K;
    static long[] array = new long[10000001];
    static long[] tree = new long[10000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        for (int i = 1; i <= N; i++) {
            long x = Long.parseLong(br.readLine());
            array[i] = x;
            update(i, x);
        }

        for (int i = 0; i < M + K; i++) {
            String[] input2 = br.readLine().split(" ");
            int op = Integer.parseInt(input2[0]);

            if (op == 1) { // b번째를 c값으로

                int index = Integer.parseInt(input2[1]);
                long value = Long.parseLong(input2[2]);

                update(index, value - array[index]);
                array[index] = value; // b번째 수를 업데이트

            } else if (op == 2) { // b번째부터 c번째까지의 구간합

                int start = Integer.parseInt(input2[1]);
                int end = Integer.parseInt(input2[2]);

                System.out.println(intervalSum(start, end));
            }

        }

    }

    private static long intervalSum(int start, int end) {
        return prefixSum(end) - prefixSum(start - 1);

    }

    private static long prefixSum(int i) {
        long result = 0;
        while (i > 0) {
            result += tree[i];
            i -= (i & -i);
        }

        return result;
    }

    private static void update(int i, long diff) {
        while (i <= N) {
            tree[i] += diff;
            i += (i & -i);
        }
    }
}
