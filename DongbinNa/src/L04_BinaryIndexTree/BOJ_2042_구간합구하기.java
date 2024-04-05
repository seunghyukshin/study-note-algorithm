package L04_BinaryIndexTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// DP로 접근 NumberFormat.....why? << N을 long 으로
public class BOJ_2042_구간합구하기 {
    static int N;
    static int M; // 수의 변경이 일어나는 횟수
    static int K; // 구간합을 구하는 횟수
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        array = new int[N];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        initDp();


        for (int i = 0; i < M + K; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            int c = Integer.parseInt(input2[2]);

            if (a == 1) { // b번째를 c값으로
                int def = c - array[b - 1];
                array[b - 1] = c;
                makeDp(b - 1, def);

            } else if (a == 2) { // b번째부터 c번째까지의 구간합
                System.out.println(dp[c] - dp[b - 1]);
            }

        }

    }

    private static void initDp() {
        for (int i = 0; i < N; i++) {
            dp[i + 1] = dp[i] + array[i];
        }
    }

    private static void makeDp(int index, int def) {
        for (int i = index; i < N; i++) {
            dp[i + 1] = dp[i + 1] + def;
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