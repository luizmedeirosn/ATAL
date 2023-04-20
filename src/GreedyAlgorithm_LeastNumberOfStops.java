import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class GreedyAlgorithm_LeastNumberOfStops {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int totalDistance = 0;
        int tankCapacity = 0;
        int numberOfStops = 0;
        int[] arrayOfStops = null;
        boolean invalidInput = true;

        do {
            try {
                totalDistance = sc.nextInt();
                tankCapacity = sc.nextInt();
                numberOfStops = sc.nextInt();
                arrayOfStops = new int[numberOfStops + 2];
                arrayOfStops[0] = 0;

                for (int i = 1; i < numberOfStops + 1; i++) {
                    arrayOfStops[i] = sc.nextInt();
                    if (arrayOfStops[i] <= arrayOfStops[i-1]) {
                        System.out.println("A distância da próxima parada deve ser maior que a distância da parada anterior!");
                        i--;
                    }
                }
                arrayOfStops[numberOfStops+1] = totalDistance;
                invalidInput = false;

            } catch (InputMismatchException e) {
                System.out.println("Entre com números inteiros válidos!");
                sc.next();
            }
        } while (invalidInput);

        System.out.println( findTheNumberOfStops(arrayOfStops, tankCapacity) );
        sc.close();
    }

    private static int findTheNumberOfStops(int[] arrayOfStops, int tankCapacity) {
        int travelledDistance = 0;
        int totalDistance = arrayOfStops[arrayOfStops.length - 1];
        final int RECHARGE = tankCapacity;
        int countStops = 0;
        int currentPoint;
        int futurePoint;

        for (int i = 0; travelledDistance + tankCapacity < totalDistance; i++) {
            tankCapacity -= arrayOfStops[i+1] - arrayOfStops[i];
            if (tankCapacity < 0) {
                return -1;
            }

            travelledDistance += arrayOfStops[i+1] - arrayOfStops[i];
            currentPoint = travelledDistance + tankCapacity;
            futurePoint = arrayOfStops[i+2];

            if (currentPoint <= futurePoint && currentPoint < totalDistance) {
                countStops++;
                tankCapacity = RECHARGE;
            }
        }
        return countStops;
    }
}
