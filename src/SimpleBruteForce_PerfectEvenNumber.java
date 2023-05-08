import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleBruteForce_PerfectEvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number;

        try {
            do {
                number = sc.nextInt();
                if (number <= 0) {
                    System.out.println("Entre com números inteiros positivos!");
                }
            } while (number <= 0);

            if (isPerfectEvenNumber(number)) {
                System.out.println("Eh par perfeito!");
            } else {
                System.out.println("Não eh par perfeito!");
            }

        } catch (InputMismatchException e) {
            System.out.println("Insira entradas válidas!");
        }

        sc.close();
    }

    private static boolean isPerfectEvenNumber(int number) {
        int sumDivisors = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sumDivisors += i;
                System.out.println(i);
            }
        }
        return number == sumDivisors;
    }
}