import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleBruteForte_PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        try {
            do {
                number = sc.nextInt();
                if (number <= 0) {
                    System.out.println("Entre com números inteiros positivos");
                }
            } while (number <= 0);

            if (isPrime(number)) {
                System.out.println("Eh primo!");
            } else {
                System.out.println("Não eh primo!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Insira entradas válidas!");
        }

        sc.close();
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}