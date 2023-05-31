import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms_InsertionSort {
    public static void main(String[] args) {
        // Check the number of numbers in the file
        final int QUANTITY = 100000;
        int[] arrayUnorderedNumbers = readRandomNumbersFile("./random-numbers-file.txt", QUANTITY);

        long startTime = System.currentTimeMillis();
        arrayUnorderedNumbers = insertionSort(arrayUnorderedNumbers);
        long endTime = System.currentTimeMillis();
        long timeTotal = endTime - startTime;

        System.out.println("Time spent by the algorithm |insertionSort| to sort " +
                QUANTITY + " elements: " + timeTotal + " milisseconds");

        for (int i : arrayUnorderedNumbers) System.out.println(i);
    }

    private static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int elected = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > elected) {
                array[j+1] = array[j];
                j -= 1;
            }

            array[j+1] = elected;
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
