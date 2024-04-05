package L04_BinaryIndexTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP로 접근 NumberFormat.....why? << N을 long 으로
public class BOJ_2042_구간합구하기_2T {
    static int N;
    static int M; // 수의 변경이 일어나는 횟수
    static int K; // 구간합을 구하는 횟수
    static long[] array;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        array = new long[N + 1];
        tree = new long[N + 1];

        for (int i = 1; i < N + 1; i++) {
            long x = Long.parseLong(br.readLine());
            array[i] = x;
            updateTree(i, x);
        }


        for (int i = 0; i < M + K; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);

            if (a == 1) { // b번째를 c값으로
                long c = Long.parseLong(input2[2]);
                long diff = c - array[b];
                updateTree(b, diff);
                array[b] = c;
            } else if (a == 2) { // b번째부터 c번째까지의 구간합
                int c = Integer.parseInt(input2[2]);
                System.out.println(sumInterval(b, c));
            }

        }

    }

    private static long sumInterval(int b, int c) {
        return sumPrefix(c) - sumPrefix(b-1);
    }

    private static long sumPrefix(int i) {
        long result = 0;

        while (i > 0) {
            result += tree[i];
            i -= i & -i;
        }
        return result;
    }

    private static void updateTree(int i, long diff) {
        while (i < N + 1) {
            tree[i] += diff;
            i += i & -i;
        }
    }


}

/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
*
*/