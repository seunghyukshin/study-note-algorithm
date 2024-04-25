package L19_PrimeNumber;

public class P_isPrime {
    public static void main(String[] args) {
        System.out.println(isPrime(4));
        System.out.println(isPrime(7));
    }

    private static boolean isPrime(int number) {
        boolean isPrime = true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }


        return isPrime;
    }
}
