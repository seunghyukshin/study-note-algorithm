package L05_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1 <= N <= 10000
 * 0 <= K <= N
 * 최대 K번 바꿔치기 연산 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최대값은 ?
 */
public class P_두배열의원소교체_20250516 {
    static int N, K;
    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        String[] strA = br.readLine().split(" ");
        String[] strB = br.readLine().split(" ");
        A  = new int[N];
        B  = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(strA[i]);
            B[i] = Integer.parseInt(strB[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += B[N - i - 1];
        }
        for (int i = 0; i < N - K; i++) {
            sum += A[N - i - 1];
        }
        System.out.println(sum);
    }

}


/**
5 3
1 2 5 4 3
5 5 6 6 5
 */