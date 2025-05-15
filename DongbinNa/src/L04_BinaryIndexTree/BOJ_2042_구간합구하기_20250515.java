package L04_BinaryIndexTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2042_구간합구하기_20250515 {
    static int N, M, K;
    static long[] array;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        K = Integer.parseInt(inputs[2]);

        array = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            array[i] = Long.parseLong(br.readLine());
        }

        _initBIT();

        for (int i = 0; i < M + K; i++) {
            String[] inputs2 = br.readLine().split(" ");
            int a = Integer.parseInt(inputs2[0]);
            int b = Integer.parseInt(inputs2[1]);
            // a가 1이면 b번째를 c로 바꿈
            // a가 2면  b번째부터 c번째까지의 합을 출력

            if (a == 1) {
                long c = Long.parseLong(inputs2[2]);
                _update(b, c - array[b]);
                array[b] = c;
            }

            if (a == 2) {
                int c = Integer.parseInt(inputs2[2]);
                System.out.println(_rangeSum(b, c));
            }
        }
    }

    private static void _initBIT() {
        tree = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            _update(i, array[i]);
        }
    }

    private static void _update(int index, long diff) {
        for (int i = index; i <= N; i += (i & -i)) {
            tree[i] += diff;
        }
    }

    private static long _rangeSum(int start, int end) {
        return _prefixSum(end) - _prefixSum(start - 1);
    }

    private static long _prefixSum(int index) {
        long sum = 0;
        for (int i = index; i > 0; i -= (i & -i)) {
            sum += tree[i];
        }
        return sum;
    }
}
