package L05_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 1 <= N <= 10000
 * 0 <= K <= N
 * 최대 K번 바꿔치기 연산 수행하여 만들 수 있는 배열 A의 모든 원소의 합의 최대값은 ?
 */
public class P_두배열의원소교체 {
    static int N, K;
    static int[] aArray;
    static int[] bArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        K = Integer.parseInt(s[1]);

        aArray = new int[N];
        bArray = new int[N];

        String[] aStringArray = br.readLine().split(" ");
        String[] bStringArray = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            aArray[i] = Integer.parseInt(aStringArray[i]);
            bArray[i] = Integer.parseInt(bStringArray[i]);
        }

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        int sum = Arrays.stream(aArray).sum();

        int count = 0;
        while (true) {
            if (count >= K) {
                break;
            }
            int a = aArray[count];
            int b = bArray[N - count - 1];

            if(a >= b){
                break;
            }

            sum += b - a;
            count++;
        }
        System.out.println(sum);
    }
}


/**
5 3
1 2 5 4 3
5 5 6 6 5
 */