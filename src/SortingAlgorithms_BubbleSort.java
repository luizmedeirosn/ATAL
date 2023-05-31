import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms_BubbleSort {
    public static void main(String[] args) {
        // Check the number of numbers in the file
        final int QUANTITY = 100000;
        int[] arrayUnorderedNumbers = readRandomNumbersFile("./random-numbers-file.txt", QUANTITY);

        long startTime = System.currentTimeMillis();
        arrayUnorderedNumbers =  bubbleSort(arrayUnorderedNumbers);
        long endTime = System.currentTimeMillis();
        long timeTotal = endTime - startTime;

        System.out.println("Tempo gasto pelo algoritmo |bubbleSort| para ordenar " +
        QUANTITY + " elementos: " + timeTotal/1000 + " segundos");
    }

    private static int[] bubbleSort(int[] array) {
        boolean changed = true;
        for (int i = 0; i < array.length && changed; i++) {
            changed = false;
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j] > array[j+1]) {
                    int aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                    changed = true;
                }
            }
        }
        return array;
    }

    private static int[] readRandomNumbersFile(String path, int quantity) {
        int[] arrayUnorderedNumbers = new int[quantity];
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String line = br.readLine();
            while (line != null && i < quantity) {
                arrayUnorderedNumbers[i++] = Integer.parseInt(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayUnorderedNumbers;
    }
}
