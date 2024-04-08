package L05_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 1 <= N <= 10000
 * 0 <= K <= N
 * 최대 K번 바꿔치기 연산 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최대값은 ?
 */
public class S_두배열의원소교체 {
    static int N, K;
    static int[] aArray;
    static int[] bArray;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[N];
        for (int i = 0; i < N; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            if (a[i] < b[i]) {
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else {
                break;
            }
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            result += a[i];
        }
        System.out.println(result);
    }
}


/**
 * 5 3
 * 1 2 5 4 3
 * 5 5 6 6 5
 */