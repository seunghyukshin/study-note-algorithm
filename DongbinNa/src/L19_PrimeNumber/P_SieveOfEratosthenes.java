package L19_PrimeNumber;

import java.util.Arrays;
import java.util.Scanner;

public class P_SieveOfEratosthenes {

    private static boolean[] array; // true:소수

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        array = new boolean[N + 1];
        Arrays.fill(array, true);


        sieve(N);

    }

    private static void sieve(int N) {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!array[i]) continue; // i가 소수가 아니면 skip

            for (int j = 2; i * j <= N; j++) {
                array[i * j] = false;
            }
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
